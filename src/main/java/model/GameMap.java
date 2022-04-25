package model;

import model.land.Tile;

public class GameMap {
    private int mapLength;
    private int mapWidth;
    private Tile[][] map;

    public GameMap(int mapLength, int mapWidth, Tile[][] map) {
        this.mapLength = mapLength;
        this.mapWidth = mapWidth;
        this.map = map;
    }

    public Tile[][] getMap() {
        return map;
    }

    public void setMap(Tile[][] map) {
        this.map = map;
    }

    public int getMapLength() {
        return mapLength;
    }

    public int getMapWidth() {
        return mapWidth;
    }
}
