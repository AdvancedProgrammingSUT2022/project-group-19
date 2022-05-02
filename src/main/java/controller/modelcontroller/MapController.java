package controller.modelcontroller;

import model.GameMap;
import model.land.TerrainType;
import model.land.Tile;
import model.resource.ResourceType;

import java.util.Random;

public class MapController {
    public void printMap(GameMap gameMap){

    }
    public GameMap generateRandomMap(int length, int width) {
        Tile[][] tiles = new Tile[length][width];
        tiles[length / 2][width / 2] = new Tile(TerrainType.PLAIN, TerrainType.NULL, length / 2, width / 2);
        fillMapByRandomDfs(tiles, length, width);
        findNeighbors(tiles, length, width);
        // TODO: 4/25/2022 اضافه کردن رودخانه ها و ریسورس ها

        return new GameMap(length, width, tiles);

    }

    public void fillMapByRandomDfs(Tile[][] tiles, int length, int width) {
        Random random = new Random();
        int minGround = (length - 2) * (width - 2) / 2 + (random.nextInt(100)) * (length - 2) * (width - 2) / 200;
        int filledGround = 0;
        while (filledGround < minGround) {
            for (int i = 1; i < length - 1; i++) {
                for (int j = 1; j < width - 1; j++) {
                    if (tiles[i - 1][j] != null || tiles[i + 1][j] != null || tiles[i][j - 1] != null || tiles[i][j + 1] != null) {
                        if (tiles[i][j] == null && random.nextInt() % 3 == 0) {
                            TerrainType terrainType = chooseRandomTerrain();
                            tiles[i][j] = new Tile(terrainType, chooseRandomFeature(terrainType), i, j);
                            tiles[i][j].setResource(generateRandomResource(tiles[i][j].getType()));
                            filledGround++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (tiles[i][j] == null) {
                    tiles[i][j] = new Tile(TerrainType.OCEAN, TerrainType.NULL, i, j);
                }
            }
        }

    }

    public TerrainType chooseRandomTerrain() {
        Random random = new Random();

        switch (random.nextInt(10)) {
            case 0:
            case 7:
                return TerrainType.DESERT;
            case 1:
                return TerrainType.GRASS_LAND;
            case 8:
            case 2:
                return TerrainType.HILL;
            case 3:
                return TerrainType.MOUNTAIN;
            case 4:
                return TerrainType.TUNDRA;
            case 5:
            case 9:
                return TerrainType.PLAIN;
            case 6:
                return TerrainType.SNOW;
        }
        return TerrainType.PLAIN;
    }

    public TerrainType chooseRandomFeature(TerrainType terrain) {
        Random random = new Random();
        TerrainType[] possibleFeatures = terrain.getPossibleFeatures();
        for (TerrainType feature : possibleFeatures) {
            if (random.nextInt() % possibleFeatures.length == 0) {
                return feature;
            }
        }
        return TerrainType.NULL;
    }

    private ResourceType generateRandomResource(TerrainType type) {
        //TODO this method
        if (type.equals(TerrainType.OCEAN))
            return null;

        Random random = new Random();
        switch (random.nextInt(6)){
            case 1:
                return ResourceType.IRON;
            case 2:
                return ResourceType.COAL;
            case 3:
                return ResourceType.GOLD;
            default:
                return null;
        }
    }

    public void findNeighbors(Tile[][] tiles, int length, int width) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int neighborsNum = 0;
                Tile[] neighbors = new Tile[6];
                if (j % 2 == 0) {
                    if (j > 0) {
                        neighbors[0] = tiles[i][j - 1];
                        neighborsNum++;
                    } else {
                        neighbors[0] = null;
                    }
                    if (j > 0 && i > 0) {
                        neighbors[1] = tiles[i - 1][j - 1];
                        neighborsNum++;
                    } else {
                        neighbors[1] = null;
                    }
                    if (i > 0) {
                        neighbors[2] = tiles[i - 1][j];
                        neighborsNum++;
                    } else {
                        neighbors[2] = null;
                    }
                    if (j < width - 1) {
                        neighbors[3] = tiles[i][j + 1];
                        neighborsNum++;
                    } else {
                        neighbors[3] = null;
                    }
                    if (i < length - 1) {
                        neighbors[4] = tiles[i + 1][j];
                        neighborsNum++;
                    } else {
                        neighbors[4] = null;
                    }
                    if (j > 0 && i < length - 1) {
                        neighbors[5] = tiles[i + 1][j - 1];
                        neighborsNum++;
                    } else {
                        neighbors[5] = null;
                    }
                    return;
                } else {
                    if (j > 0) {
                        neighbors[0] = tiles[i][j - 1];
                        neighborsNum++;
                    } else {
                        neighbors[0] = null;
                    }
                    if (i > 0) {
                        neighbors[1] = tiles[i - 1][j];
                        neighborsNum++;
                    } else {
                        neighbors[1] = null;
                    }
                    if (j < width - 1 && i > 0) {
                        neighbors[2] = tiles[i - 1][j + 1];
                        neighborsNum++;
                    } else {
                        neighbors[2] = null;
                    }
                    if (j < width - 1) {
                        neighbors[3] = tiles[i][j + 1];
                        neighborsNum++;
                    } else {
                        neighbors[3] = null;
                    }
                    if (j < width - 1 && i < length - 1) {
                        neighbors[4] = tiles[i + 1][j + 1];
                        neighborsNum++;
                    } else {
                        neighbors[4] = null;
                    }
                    if (i < length - 1) {
                        neighbors[5] = tiles[i + 1][j];
                        neighborsNum++;
                    } else {
                        neighbors[5] = null;
                    }
                }
                tiles[i][j].setNeighborOnBounds(neighbors);
            }
        }
    }
}
