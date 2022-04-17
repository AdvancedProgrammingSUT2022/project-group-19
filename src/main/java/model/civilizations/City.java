package model.civilizations;

import model.building.Building;
import model.game.Tile;
import model.unit.Unit;

import java.util.ArrayList;

public class City {
    private String name;
    private int defensivePower;
    private boolean isCapital;
    private int food;
    private int production;
    private int population;
    private ArrayList<Unit> units;
    private ArrayList<Tile> tiles;
    private ArrayList<Building> buildings;
}
