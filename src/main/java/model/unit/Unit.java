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

}
