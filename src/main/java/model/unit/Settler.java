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
        //TODO: settler self destruction
    }

    public void cityExpansion() {

    }

    public void foodConsumption() {

    }

}
