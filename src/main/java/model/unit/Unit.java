package model.unit;

import model.GameMap;
import model.civilizations.City;
import model.civilizations.Civilization;
import model.land.Tile;
import model.technology.Technology;
import model.resource.ResourceType;

import javax.sound.midi.MidiFileFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

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
    //private Tile position;
    private boolean sleep = false;
    private boolean assigned = false;
    private int remainMP;
    private int positionI;
    private int positionJ;
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

    // TODO: 4/28/2022 دوستان توابع بخش حرکت داره اینجا زده میشه لطفا از زدن توابع مشابه بپرهیزید !!!!!!!

    public void move(GameMap gameMap, Unit unit, int destinationI, int destinationJ) {

        ArrayList<Tile> way = computeBestWay(unit.tile, gameMap.getMap()[destinationI][destinationJ], new ArrayList<>(), null);
        if (checkIfMovePossible(way, unit)) {
            unit.setDestinationI(destinationI);
            unit.setDestinationJ(destinationJ);
            //مختصات i , j توی یونیت ذخیره شده
            //باید موقع حرکت یونیت هر دو تغییر کنن و تایل هم باید تغییر کنه
            //باید برای حالتی که حرکت ممکن نبود پیامی برای ویو فرستاده شود!!
            if (unit.getType().equals("military")) tile.setMilitaryUnit(null);
            else tile.setCivilianUnit(null);
            //TODO

        }
    }
    //با توجه به موو پوینت مسیر و یونیت امکان مهاجرت یک یونیت به مقصد را بررسی میکند
    public boolean checkIfMovePossible(ArrayList<Tile> way, Unit unit) {
        int wayMovePoint = 0;
        for (Tile tile : way) {
            wayMovePoint += tile.getMovePoint();
        }
        if (unit.getMovePoint() >= wayMovePoint) return true;
        return false;
    }
    //بهترین مسیر را محاسبه میکند
    public ArrayList<Tile> computeBestWay(Tile origin, Tile destination, ArrayList<Tile> route, ArrayList<Tile> bestWay) {
        if (bestWay != null && route.size() > bestWay.size()) return bestWay;
        if (origin == destination) return route;
        Tile[] neighbors = origin.getNeighborOnBounds();
        int distance2 = (destination.getPositionI() - origin.getPositionI()) * (destination.getPositionI() - origin.getPositionI()) + (destination.getPositionJ() - origin.getPositionJ()) * (destination.getPositionJ() - origin.getPositionJ());
        for (Tile neighbor : neighbors) {
            int newDistance2 = (destination.getPositionI() - neighbor.getPositionI()) * (destination.getPositionI() - neighbor.getPositionI()) + (destination.getPositionJ() - neighbor.getPositionJ()) * (destination.getPositionJ() - neighbor.getPositionJ());
            if (newDistance2 < distance2) {
                // TODO: 4/28/2022 باید رودخانه و مناطق صعب العبور اضافه شود
                ArrayList<Tile> temp = new ArrayList<>();
                temp.addAll(route);
                temp.add(neighbor);
                ArrayList<Tile> test = computeBestWay(neighbor, destination, temp, bestWay);
                if (bestWay == null || test.size() < bestWay.size()) bestWay = test;
            }
        }
        return bestWay;
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

    public int getPositionI() {
        return positionI;
    }

    public int getPositionJ() {
        return positionJ;
    }

    public Tile getTile() {
        return tile;
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
