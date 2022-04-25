package model.unit;

import model.GameMap;
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
    private int destinationI;
    private int destinationJ;
    private Tile tile;

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

    public void move(Unit unit, int destinationI, int destinationJ) {
        //Calculate the distance of the destination
//        int distance = 1;
//        remainMP -= distance;
//        if (remainMP >= 0) {
//            if (destination.getType().equals(LandType.RIVER))
//                remainMP = 0;
//            //move the unit
//        }
        if(checkIfMovePossible(unit, destinationI, destinationJ)){
            unit.setDestinationI(destinationI);
            unit.setDestinationJ(destinationJ);
            if(unit.getType().equals("military"))
                tile.setMilitaryUnit(null);
            else tile.setCivilianUnit(null);
            //TODO

        }else return;
    }

    public boolean checkIfMovePossible(GameMap gameMap, Unit unit, int destinationI, int destinationJ){
        return false;
    }

    public int getDestinationI() {
        return destinationI;
    }

    public void setDestinationI(int destinationI) {
        this.destinationI = destinationI;
    }

    public int getDestinationJ() {
        return destinationJ;
    }

    public void setDestinationJ(int destinationJ) {
        this.destinationJ = destinationJ;
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

    public UnitType getType() {
        return type;
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

    public int getMovePoint() {
        return movePoint;
    }

    public ResourceType getRequiredResource() {
        return requiredResource;
    }

    public Technology getRequiredTechnology() {
        return requiredTechnology;
    }

    public int getWorkCounter() {
        return workCounter;
    }

    public void setPosition(Tile position) {
        this.position = position;
    }

    public boolean isSleep() {
        return sleep;
    }

    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public int getRemainMP() {
        return remainMP;
    }

    public void setRemainMP(int remainMP) {
        this.remainMP = remainMP;
    }
}
