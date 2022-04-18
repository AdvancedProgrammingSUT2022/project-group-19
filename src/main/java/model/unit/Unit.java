package model.unit;

import model.civilizations.Civilization;
import model.land.Land;
import model.technology.Technology;
import model.resource.ResourceType;

public class Unit {
    private final UnitType type;
    private final int cost;
    private final int power;
    private final int rangedPower;
    private final int range;
    private final int movePoint;
    private final ResourceType requiredResource;
    private final Technology requiredTechnology;
    private Civilization civilization;
    private int workCounter;
    private Land position;
    private boolean sleep = false;
    private boolean assigned = false;
    private int remainMP;

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

    public void resetMP(){
        remainMP = movePoint;
        assigned = false;
    }

    public void move(Land destination) {
        //Calculate the distance of the destination
//        int distance = 1;
//        remainMP -= distance;
//        if (remainMP >= 0) {
//            if (destination.getType().equals(LandType.RIVER))
//                remainMP = 0;
//            //move the unit
//        }
    }

    public void sleep() {
        sleep = true;
    }

    public void wakeUp() {
        sleep = false;
    }

    public void standby() {
        assigned = true;
    }


    public Civilization getCivilization() {
        return civilization;
    }

    public void setCivilization(Civilization civilization) {
        this.civilization = civilization;
    }

    public void setWorkCounter(int workCounter) {
        this.workCounter = workCounter;
    }

    public Land getPosition() {
        return position;
    }
}
