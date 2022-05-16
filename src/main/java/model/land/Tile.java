package model.land;

import model.Database;
import model.Improvement;
import model.Ruin;
import model.civilizations.City;
import model.resource.ResourceType;
import model.unit.Unit;
import java.util.ArrayList;

public class Tile {
    private int food;
    private int production;
    private int gold;
    private int movePoint;
    private double fightChanges;
    private final TerrainType type;
    private TerrainType feature;
    private final int positionI;
    private final int positionJ;
    private boolean isRoadPlundered = false;
    private ResourceType resource;
    private Unit militaryUnit = null;
    private Unit civilianUnit = null;
    private Improvement improvement;
    private int remainingTimeForBuildImprovement = 6;
    private Ruin ruin = null;
    private City city = null;
    private boolean[] isRiverOnBounds;
    private int riversNumber = 0;
    private Tile[] neighborOnBounds;
    private boolean haveRoad = false;
    private boolean isRoadRailed = false;
    private boolean assignedPerson = false;
    private boolean isCityCenter = false;


    public Tile(TerrainType type, TerrainType feature, int positionI, int positionJ) {
        this.positionI = positionI;
        this.positionJ = positionJ;
        this.isRiverOnBounds = new boolean[6];
        this.neighborOnBounds = new Tile[6];
        this.type = type;
        this.feature = feature;
        initTileValues();
    }

    private void initTileValues() {
        this.food = type.getFood() + feature.getFood();
        this.gold = type.getGold() + feature.getGold();
        this.movePoint = type.getMovePoint() + feature.getMovePoint();
        this.production = type.getProduction() + feature.getProduction();
        this.fightChanges = type.getFightChanges() + feature.getFightChanges();
    }

//    public void updateInSight() {
//        //algorithm goes here...
//        //update inSight field
//        if (inSight == fogOfWar)
//            fogOfWar = false;
//    }

    public TerrainType getType() {
        return type;
    }

//    public boolean isFogOfWar() {
//        return fogOfWar;
//    }
//
//    public void setFogOfWar(boolean fogOfWar) {
//        this.fogOfWar = fogOfWar;
//    }
//
//    public boolean isInSight() {
//        return inSight;
//    }
//
//    public void setInSight(boolean inSight) {
//        this.inSight = inSight;
//    }


    public Tile[] getNeighborOnBounds() {
        return neighborOnBounds;
    }

    public ArrayList<Tile> getNeighbors() {
        ArrayList<Tile> neighbors = new ArrayList<>();
        if (positionJ % 2 == 0) {   //if the tile is in even column

            for (int i = positionI - 1; i <= positionI; i++)
                for (int j = positionJ - 1; j <= positionJ + 1; j++) {
                    try {
                        neighbors.add(Database.map[i][j]);
                    } catch (Exception ignored) {
                    }
                }

            try {
                neighbors.add(Database.map[positionI + 1][positionJ]);
            } catch (Exception ignored) {
            }

        } else {    //if the tile is in odd column

            for (int i = positionI; i <= positionI + 1; i++)
                for (int j = positionJ - 1; j <= positionJ + 1; j++)
                    try {
                        neighbors.add(Database.map[i][j]);
                    } catch (Exception ignored) {
                    }

            try {
                neighbors.add(Database.map[positionI - 1][positionJ]);
            } catch (Exception ignored) {
            }

        }
        return neighbors;
    }

    public int getPositionI() {
        return positionI;
    }

    public int getPositionJ() {
        return positionJ;
    }

    public int getFood() {
        return food;
    }

    public int getProduction() {
        return production;
    }

    public int getGold() {
        return gold;
    }

    public int getMovePoint() {
        return movePoint;
    }

    public double getFightChanges() {
        return fightChanges;
    }

    public TerrainType getFeature() {
        return feature;
    }

    public ResourceType getResource() {
        return resource;
    }

    public void setResource(ResourceType resource) {
        this.resource = resource;
    }

    public Unit getMilitaryUnit() {
        return militaryUnit;
    }

    public void setMilitaryUnit(Unit militaryUnit) {
        this.militaryUnit = militaryUnit;
    }

    public Unit getCivilianUnit() {
        return civilianUnit;
    }

    public void setCivilianUnit(Unit civilianUnit) {
        this.civilianUnit = civilianUnit;
    }

    public Improvement getImprovement() {
        return improvement;
    }

    public void setImprovement(Improvement improvement) {
        this.improvement = improvement;
    }

    public int getRemainingTimeForBuildImprovement() {
        return remainingTimeForBuildImprovement;
    }

    public void setRuin(Ruin ruin) {
        this.ruin = ruin;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setIsRiverOnBounds(boolean[] isRiverOnBounds) {
        this.isRiverOnBounds = isRiverOnBounds;
    }

    public boolean[] getIsRiverOnBounds() {
        return isRiverOnBounds;
    }

    public void setRiversNumber(int riversNumber) {
        this.riversNumber = riversNumber;
    }

    public void setNeighborOnBounds(Tile[] neighborOnBounds) {
        this.neighborOnBounds = neighborOnBounds;
    }

    public void setRoad(boolean haveRoad) {
        this.haveRoad = haveRoad;
    }

    public void setRailRoad(boolean roadRailed) {
        this.isRoadRailed = roadRailed;
    }

    public void setRemainingTimeForBuildImprovement(int remainingTimeForBuildImprovement) {
        this.remainingTimeForBuildImprovement = remainingTimeForBuildImprovement;
    }

    public boolean isRoadPlundered() {
        return isRoadPlundered;
    }

    public void setRoadPlundered(boolean roadPlundered) {
        isRoadPlundered = roadPlundered;
    }

    public City getCity() {
        return city;
    }

    public void removeFeature() {
        feature = TerrainType.NULL;
    }

    public boolean isAssignedPerson() {
        return assignedPerson;
    }

    public void setAssignedPerson(boolean assignedPerson) {
        this.assignedPerson = assignedPerson;
    }

    public boolean isCityCenter() {
        return isCityCenter;
    }

    public void setCityCenter(boolean cityCenter) {
        isCityCenter = cityCenter;
    }

    public void deleteCivilianUnit() {
        this.civilianUnit = null;
    }

    public void deleteMilitaryUnit(){
        this.militaryUnit = null;
    }
}