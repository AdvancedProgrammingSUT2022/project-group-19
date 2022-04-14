package model.people;

import model.Technology;
import model.resources.ResourceType;

public enum UnitType {
    ARCHER(70, 4, 6, 2, 2, null, Technology.ARCHERY),
    CHARIOT_ARCHER(60, 3, 6, 2, 4, ResourceType.HOURSE, Technology.WHEEL),
    SCOUT(25, 4, 0, 0, 2, null, null),
    SETTLER(89, 0, 0, 0, 2, null, null),
    SPEARMAN(50, 7, 0, 0, 2, null, Technology.BRONZE_WORK),
    WARRIOR(40, 6, 0, 0, 2, null, null),
    WORKER(70, 0, 0, 0, 2, null, null);

    private final int cost;
    private final int power;
    private final int rangedPower;
    private final int range;
    private final int move;
    private final ResourceType requiredResource;
    private final Technology requiredTechnology;

    UnitType(int cost, int power, int rangedPower, int range, int move, ResourceType requiredResource, Technology requiredTechnology) {
        this.cost = cost;
        this.power = power;
        this.rangedPower = rangedPower;
        this.range = range;
        this.move = move;
        this.requiredResource = requiredResource;
        this.requiredTechnology = requiredTechnology;
    }

    public int getCost() {
        return cost;
    }

    public int getPower() {
        return power;
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

    public ResourceType getRequiredResource() {
        return requiredResource;
    }

    public Technology getRequiredTechnology() {
        return requiredTechnology;
    }
}
