package model;

import model.land.Land;

public class GameMap {
    private final int mapLength = 10;
    private final int mapWidth = 5;
    private Land[][] map = new Land[mapLength][mapWidth];

    public Land[][] getMap() {
        return map;
    }

    public void setMap(Land[][] map) {
        this.map = map;
    }

    public void generateMap() {
        //generate a random map
        //generate ruins
        //generate cities
        //generate ...
        Land[][] newMap = new Land[mapLength][mapWidth];
        map = newMap;
    }
}
