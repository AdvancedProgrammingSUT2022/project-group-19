package model.civilizations;

import model.Database;
import model.Message;
import model.building.Building;
import model.land.Tile;
import model.unit.Unit;
import model.unit.UnitType;

import java.util.ArrayList;

public class City {
    private String name;
    private int defensivePower;
    private boolean isCapital;
    private int food;
    private Production production;
    private int citizens;
    private int population;
    private ArrayList<Tile> tiles;
    private ArrayList<Building> buildings;
    private Unit inProductionUnit = null;
    private Unit savedUnit = null;
    private int productionCounter;
    private Unit militaryUnit = null;
    private Unit civilianUnit = null;
    private Civilization civilization;
    private boolean containSettler; //if a city have a settler => food field must not increase (Game doc, page 38)
    private final int positionI;
    private final int positionJ;
    private int cityIncome;


    public City(Civilization civilization, int x, int y) {
        this.civilization = civilization;
        positionI = x;
        positionJ = y;

        //add surrounded tiles to the city:
        Tile tile = null;
        for (int i = 0; i < 3; i++) {
            try {
                tile = Database.map[y - 1][x - 1 + i];
            } catch (Exception e) {
                continue;
            }
            if (tile.getCity() == null)
                tile.setCity(this);
        }
        for (int i = -1; i <= 1; i += 2) {
            try {
                tile = Database.map[y][x + i];
            } catch (Exception e) {
                continue;
            }
            if (tile.getCity() == null)
                tile.setCity(this);
        }
        try {
            tile = Database.map[y + 1][x];
        } catch (Exception ignored) {
        }
        if (tile.getCity() == null) {
            tile.setCity(this);
        }

    }

    //This methode must be run every turn of the game
    public Message cityProduction() {
        if (savedUnit != null && (savedUnit.isMilitary() && militaryUnit != null || !savedUnit.isMilitary() && civilianUnit != null))
            return Message.moveUnitFromCity;
        if (savedUnit != null) {
            if (savedUnit.isMilitary())
                militaryUnit = savedUnit;
            else
                civilianUnit = savedUnit;
            savedUnit = null;
        }
        if (inProductionUnit == null)
            return Message.noProduction;
        productionCounter--;
        if (productionCounter == 0) {
            savedUnit = inProductionUnit;
            inProductionUnit = null;
            if (savedUnit.isMilitary() && militaryUnit != null || !savedUnit.isMilitary() && civilianUnit != null)
                return Message.moveUnitFromCity;
            if (savedUnit.isMilitary())
                militaryUnit = savedUnit;
            else
                civilianUnit = savedUnit;
            savedUnit = null;
        }
        return Message.OK;
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
        if (!getAvailableUnitsForMake().contains(type))
            return Message.cantMakeUnit;
        if (type.getCost() > civilization.getGold())
            return Message.notEnoughGold;

        Unit newUnit = new Unit(type, civilization);
        civilization.decreaseGold(type.getCost());
        inProductionUnit = newUnit;
        productionCounter = type.getCost() / cityIncome + 1;
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
            return Message.notEnoughGold;
        civilization.decreaseGold(tilePrice);
        tiles.add(tile);
        tile.setCity(this);
        return Message.OK;
    }

    public void decreaseGoldAfterCityLoss() {

    }
}
