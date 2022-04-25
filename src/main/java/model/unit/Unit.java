package model.unit;

import model.civilizations.City;
import model.civilizations.Civilization;
import model.land.Tile;
import model.technology.Technology;
import model.resource.ResourceType;

import java.util.ArrayList;

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
    private Tile position;
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

    public void resetMP() {
        remainMP = movePoint;
        assigned = false;
    }

    public void move(Tile destination) {
        //Calculate the distance of the destination
//        int distance = 1;
//        remainMP -= distance;
//        if (remainMP >= 0) {
//            if (destination.getType().equals(LandType.RIVER))
//                remainMP = 0;
//            //move the unit
//        }
    }

    public boolean checkIfMovePossible(Unit unit, int destinationI, int destinationJ){
        return false;
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

    public void readyAndAlter() {
    }

    public void reinforcement() {
    }

    public void fullReinforcement() {
    }

    public void settle() {
    }

    public void prepareRangedAttack() {

    }

    public void rangedAttack(Tile land) {

    }

    public void coldWeaponAttackToCity(City enemyCity) {

    }

    public void plunder() { //غارت

    }

    public void cancel() {

    }

    public void removeUnit() {

    }

    public void Attack(Tile land) {
        //This method can be combined with move method
    }

    public ArrayList<Tile> getVisibleArea() {
        return null;
    }

    public void giveBattleReward() {

    }

    public void fortify() {

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

    public Tile getPosition() {
        return position;
    }
}
