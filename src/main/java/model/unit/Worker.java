package model.unit;

import model.Improvement;
import model.civilizations.Civilization;
import model.land.TerrainType;
import model.technology.Technology;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Unit {
    public Worker(Civilization belongTo) {
        super(UnitType.WORKER, belongTo);
    }

    public void buildRoad() {
        if (super.getCivilization().getReachedTechs().contains(Technology.THE_WHEEL)) {
            super.setWorkCounter(3);
        }
    }

    public void buildRailRoad() {
    }

    public void buildImprovement(Improvement improvement) {
        TerrainType landType = super.getTile().getType();
        ArrayList<TerrainType> allowedLands = new ArrayList<>(List.of(improvement.getFoundOn()));
        if (allowedLands.contains(landType)) {
            super.setWorkCounter(6);
            //so on ...
        }
    }

    public void destroyFeature() {
    }

    public void destroyRoad() {
    }

    public void repair() {
    }
}
