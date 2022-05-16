package model.unit;

import model.Improvement;
import model.Message;
import model.land.TerrainType;
import model.technology.Technology;

import java.io.Serializable;
import java.util.Arrays;

public class Worker extends Unit implements Serializable {
//    private int workCounter;
    private int savedCounter;
    private Improvement savedImprovement = null;
    private Improvement inProgressImprovement = null;
    private boolean buildingRoad = false;
    private boolean buildingRailRoad = false;
    private boolean repairingImprovements = false;
    private boolean repairingRoads = false;
    private boolean destroyingFeature = false;

//    public Worker(Civilization belongTo) {
//        super(UnitType.WORKER, belongTo);
//    }

    public Worker(Unit unit) {
        super(UnitType.WORKER, unit.getCivilization(), unit.getTile().getPositionI(), unit.getTile().getPositionJ());
    }

    //This method must be run every turn in the game
    public Message work() {
        if (workCounter > 0) {
            workCounter--;
            if (workCounter == 0) {
                if (inProgressImprovement != null) {
                    super.getTile().setImprovement(inProgressImprovement);
                    inProgressImprovement = null;
                } else if (buildingRoad) {
                    super.getTile().setRoad(true);
                    buildingRoad = false;
                } else if (buildingRailRoad) {
                    super.getTile().setRailRoad(true);
                    buildingRailRoad = false;
                } else if (repairingImprovements) {
                    super.getTile().getImprovement().setPlundered(false);
                    repairingImprovements = false;
                } else if (repairingRoads) {
                    super.getTile().setRoadPlundered(false);
                    repairingRoads = false;
                } else if (destroyingFeature) {
                    super.getTile().removeFeature();
                    destroyingFeature = false;
                }
                setRemainMP(getMovePoint());
            }
        }
        return Message.OK;
    }

    public Message buildRoad() {
        if (workCounter != 0)
            return Message.busy;
        if (super.getCivilization().getReachedTechs().contains(Technology.THE_WHEEL)) {
            workCounter = 3;
            buildingRoad = true;
        }
        setRemainMP(0);
        return Message.OK;
    }

    public Message buildRailRoad() {
        //TODO: same as buildRoad() but may workCounter and technology different.
        if (workCounter != 0)
            return Message.busy;
        if (super.getCivilization().getReachedTechs().contains(Technology.THE_WHEEL)) { //TODO change this technologies
            workCounter = 3;
            buildingRailRoad = true;
        }
        setRemainMP(0);
        return Message.OK;
    }

    public void pauseImprovement() {
        if (workCounter == 0)
            return;
        savedCounter = workCounter;
        workCounter = 0;
        savedImprovement = inProgressImprovement;
    }

    public void resumeImprovement() {
        if (savedImprovement == null)
            return;
        workCounter = savedCounter;
        savedCounter = 0;
        inProgressImprovement = savedImprovement;
    }

    public Message buildImprovement(Improvement improvement) {
        if (workCounter != 0)
            return Message.busy;
        if (!super.getCivilization().getCities().contains(super.getTile().getCity()))
            return Message.improvementCityError;
        TerrainType landType = super.getTile().getType();
        TerrainType[] allowedLands = improvement.getFoundOn();
        if (!Arrays.asList(allowedLands).contains(landType))
            return Message.improvementLandError;
        if (!super.getCivilization().getReachedTechs().contains(improvement.getRequiredTechnology()))
            return Message.noTechnology;
        savedImprovement = null;
        workCounter = 6;
        inProgressImprovement = improvement;
        setRemainMP(0);
        return Message.OK;
    }

    public void destroyRoad() {
        super.getTile().setRoad(false);
        super.getTile().setRailRoad(false);
        super.getTile().setRoadPlundered(false);
        setRemainMP(0);
    }

    public Message destroyFeature() {
        if (workCounter != 0)
            return Message.busy;
        TerrainType feature;
        try {
            System.out.println(super.getTile());
            feature = super.getTile().getFeature();
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
        return Message.OK;
    }

    public Message repair() {
        if (workCounter != 0)
            return Message.busy;
        if (super.tile.getImprovement().isPlundered()) {
            workCounter = 3;
            repairingImprovements = true;
        } else if (super.tile.isRoadPlundered()) {
            workCounter = 3;
            repairingRoads = true;
        } else {
            return Message.invalidCommand;
        }
        setRemainMP(0);
        return Message.OK;
    }
}
