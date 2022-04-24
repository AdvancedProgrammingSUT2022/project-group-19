package model.civilizations;

import model.building.Building;
import model.land.Tile;
import model.unit.Unit;
import model.unit.UnitType;

import java.util.ArrayList;

public class City {
    private String name;
    private int defensivePower;
    private boolean isCapital;
    private int food;
    private Production production;
    private int citizens;
    private int population;
    private ArrayList<Unit> units;
    private ArrayList<Tile> tiles;
    private ArrayList<Building> buildings;
    private Unit militarySettledUnit;
    private Unit civilianSettledUnit;
    private Civilization civilization;
    private boolean containSettler; //if a city have a settler => food field must not increase (Game doc, page 38)

    public void makeUnit(UnitType type){
        Unit newUnit = new Unit(type,civilization);
        units.add(newUnit);
    }


    public void purchaseTile() {
        //decrease gold after purchasing
    }

    public void decreaseGoldAfterCityLoss() {

    }
}
