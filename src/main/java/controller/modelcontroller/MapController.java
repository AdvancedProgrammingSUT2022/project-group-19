package controller.modelcontroller;

import model.Database;
import model.GameMap;
import model.land.TerrainType;
import model.land.Tile;
import model.resource.ResourceType;

import java.util.Random;

public class MapController {
    public void printMap(GameMap gameMap) {

    }

    public GameMap generateRandomMap(int numOfRows, int numOfCols) {
        Tile[][] tiles = new Tile[numOfRows][numOfCols];
        tiles[1][1] = new Tile(TerrainType.PLAIN, TerrainType.NULL, 1, 1);

        fillMapByRandomDfs(tiles, numOfRows, numOfCols);
        findNeighbors(tiles, numOfRows, numOfCols);
        return new GameMap(numOfRows, numOfCols, tiles);

    }

    public void fillMapByRandomDfs(Tile[][] tiles, int length, int width) {
        Random random = new Random();
        int minGround = (length - 2) * (width - 2) / 2 + (random.nextInt(100)) * (length - 2) * (width - 2) / 200;
        int filledGround = 0;
        while (filledGround < minGround) {
            for (int i = 1; i < length - 1; i++) {
                for (int j = 1; j < width - 1; j++) {
                    if (tiles[i - 1][j] != null || tiles[i + 1][j] != null || tiles[i][j - 1] != null || tiles[i][j + 1] != null) {
                        if (random.nextInt() % 3 == 0 && tiles[i][j] == null) {
                            TerrainType terrainType = chooseRandomTerrain();
                            tiles[i][j] = new Tile(terrainType, chooseRandomFeature(terrainType, i), i, j);
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

    public TerrainType chooseRandomFeature(TerrainType terrain, int i) {
        Random random = new Random();
        TerrainType[] possibleFeatures = terrain.getPossibleFeatures();
        for (TerrainType feature : possibleFeatures) {
            if ((i == 5 || i == 6) && random.nextInt() % 2 == 0) return TerrainType.JOLGE;
            else if (random.nextInt() % possibleFeatures.length == 0) {
                return feature;
            }
        }
        return TerrainType.NULL;
    }

    private ResourceType generateRandomResource(TerrainType terrain) {
        Random random = new Random();
        ResourceType[] possibleResources = terrain.getPossibleResources();
        if (terrain.equals(TerrainType.OCEAN)) return null;
        for (ResourceType Resource : possibleResources) {
            if (random.nextInt() % possibleResources.length == 0) {
                return Resource;
            }
        }
        return ResourceType.NULL;
    }


    public void findNeighbors(Tile[][] tiles, int length, int width) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int neighborsNum = 0;
                Tile[] neighbors = new Tile[6];
                if (i % 2 == 0) {
                    if (i > 0) {
                        neighbors[0] = tiles[i - 1][j];
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
                    if (j > 0) {
                        neighbors[2] = tiles[i][j - 1];
                        neighborsNum++;
                    } else {
                        neighbors[2] = null;
                    }
                    if (i < length - 1) {
                        neighbors[3] = tiles[i + 1][j];
                        neighborsNum++;
                    } else {
                        neighbors[3] = null;
                    }
                    if (j < width - 1) {
                        neighbors[4] = tiles[i][j + 1];
                        neighborsNum++;
                    } else {
                        neighbors[4] = null;
                    }
                    if (j < width - 1 && i > 0) {
                        neighbors[5] = tiles[i - 1][j + 1];
                        neighborsNum++;
                    } else {
                        neighbors[5] = null;
                    }
                } else {
                    if (i > 0) {
                        neighbors[0] = tiles[i - 1][j];
                        neighborsNum++;
                    } else {
                        neighbors[0] = null;
                    }
                    if (j > 0) {
                        neighbors[1] = tiles[i][j - 1];
                        neighborsNum++;
                    } else {
                        neighbors[1] = null;
                    }
                    if (j > 0 && i < length - 1) {
                        neighbors[2] = tiles[i + 1][j - 1];
                        neighborsNum++;
                    } else {
                        neighbors[2] = null;
                    }
                    if (i < length - 1) {
                        neighbors[3] = tiles[i + 1][j];
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
                    if (j < width - 1) {
                        neighbors[5] = tiles[i][j + 1];
                        neighborsNum++;
                    } else {
                        neighbors[5] = null;
                    }
                }
                tiles[i][j].setNeighborOnBounds(neighbors);
                //System.out.println(neighborsNum);
            }
        }
    }
}
