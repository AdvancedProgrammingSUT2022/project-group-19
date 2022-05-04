package model.unit;

import model.Improvement;
import model.Message;
import model.civilizations.Civilization;
import model.land.TerrainType;
import model.technology.Technology;

import java.util.Arrays;

public class Worker extends Unit {
    private int workCounter;
    private Improvement inProgressImprovement = null;
    private boolean buildingRoad = false;
    private boolean buildingRailRoad = false;

    public Worker(Civilization belongTo) {
        super(UnitType.WORKER, belongTo);
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
                } else {
                    super.getTile().setRailRoad(true);
                    buildingRailRoad = false;
                }
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
        return Message.OK;
    }

    public void buildRailRoad() {

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
        workCounter = 6;
        inProgressImprovement = improvement;
        return Message.OK;
    }

    public void destroyRoad() {
        super.getTile().setRoad(false);
        super.getTile().setRailRoad(false);
    }

    public void destroyFeature() {
    }

    public void repair() {
    }
}
