package model.unit;

import model.civilizations.City;
import model.civilizations.Civilization;

public class Settler extends Unit {
    public Settler(Civilization belongTo) {
        super(UnitType.SETTLER, belongTo);
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
