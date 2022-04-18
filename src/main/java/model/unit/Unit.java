package model.unit;

import model.civilizations.Civilization;
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
    private Civilization civilization;
    private int workCounter;
    private Land position;

    public Unit(UnitType type, Civilization belongTo) {
        this.type = type;
        this.cost = type.getCost();
        this.power = type.getPower();
        this.rangedPower = type.getRangedPower();
        this.range = type.getRange();
        this.movePoint = type.getMovePoint();
        this.requiredResource = type.getRequiredResource();
        this.requiredTechnology = type.getRequiredTechnology();
        this.civilization = belongTo;
    }

    public UnitType getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getRangedPower() {
        return rangedPower;
    }

    public void setRangedPower(int rangedPower) {
        this.rangedPower = rangedPower;
    }

    public int getRange() {
        return range;
    }

    public int getMovePoint() {
        return movePoint;
    }

    public void setMovePoint(int movePoint) {
        this.movePoint = movePoint;
    }

    public ResourceType getRequiredResource() {
        return requiredResource;
    }

    public Technology getRequiredTechnology() {
        return requiredTechnology;
    }

    public Civilization getCivilization() {
        return civilization;
    }

    public void setCivilization(Civilization civilization) {
        this.civilization = civilization;
    }

    public int getWorkCounter() {
        return workCounter;
    }

    public void setWorkCounter(int workCounter) {
        this.workCounter = workCounter;
    }

    public void decreaseWorkCounter() {
        if (workCounter > 0)
            workCounter -= 1;
    }

    public Land getPosition() {
        return position;
    }

    public void setPosition(Land position) {
        this.position = position;
    }
}
