package model.unit;

import model.Database;
import model.GameMap;
import model.Improvement;
import model.Message;
import model.civilizations.City;
import model.civilizations.Civilization;
import model.land.TerrainType;
import model.land.Tile;
import model.technology.Technology;
import model.resource.ResourceType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Unit implements Serializable {
    private final UnitType type;
    private final int cost;
    private final int power; // قدرت نظامی
    private int currentPower; // قدرت نظامی موجود
    private final int defensivePower; // قدرت دفاعی
    private int currentDefensivePower; // قدرت دفاعی موجود
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


    //////worker fields:
    private int savedCounter;
    private Improvement savedImprovement = null;
    private Improvement inProgressImprovement = null;
    private boolean buildingRoad = false;
    private boolean buildingRailRoad = false;
    private boolean repairingImprovements = false;
    private boolean repairingRoads = false;
    private boolean destroyingFeature = false;


    public Unit(UnitType type, Civilization belongTo, int x, int y) {
        this.type = type;
        this.cost = type.getCost();
        this.power = type.getPower();
        this.defensivePower = 10;
        this.currentDefensivePower = power;
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

        civilization.addUnit(this);
    }

    //must be called each turn
    public void resetMP() {
        remainMP = movePoint;
        assigned = false;
    }

    // TODO: 4/28/2022 دوستان توابع بخش حرکت داره اینجا زده میشه لطفا از زدن توابع مشابه بپرهیزید !!!!!!!

    public void moveOrder(GameMap gameMap, Unit unit, int destinationI, int destinationJ) {

        ArrayList<Tile> way = computeBestWay(unit.tile, gameMap.getMap()[destinationI][destinationJ], new ArrayList<>(), null);
        unit.setWay(way);
    }

    //با توجه به موو پوینت مسیر و یونیت امکان مهاجرت یک یونیت به مقصد را بررسی میکند
    public void move() {
        while (getWay().size() > 0 && getRemainMP() > 0) {
            Tile nextTile = getWay().get(0);
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
            if (getRemainMP() < 0) setRemainMP(0);
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
            int movePointOfIt = neighbor.getMovePoint();
            int newDistance2 = (destination.getPositionI() - neighbor.getPositionI()) * (destination.getPositionI() - neighbor.getPositionI()) + (destination.getPositionJ() - neighbor.getPositionJ()) * (destination.getPositionJ() - neighbor.getPositionJ());
            if (newDistance2 < (distance2) && movePointOfIt < 10) {
                ArrayList<Tile> temp = new ArrayList<>();
                temp.addAll(route);
                temp.add(neighbor);
                ArrayList<Tile> test = computeBestWay(neighbor, destination, temp, bestWay);
                //System.out.println(test.size());
                if (bestWay == null || test.size() < bestWay.size()) bestWay = test;
            }
//            else if (newDistance2 > distance2 && neighbor != null && neighbor.getMovePoint() < 10) {
//                ArrayList<Tile> temp = new ArrayList<>();
//                temp.addAll(route);
//                temp.add(neighbor);
//                ArrayList<Tile> test = computeBestWay(neighbor, destination, temp, bestWay);
//                if (bestWay == null || test.size() < bestWay.size()) bestWay = test;
//            }
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
        setSleep(true);
        ArrayList<Tile> tiles = getTile().getNeighbors();
        for (Tile tile : tiles) {
            if (tile.getMilitaryUnit() != null) {
                while (!isAssigned()) {
                    //TODO assign a task to military unit :)
                }
                break;
            }
        }
    }

    public void garrison() {
        setSleep(true);
        Tile tiles[] = tile.getNeighborOnBounds();
        for(Tile tile : tiles){
            if(getCivilization().equals(getTile().getCity().getCivilization())){
                currentPower = power * 120/100;
                break;
            }
        }
    }

    public void reinforcement() {
        setSleep(true);
        currentDefensivePower = defensivePower * 120/100;
    }

    public void fullReinforcement() {
        setSleep(true);
        if(currentDefensivePower < defensivePower)
            currentDefensivePower = defensivePower;
    }

    public void deleteUnit() {
        if(this.isMilitary())
            getTile().deleteMilitaryUnit();
        else
            getTile().deleteCivilianUnit();
    }

    public void cancel() {
        setAssigned(false);
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

    public void attack() {
        //This method can be combined with move method
    }

    public ArrayList<Tile> getVisibleArea() {
        return null;
    }

    public void giveBattleReward() {

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
        if (way == null) {
            return Message.noWay;
        }
        if (getRemainMP() == 0) {
            return Message.assigned;
        }
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




    ////////////worker methods:
    //This method must be run every turn in the game
    public Message work() {
        if (workCounter > 0) {
            System.out.println("i am working...");
            workCounter--;
            if (workCounter == 0) {
                if (inProgressImprovement != null) {
                    this.getTile().setImprovement(inProgressImprovement);
                    this.getCivilization().log("Improvement " + inProgressImprovement + " build successfully");
                    inProgressImprovement = null;
                } else if (buildingRoad) {
                    this.getTile().setRoad(true);
                    this.getCivilization().log("Road build successfully in tile " + this.getTile().getPositionI() + "/" + this.getTile().getPositionJ());
                    buildingRoad = false;
                } else if (buildingRailRoad) {
                    this.getTile().setRailRoad(true);
                    this.getCivilization().log("RailRoad build successfully in tile " + this.getTile().getPositionI() + "/" + this.getTile().getPositionJ());
                    buildingRailRoad = false;
                } else if (repairingImprovements) {
                    this.getTile().getImprovement().setPlundered(false);
                    this.getCivilization().log("Improvement repaired successfully in tile " + this.getTile().getPositionI() + "/" + this.getTile().getPositionJ());
                    repairingImprovements = false;
                } else if (repairingRoads) {
                    this.getTile().setRoadPlundered(false);
                    this.getCivilization().log("Road repaired successfully in tile " + this.getTile().getPositionI() + "/" + this.getTile().getPositionJ());
                    repairingRoads = false;
                } else if (destroyingFeature) {
                    this.getCivilization().log("Feature " + this.getTile().getFeature() + " removed successfully in tile " + this.getTile().getPositionI() + "/" + this.getTile().getPositionJ());
                    this.getTile().removeFeature();
                    destroyingFeature = false;
                }
                setRemainMP(getMovePoint());
            }
        }
        return Message.OK;
    }

    public Message buildRoad() {
        if (workCounter != 0) {
            System.out.println("busy");
            return Message.busy;
        }
        if (!this.getCivilization().getReachedTechs().contains(Technology.THE_WHEEL)) {
            System.out.println("no tech :(");
            return Message.noTechnology;
        }
        workCounter = 3;
        buildingRoad = true;
        this.getCivilization().log("Started building road in tile " + this.getTile().getPositionI() + "/" + this.getTile().getPositionJ());
        setRemainMP(0);
        return Message.OK;
    }

    public Message buildRailRoad() {
        if (workCounter != 0)
            return Message.busy;
        if (this.getCivilization().getReachedTechs().contains(Technology.RAILROAD)) {
            workCounter = 3;
            buildingRailRoad = true;
        }
        this.getCivilization().log("Started building railroad in tile " + this.getTile().getPositionI() + "/" + this.getTile().getPositionJ());
        setRemainMP(0);
        return Message.OK;
    }

    public void pauseImprovement() {
        if (workCounter == 0)
            return;
        savedCounter = workCounter;
        workCounter = 0;
        savedImprovement = inProgressImprovement;
        this.getCivilization().log("Paused building improvement in tile " + this.getTile().getPositionI() + "/" + this.getTile().getPositionJ());
    }

    public void resumeImprovement() {
        if (savedImprovement == null)
            return;
        workCounter = savedCounter;
        savedCounter = 0;
        inProgressImprovement = savedImprovement;
        this.getCivilization().log("Resumed building improvement in tile " + this.getTile().getPositionI() + "/" + this.getTile().getPositionJ());
    }

    public Message buildImprovement(Improvement improvement) {
        System.out.println("imp");
        if (workCounter != 0)
            return Message.busy;
        if (!this.getCivilization().getCities().contains(this.getTile().getCity()))
            return Message.improvementCityError;
        TerrainType landType = this.getTile().getType();
        TerrainType[] allowedLands = improvement.getFoundOn();
        if (!Arrays.asList(allowedLands).contains(landType))
            return Message.improvementLandError;
        if (!this.getCivilization().getReachedTechs().contains(improvement.getRequiredTechnology()))
            return Message.noTechnology;
        System.out.println("started building...");
        savedImprovement = null;
        workCounter = 6;
        inProgressImprovement = improvement;
        setRemainMP(0);
        this.getCivilization().log("Started building improvement in tile " + this.getTile().getPositionI() + "/" + this.getTile().getPositionJ());
        return Message.OK;
    }

    public void destroyRoad() {
        this.getTile().setRoad(false);
        this.getTile().setRailRoad(false);
        this.getTile().setRoadPlundered(false);
        setRemainMP(0);
        this.getCivilization().log("Road destroyed in tile " + this.getTile().getPositionI() + "/" + this.getTile().getPositionJ());
    }

    public Message destroyFeature() {
        if (workCounter != 0)
            return Message.busy;
        TerrainType feature;
        try {
            System.out.println(this.getTile());
            feature = this.getTile().getFeature();
        } catch (NullPointerException e) {
            System.out.println("Exception:");
            return Message.noRemovableFeature;
        }
        if (feature.equals(TerrainType.FOREST))
            workCounter = 4;
        else if (feature.equals(TerrainType.JUNGLE))
            workCounter = 7;
        else if (feature.equals(TerrainType.MARSH))
            workCounter = 6;
        else
            return Message.noRemovableFeature;

        destroyingFeature = true;
        setRemainMP(0);
        this.getCivilization().log("Started removing feature in tile " + this.getTile().getPositionI() + "/" + this.getTile().getPositionJ());
        return Message.OK;
    }

    public Message repair() {
        if (workCounter != 0)
            return Message.busy;
        if (this.tile.getImprovement().isPlundered()) {
            workCounter = 3;
            repairingImprovements = true;
        } else if (this.tile.isRoadPlundered()) {
            workCounter = 3;
            repairingRoads = true;
        } else {
            return Message.invalidCommand;
        }
        this.getCivilization().log("started repairing improvement in tile " + this.getTile().getPositionI() + "/" + this.getTile().getPositionJ());
        setRemainMP(0);
        return Message.OK;
    }
}