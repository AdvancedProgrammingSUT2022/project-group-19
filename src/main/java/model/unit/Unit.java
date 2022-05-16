package model.unit;

import model.Database;
import model.GameMap;
import model.Message;
import model.civilizations.City;
import model.civilizations.Civilization;
import model.land.Tile;
import model.technology.Technology;
import model.resource.ResourceType;

import java.io.Serializable;
import java.util.ArrayList;

public class Unit implements Serializable {
    private final UnitType type;
    private final int cost;
    private final int power;
    private final int rangedPower;
    private final int range;
    private final int movePoint;
    private final ResourceType requiredResource;
    private final Technology requiredTechnology;
    private Civilization civilization;
    protected int workCounter;
    private boolean sleep = false;
    private boolean assigned = false;
    private int remainMP;
    //هر تایلی تو خودش مختصات آی و جی ذخیره کرده و مختصات آی و جی یونیتو از همون جا میگیریم
    protected Tile tile;
    private ArrayList<Tile> way = new ArrayList<>();

    public Unit(UnitType type, Civilization belongTo, int x, int y) {
        this.type = type;
        this.cost = type.getCost();
        this.power = type.getPower();
        this.rangedPower = type.getRangedPower();
        this.range = type.getRange();
        this.movePoint = type.getMovePoint();
        this.requiredResource = type.getRequiredResource();
        this.requiredTechnology = type.getRequiredTechnology();
        this.civilization = belongTo;
        this.remainMP = this.movePoint;


        this.tile = Database.map[x][y];
        if (this.isMilitary())
            this.tile.setMilitaryUnit(this);
        else
            this.tile.setCivilianUnit(this);
    }

    //must be called each turn
    public void resetMP() {
        remainMP = movePoint;
        assigned = false;
    }

    // TODO: 4/28/2022 دوستان توابع بخش حرکت داره اینجا زده میشه لطفا از زدن توابع مشابه بپرهیزید !!!!!!!

    //با توجه به موو پوینت مسیر و یونیت امکان مهاجرت یک یونیت به مقصد را بررسی میکند
    public void move() {
        while (getRemainMP() > 0) {
            Tile nextTile = getWay().get(0);
            if (nextTile.getMovePoint() < getRemainMP()) {
                if (nextTile.getMilitaryUnit() != null && nextTile.getCivilianUnit() != null) break;

                if (nextTile.getMilitaryUnit() != null) {
                    if (!getCivilization().equals((nextTile.getMilitaryUnit()).getCivilization()) || getPower() != 0)
                        break;
                }
                if (nextTile.getCivilianUnit() != null) {
                    if (!getCivilization().equals((nextTile.getCivilianUnit()).getCivilization()) || getPower() == 0)
                        break;
                }
                if (getPower() != 0) tile.setMilitaryUnit(null);
                else tile.setCivilianUnit(null);
                int j = tile.getPositionJ();
                tile = nextTile;
                int newJ = tile.getPositionJ();
                if (getPower() != 0) tile.setMilitaryUnit(this);
                else tile.setCivilianUnit(this);
                setRemainMP(getRemainMP() - nextTile.getMovePoint());
                if (j == 5 && newJ == 6 || j == 6 && newJ == 5) setRemainMP(0);
                getWay().remove(0);

            } else break;
        }

    }

    //بهترین مسیر را محاسبه میکند
    public ArrayList<Tile> computeBestWay(Tile origin, Tile destination, ArrayList<Tile> route, ArrayList<Tile> bestWay) {
        if (bestWay != null && route.size() > bestWay.size()) return bestWay;
        if (origin == destination) return route;
        Tile[] neighbors = origin.getNeighborOnBounds();
        int distance2 = (destination.getPositionI() - origin.getPositionI()) * (destination.getPositionI() - origin.getPositionI()) + (destination.getPositionJ() - origin.getPositionJ()) * (destination.getPositionJ() - origin.getPositionJ());
        int counter = 0;
        for (Tile neighbor : neighbors) {
            if (neighbor == null) break;
            counter++;
            int newDistance2 = (destination.getPositionI() - neighbor.getPositionI()) * (destination.getPositionI() - neighbor.getPositionI()) + (destination.getPositionJ() - neighbor.getPositionJ()) * (destination.getPositionJ() - neighbor.getPositionJ());
            if (newDistance2 <= distance2 && neighbor != null && neighbor.getMovePoint() < 10) {
                ArrayList<Tile> temp = new ArrayList<>();
                temp.addAll(route);
                temp.add(neighbor);
                ArrayList<Tile> test = computeBestWay(neighbor, destination, temp, bestWay);
                if (bestWay == null || test.size() < bestWay.size()) bestWay = test;
            } else if (newDistance2 > distance2 && neighbor != null && neighbor.getMovePoint() < 10) {
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

    public void upgrade() {

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

//    public void setWorkCounter(int workCounter) {
//        this.workCounter = workCounter;
//    }


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

//    public int getWorkCounter() {
//        return workCounter;
//    }


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

    public ArrayList<Tile> getWay() {
        return way;
    }

    public void setWay(ArrayList<Tile> way) {
        this.way = way;
    }

    public boolean isMilitary() {
        return !(type.equals(UnitType.WORKER) || type.equals(UnitType.SETTLER));
    }

    public Message moveOrder(int x, int y) {
        //دستور حرکت
        Tile[][] map = Database.gameMap.getMap();
        ArrayList<Tile> way = computeBestWay(tile, map[x][y], new ArrayList<>(), null);
        setWay(way);
        move();
        return Message.OK;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public int getWorkCounter() {
        return workCounter;
    }


    //کد تابع move طیب
    public Message freeMove(int x, int y) {
        Tile destination = Database.map[x][y];

        if ((this.isMilitary() && destination.getMilitaryUnit() != null) ||
                (!this.isMilitary() && destination.getCivilianUnit() != null)) {
            System.out.println("In the destination tile we have a military unit: " + destination.getMilitaryUnit() + ". and a civilian unit: " + destination.getCivilianUnit());
            return Message.destinationIsFull;
        }
        System.out.println("In tile " + tile.getPositionI() + " " + tile.getPositionJ() + " we have a military unit: " + this.tile.getMilitaryUnit() + ". and a civilian unit: " + this.tile.getCivilianUnit());
        System.out.println("In tile " + destination.getPositionI() + " " + destination.getPositionJ() + " we have a military unit: " + this.tile.getMilitaryUnit() + ". and a civilian unit: " + this.tile.getCivilianUnit());

        if (this.isMilitary()) {
            this.tile.setMilitaryUnit(null);
        } else {
            this.tile.setCivilianUnit(null);
        }
        System.out.println("In tile " + tile.getPositionI() + " " + tile.getPositionJ() + " we have a military unit: " + this.tile.getMilitaryUnit() + ". and a civilian unit: " + this.tile.getCivilianUnit());
        this.tile = destination;

        if (this.isMilitary())
            this.tile.setMilitaryUnit(this);
        else
            this.tile.setCivilianUnit(this);
        System.out.println("In tile " + tile.getPositionI() + " " + tile.getPositionJ() + " we have a military unit: " + this.tile.getMilitaryUnit() + ". and a civilian unit: " + this.tile.getCivilianUnit());

//        this.assigned = true;
        return Message.OK;
    }
}