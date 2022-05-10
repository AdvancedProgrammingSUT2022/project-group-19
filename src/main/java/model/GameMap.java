package model;

import model.land.Tile;

public class GameMap {
    private static int numOfCols;
    private static int numOfRows;
    private Tile[][] map;

    public GameMap(int numOfRows,int numOfCols, Tile[][] map) {
        GameMap.numOfCols = numOfCols;
        GameMap.numOfRows = numOfRows;
        this.map = map;
    }

    public Tile[][] getMap() {
        return map;
    }

    public void setMap(Tile[][] map) {
        this.map = map;
    }

    public static int getNumOfCols() {
        return numOfCols;
    }

    public static int getNumOfRows() {
        return numOfRows;
    }
}
