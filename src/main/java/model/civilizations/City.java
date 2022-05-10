package model.civilizations;

import model.Database;
import model.Message;
import model.building.Building;
import model.land.Tile;
import model.unit.Unit;
import model.unit.UnitType;

import java.util.ArrayList;

public class City {
    private String name = "Unnamed City";
    private int defensivePower;
    private boolean isCapital;
    private int food;
    private Production production;
    private int citizens;
    private int idleCitizens;
    private int population;
    private ArrayList<Tile> tiles;
    private ArrayList<Building> buildings;
    private Unit inProductionUnit = null;
    private Unit savedUnit = null;
    private int productionCounter;
    private Unit militaryUnit = null;
    private Unit civilianUnit = null;
    private Civilization civilization;
    private boolean containSettler = false; //if a city have a settler => food field must not increase (Game doc, page 38)
    private final int positionI;
    private final int positionJ;
    private int cityIncome;
    private Building inBuildBuilding = null;
    private boolean isAssigned = false;

    public City(Civilization civilization, int x, int y) {
        this.civilization = civilization;
        civilization.addCity(this);
        Database.map[x][y].setCityCenter(true);
        positionI = x;
        positionJ = y;

        //add surrounded tiles to the city:
        Tile tile;
        for (int i = -1; i <= 1; i++) {
            try {
                tile = Database.map[x + 1][y + i];
            } catch (Exception e) {
                continue;
            }
            if (tile.getCity() == null)
                tile.setCity(this);
        }
        for (int i = -1; i <= 1; i++) {
            try {
                tile = Database.map[x][y + i];
            } catch (Exception e) {
                continue;
            }
            if (tile.getCity() == null)
                tile.setCity(this);
        }
        try {
            tile = Database.map[x - 1][y];
            if (tile.getCity() == null) {
                tile.setCity(this);
            }
        } catch (Exception ignored) {
        }
    }

    //This methode must be run every turn of the game
    public Message cityProduction() {
        if (savedUnit != null) { //force the player to move the unit
            if (savedUnit.isMilitary() && militaryUnit != null || !savedUnit.isMilitary() && civilianUnit != null)
                return Message.moveUnitFromCity;
            if (savedUnit.isMilitary())
                militaryUnit = savedUnit;
            else
                civilianUnit = savedUnit;
            savedUnit = null;
        }

        if (productionCounter > 0) {
            productionCounter--;
            if (productionCounter == 0) {
                if (inBuildBuilding != null) {
                    buildings.add(inBuildBuilding);
                    inBuildBuilding = null;
                } else {
                    savedUnit = inProductionUnit;
                    inProductionUnit = null;
                    if (savedUnit.isMilitary() && militaryUnit != null || !savedUnit.isMilitary() && civilianUnit != null)
                        return Message.moveUnitFromCity; //TODO: force the player to move the unit
                    if (savedUnit.isMilitary())
                        militaryUnit = savedUnit;
                    else
                        civilianUnit = savedUnit;
                    savedUnit = null;
                }
            }
        }
        return Message.OK;
    }

    public void freePersonFromTile(Tile tile) {
        tile.setAssignedPerson(false);
        idleCitizens++;
    }

    public Message assignPersonToTile(Tile tile) {
        if (idleCitizens == 0)
            return Message.noIdlePerson;
        if (tile.isAssignedPerson())
            return Message.tileHasPerson;
        tile.setAssignedPerson(true);
        idleCitizens--;
        return Message.OK;
    }

    public void randomAssignPersonToTiles() {
        for (Tile tile : tiles) {
            if (idleCitizens == 0)
                break;
            tile.setAssignedPerson(true);
            idleCitizens--;
        }
    }

    public ArrayList<UnitType> getAvailableUnitsForMake() {
        ArrayList<UnitType> units = new ArrayList<>();
        for (UnitType unitType : UnitType.values())
            if (civilization.getReachedTechs().contains(unitType.getRequiredTechnology()))
                if (civilization.getResources().contains(unitType.getRequiredResource()))
                    units.add(unitType);
        return units;
    }

    public Message makeUnit(UnitType type) {
        if (productionCounter > 0)
            return Message.busy;
        if (!getAvailableUnitsForMake().contains(type))
            return Message.cantMakeUnit;
        if (type.getCost() > civilization.getGold())
            return Message.noEnoughGold;

        Unit newUnit = new Unit(type, civilization);
        civilization.decreaseGold(type.getCost());
        inProductionUnit = newUnit;
        productionCounter = type.getCost() / cityIncome + 1;
        return Message.OK;
    }

    public ArrayList<Building> getAvailableBuildingsForBuild() {
        ArrayList<Building> buildingsList = new ArrayList<>();
        for (Building building : Building.values())
            if (civilization.getReachedTechs().contains(building.getRequiredTechnology()))
                buildingsList.add(building);
        buildingsList.removeAll(this.buildings);
        return buildingsList;
    }

    public Message buildBuilding(Building building) {
        if (productionCounter > 0)
            return Message.busy;
        if (!getAvailableUnitsForMake().contains(building))
            return Message.noTechnology;
        if (building.getCost() > civilization.getGold())
            return Message.noEnoughGold;
        productionCounter = building.getCost() / cityIncome + 1;
        inBuildBuilding = building;
        return Message.OK;
    }

    public Message purchaseTile(int x, int y) {
        int tilePrice = 100;
        Tile tile;
        try {
            tile = Database.map[x][y];
        } catch (Exception e) {
            return Message.invalidIndex;
        }
        if (tile.getCity() != null)
            return Message.tileHasOwner;
        if (tilePrice > civilization.getGold())
            return Message.noEnoughGold;
        civilization.decreaseGold(tilePrice);
        tiles.add(tile);
        tile.setCity(this);
        return Message.OK;
    }


    public void decreaseGoldAfterCityLoss() {

    }

    public String getName() {
        return this.name;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public Civilization getCivilization() {
        return civilization;
    }

    public void setCivilization(Civilization civilization) {
        this.civilization = civilization;
    }
}
