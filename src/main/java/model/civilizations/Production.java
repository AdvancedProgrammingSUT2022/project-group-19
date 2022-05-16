package model.civilizations;

import model.building.Building;
import model.unit.Unit;

import java.io.Serializable;

public class Production implements Serializable {
    Unit unit;
    Building building;
    int remainingTurns;
}
