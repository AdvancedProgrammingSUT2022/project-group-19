package model.land;

import model.Improvement;
import model.Ruin;
import model.resource.ResourceType;
import model.unit.Unit;

public class Land {
    private boolean fogOfWar = true;
    private boolean inSight = false;
    private final int food;
    private final int production;
    private final int gold;
    private final int movePoint;
    private final double fightChanges;
    private final LandType type;
    private final LandType feature;
    private ResourceType[] resources;
    private Unit militaryUnit;
    private Unit civilianUnit;
    private Improvement improvement;
    private int remainingTimeForBuildImprovement = 6;
    private Ruin ruin = null;


    public Land(LandType type, LandType feature) {
        this.type = type;
        this.feature = feature;
        this.food = type.getFood() + feature.getFood();
        this.gold = type.getGold() + feature.getGold();
        this.movePoint = type.getMovePoint() + feature.getMovePoint();
        this.production = type.getProduction() + feature.getProduction();
        this.fightChanges = type.getFightChanges() + feature.getFightChanges();
        this.resources = null;
        //TODO: a function to choose random resources form
        // type.getPossibleResources() and put them into this.resources
    }

    public void updateInSight() {
        //algorithm goes here...
        //update inSight field
        if (inSight == fogOfWar)
            fogOfWar = false;
    }

    public LandType getType() {
        return type;
    }

    public boolean isFogOfWar() {
        return fogOfWar;
    }

    public void setFogOfWar(boolean fogOfWar) {
        this.fogOfWar = fogOfWar;
    }

    public boolean isInSight() {
        return inSight;
    }

    public void setInSight(boolean inSight) {
        this.inSight = inSight;
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

    public LandType getFeature() {
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