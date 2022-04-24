package model.land;

import model.Improvement;
import model.Ruin;
import model.civilizations.City;
import model.resource.ResourceType;
import model.unit.Unit;

import java.util.ArrayList;

public class Tile {
    private final int food;
    private final int production;
    private final int gold;
    private final int movePoint;
    private final double fightChanges;
    private final TerrainType type;
    private final TerrainType feature;
    private ResourceType[] resources;
    private Unit militaryUnit;
    private Unit civilianUnit;
    private Improvement improvement;
    private int remainingTimeForBuildImprovement = 6;
    private Ruin ruin = null;
    private City city;
    private boolean[] isRiverOnBounds;
    private int riversNumber = 0;
    private Tile[] neighborOnBounds;
    private boolean haveRoad = false;
    private boolean isRoadRailed = false;


    public Tile(TerrainType type, TerrainType feature) {
        this.isRiverOnBounds = new boolean[6];
        this.neighborOnBounds = new Tile[6];
        this.type = type;
        this.feature = feature;
        this.food = type.getFood() + feature.getFood();

        this.gold = type.getGold() + feature.getGold();
        this.movePoint = type.getMovePoint() + feature.getMovePoint();
        this.production = type.getProduction() + feature.getProduction();
        this.fightChanges = type.getFightChanges() + feature.getFightChanges();
        this.resources = null;
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

    public ResourceType[] getResources() {
        return resources;
    }

    public void setResources(ResourceType[] resources) {
        this.resources = resources;
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

    public void setRemainingTimeForBuildImprovement(int remainingTimeForBuildImprovement) {
        this.remainingTimeForBuildImprovement = remainingTimeForBuildImprovement;
    }
}