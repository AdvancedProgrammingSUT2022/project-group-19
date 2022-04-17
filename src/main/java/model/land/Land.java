package model.land;

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
}