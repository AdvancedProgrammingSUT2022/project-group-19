package model.unit;

import model.civilizations.City;
import model.civilizations.Civilization;

import java.io.Serializable;

public class Settler extends Unit implements Serializable {
    public Settler(Unit unit) {
        super(UnitType.SETTLER, unit.getCivilization(), unit.getTile().getPositionI(), unit.getTile().getPositionJ());
    }

    public void buildCity() {
        int x = super.tile.getPositionI();
        int y = super.tile.getPositionJ();
        City city = new City(super.getCivilization(), x, y);
        super.getCivilization().addCity(city);
        super.getCivilization().log("City founded successfully in tile " + super.getTile().getPositionI() + "/" + super.getTile().getPositionJ());
        this.deleteUnit();
    }

    public void cityExpansion() {

    }

    public void foodConsumption() {

    }

}
