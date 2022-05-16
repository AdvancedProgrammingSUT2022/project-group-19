//package model.unit;
//
//import model.Improvement;
//import model.Message;
//import model.land.TerrainType;
//import model.technology.Technology;
//
//import java.io.Serializable;
//import java.util.Arrays;
//
//public class Worker extends Unit implements Serializable {
////    private int workCounter;
//    private int savedCounter;
//    private Improvement savedImprovement = null;
//    private Improvement inProgressImprovement = null;
//    private boolean buildingRoad = false;
//    private boolean buildingRailRoad = false;
//    private boolean repairingImprovements = false;
//    private boolean repairingRoads = false;
//    private boolean destroyingFeature = false;
//
////    public Worker(Civilization belongTo) {
////        super(UnitType.WORKER, belongTo);
////    }
//
//    public Worker(Unit unit) {
//        super(UnitType.WORKER, unit.getCivilization(), unit.getTile().getPositionI(), unit.getTile().getPositionJ());
//    }
//
//    //This method must be run every turn in the game
//    public Message work() {
//        if (workCounter > 0) {
//            System.out.println("i am working...");
//            workCounter--;
//            if (workCounter == 0) {
//                if (inProgressImprovement != null) {
//                    super.getTile().setImprovement(inProgressImprovement);
//                    super.getCivilization().log("Improvement " + inProgressImprovement + " build successfully");
//                    inProgressImprovement = null;
//                } else if (buildingRoad) {
//                    super.getTile().setRoad(true);
//                    super.getCivilization().log("Road build successfully in tile " + super.getTile().getPositionI() + "/" + super.getTile().getPositionJ());
//                    buildingRoad = false;
//                } else if (buildingRailRoad) {
//                    super.getTile().setRailRoad(true);
//                    super.getCivilization().log("RailRoad build successfully in tile " + super.getTile().getPositionI() + "/" + super.getTile().getPositionJ());
//                    buildingRailRoad = false;
//                } else if (repairingImprovements) {
//                    super.getTile().getImprovement().setPlundered(false);
//                    super.getCivilization().log("Improvement repaired successfully in tile " + super.getTile().getPositionI() + "/" + super.getTile().getPositionJ());
//                    repairingImprovements = false;
//                } else if (repairingRoads) {
//                    super.getTile().setRoadPlundered(false);
//                    super.getCivilization().log("Road repaired successfully in tile " + super.getTile().getPositionI() + "/" + super.getTile().getPositionJ());
//                    repairingRoads = false;
//                } else if (destroyingFeature) {
//                    super.getCivilization().log("Feature " + super.getTile().getFeature() + " removed successfully in tile " + super.getTile().getPositionI() + "/" + super.getTile().getPositionJ());
//                    super.getTile().removeFeature();
//                    destroyingFeature = false;
//                }
//                setRemainMP(getMovePoint());
//            }
//        }
//        return Message.OK;
//    }
//
//    public Message buildRoad() {
//        if (workCounter != 0) {
//            System.out.println("busy");
//            return Message.busy;
//        }
//        if (!super.getCivilization().getReachedTechs().contains(Technology.THE_WHEEL)) {
//            System.out.println("no tech :(");
//            return Message.noTechnology;
//        }
//        workCounter = 3;
//        buildingRoad = true;
//        super.getCivilization().log("Started building road in tile " + super.getTile().getPositionI() + "/" + super.getTile().getPositionJ());
//        setRemainMP(0);
//        return Message.OK;
//    }
//
//    public Message buildRailRoad() {
//        if (workCounter != 0)
//            return Message.busy;
//        if (super.getCivilization().getReachedTechs().contains(Technology.RAILROAD)) {
//            workCounter = 3;
//            buildingRailRoad = true;
//        }
//        super.getCivilization().log("Started building railroad in tile " + super.getTile().getPositionI() + "/" + super.getTile().getPositionJ());
//        setRemainMP(0);
//        return Message.OK;
//    }
//
//    public void pauseImprovement() {
//        if (workCounter == 0)
//            return;
//        savedCounter = workCounter;
//        workCounter = 0;
//        savedImprovement = inProgressImprovement;
//        super.getCivilization().log("Paused building improvement in tile " + super.getTile().getPositionI() + "/" + super.getTile().getPositionJ());
//    }
//
//    public void resumeImprovement() {
//        if (savedImprovement == null)
//            return;
//        workCounter = savedCounter;
//        savedCounter = 0;
//        inProgressImprovement = savedImprovement;
//        super.getCivilization().log("Resumed building improvement in tile " + super.getTile().getPositionI() + "/" + super.getTile().getPositionJ());
//    }
//
//    public Message buildImprovement(Improvement improvement) {
//        if (workCounter != 0)
//            return Message.busy;
//        if (!super.getCivilization().getCities().contains(super.getTile().getCity()))
//            return Message.improvementCityError;
//        TerrainType landType = super.getTile().getType();
//        TerrainType[] allowedLands = improvement.getFoundOn();
//        if (!Arrays.asList(allowedLands).contains(landType))
//            return Message.improvementLandError;
//        if (!super.getCivilization().getReachedTechs().contains(improvement.getRequiredTechnology()))
//            return Message.noTechnology;
//        savedImprovement = null;
//        workCounter = 6;
//        inProgressImprovement = improvement;
//        setRemainMP(0);
//        super.getCivilization().log("Started building improvement in tile " + super.getTile().getPositionI() + "/" + super.getTile().getPositionJ());
//        return Message.OK;
//    }
//
//    public void destroyRoad() {
//        super.getTile().setRoad(false);
//        super.getTile().setRailRoad(false);
//        super.getTile().setRoadPlundered(false);
//        setRemainMP(0);
//        super.getCivilization().log("Road destroyed in tile " + super.getTile().getPositionI() + "/" + super.getTile().getPositionJ());
//    }
//
//    public Message destroyFeature() {
//        if (workCounter != 0)
//            return Message.busy;
//        TerrainType feature;
//        try {
//            System.out.println(super.getTile());
//            feature = super.getTile().getFeature();
//        } catch (NullPointerException e) {
//            System.out.println("Exception:");
//            return Message.noRemovableFeature;
//        }
//        if (feature.equals(TerrainType.FOREST))
//            workCounter = 4;
//        else if (feature.equals(TerrainType.JUNGLE))
//            workCounter = 7;
//        else if (feature.equals(TerrainType.MARSH))
//            workCounter = 6;
//        else
//            return Message.noRemovableFeature;
//
//        destroyingFeature = true;
//        setRemainMP(0);
//        super.getCivilization().log("Started removing feature in tile " + super.getTile().getPositionI() + "/" + super.getTile().getPositionJ());
//        return Message.OK;
//    }
//
//    public Message repair() {
//        if (workCounter != 0)
//            return Message.busy;
//        if (super.tile.getImprovement().isPlundered()) {
//            workCounter = 3;
//            repairingImprovements = true;
//        } else if (super.tile.isRoadPlundered()) {
//            workCounter = 3;
//            repairingRoads = true;
//        } else {
//            return Message.invalidCommand;
//        }
//        super.getCivilization().log("started repairing improvement in tile " + super.getTile().getPositionI() + "/" + super.getTile().getPositionJ());
//        setRemainMP(0);
//        return Message.OK;
//    }
//}
