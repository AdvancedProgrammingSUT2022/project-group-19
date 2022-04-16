package model.unit;

import model.land.Land;
import model.land.LandType;
import model.technology.Technology;
import model.resource.ResourceType;

public class Unit {
    private final UnitType type;
    private final int cost;
    private int power;
    private int rangedPower;
    private final int range;
    private int movePoint;
    private final ResourceType requiredResource;
    private final Technology requiredTechnology;


    public Unit(UnitType type) {
        this.type = type;
        this.cost = type.getCost();
        this.power = type.getPower();
        this.rangedPower = type.getRangedPower();
        this.range = type.getRange();
        this.movePoint = type.getMovePoint();
        this.requiredResource = type.getRequiredResource();
        this.requiredTechnology = type.getRequiredTechnology();
    }


    public void move(Land destination) {
        //Calculate the distance of the destination
        int distance = 1;
        movePoint -= distance;
        if (movePoint >= 0) {
            if (destination.getType().equals(LandType.RIVER))
                movePoint = 0;
            //move the unit
        }
    }

    public void sleep() {}

    public void standby() {}

    public void reinforcement() {}

    public void fullReinforcement() {}

    public void settle() {}

    public void plunder() {}

    public void cancel() {}

    public void wakeUp() {}

    public void removeUnit() {}

}
