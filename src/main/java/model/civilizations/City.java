package model.civilizations;

import model.Database;
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
    private final int positionI;
    private final int positionJ;

    public City(Civilization civilization, int x, int y) {
        this.civilization = civilization;
        positionI = x;
        positionJ = y;

        //add surrounded tiles to the city:
        Tile tile = null;
        for (int i = 0; i < 3; i++) {
            try {
                tile = Database.map[y - 1][x - 1 + i];
            } catch (Exception e) {
                continue;
            }
            if (tile.getCity() == null)
                tile.setCity(this);
        }
        for (int i = -1; i <= 1; i += 2) {
            try {
                tile = Database.map[y][x + i];
            } catch (Exception e) {
                continue;
            }
            if (tile.getCity() == null)
                tile.setCity(this);
        }
        try {
            tile = Database.map[y + 1][x];
        } catch (Exception ignored){}
        if (tile.getCity() == null) {
            tile.setCity(this);
        }

    }

    public void makeUnit(UnitType type) {
        Unit newUnit = new Unit(type, civilization);
        units.add(newUnit);
    }


    public void purchaseTile() {
        //decrease gold after purchasing
    }

    public void decreaseGoldAfterCityLoss() {

    }
}
