package model.people;

import model.Technology;
import model.resources.ResourceType;

public class Unit {
    private final UnitType type;
    private final int cost;
    private final int power;
    private final int rangedPower;
    private final int range;
    private final int move;
    private final ResourceType requiredResource;
    private final Technology requiredTechnology;
    // todo ( ertegha ?? )


    public Unit(UnitType type) {
        this.type = type;
        this.cost = type.getCost();
        this.power = type.getPower();
        this.rangedPower = type.getRangedPower();
        this.range = type.getRange();
        this.move = type.getMove();
        this.requiredResource = type.getRequiredResource();
        this.requiredTechnology = type.getRequiredTechnology();
    }

    public UnitType getType() {
        return type;
    }

    public int getRangedPower() {
        return rangedPower;
    }

    public int getRange() {
        return range;
    }

    public int getMove() {
        return move;
    }

    public int getPower() {
        return power;
    }

    public void move(){}

    public void sleep(){}

    public void standby(){}

    public void reinforcement(){}

    public void fullReinforcement(){}

    public void settle(){}

    public void plunder(){}

    public void cancel(){}

    public void wakeUp(){}

    public void removeUnit(){}

}
