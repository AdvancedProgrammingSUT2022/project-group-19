package model.land;

import model.resource.ResourceType;

public enum     TerrainType {
    //features:
    NULL(0, 0, 0, 0, 0, null, null),

    JOLGE(2, 0, 0, -0.33, 1, null,
        new ResourceType[]{ResourceType.WHEAT, ResourceType.SUGAR}),

    FOREST(1, 1, 0, 0.25, 2, null,
        new ResourceType[]{ResourceType.GAZELLE, ResourceType.COLOR, ResourceType.SILK}),

    ICE(0, 0, 0, 0, 9999, null,
        new ResourceType[]{}),

    //جنگل انبوه = JUNGLE
    JUNGLE(1, -1, 0, 0.25, 2, null,
        new ResourceType[]{ResourceType.BANANA, ResourceType.COLOR}),

    MARSH(-1, 0, 0, -0.33, 2, null,
        new ResourceType[]{ResourceType.SUGAR}),

    OASIS(3, 0, 1, -0.33, 1, null,
        new ResourceType[]{}),



    //terrains:
    DESERT(0, 0, 0, -0.33, 1,
        new TerrainType[]{OASIS, JOLGE},
        new ResourceType[]{ResourceType.IRON, ResourceType.GOLD, ResourceType.SILVER, ResourceType.MARBLE,
            ResourceType.COTTON, ResourceType.INCENSE, ResourceType.SHEEP}),

    GRASS_LAND(2, 0, 0, -0.33, 1,
        new TerrainType[]{FOREST, MARSH},
        new ResourceType[]{ResourceType.IRON, ResourceType.HORSE, ResourceType.COAL, ResourceType.COW,
            ResourceType.GOLD, ResourceType.MARBLE, ResourceType.COTTON, ResourceType.SHEEP}),

    HILL(0, 2, 0, 0.25, 2,
        new TerrainType[]{FOREST, JUNGLE},
        new ResourceType[]{ResourceType.IRON, ResourceType.COAL, ResourceType.GAZELLE, ResourceType.GOLD,
            ResourceType.SILVER, ResourceType.SHEEP}),

    MOUNTAIN(0, 0, 0, 0, 9999,
        new TerrainType[]{},
        new ResourceType[]{}),

    OCEAN(0, 0, 0, 0, 9999,
        new TerrainType[]{},
        new ResourceType[]{}),

    PLAIN(1, 1, 0, -0.33, 1,
        new TerrainType[]{FOREST, JUNGLE},
        new ResourceType[]{ResourceType.IRON, ResourceType.HORSE, ResourceType.COAL, ResourceType.WHEAT, ResourceType.GOLD,
            ResourceType.MARBLE, ResourceType.IVORY, ResourceType.COTTON, ResourceType.INCENSE, ResourceType.SHEEP}),

    SNOW(0, 0, 0, -0.33, 1,
        new TerrainType[]{},
        new ResourceType[]{ResourceType.IRON}),

    TUNDRA(1, 0, 0, -0.33, 1,
        new TerrainType[]{FOREST},
        new ResourceType[]{ResourceType.IRON, ResourceType.HORSE, ResourceType.GAZELLE, ResourceType.SILVER, ResourceType.MARBLE});


    private final int food;
    private final int gold;
    private final int movePoint;
    private final int production;
    private final double fightChanges;
    private final TerrainType[] possibleFeatures;
    private final ResourceType[] possibleResources;

    TerrainType(int food, int production, int gold, double fightChanges, int movePoint, TerrainType[] possibleFeatures, ResourceType[] possibleResources) {
        this.food = food;
        this.gold = gold;
        this.movePoint = movePoint;
        this.production = production;
        this.fightChanges = fightChanges;
        this.possibleFeatures = possibleFeatures;
        this.possibleResources = possibleResources;
    }

    public int getFood() {
        return food;
    }

    public int getProduction() {
        return production;
    }

    public int getGold() {
        return gold;
    }

    public double getFightChanges() {
        return fightChanges;
    }

    public int getMovePoint() {
        return movePoint;
    }

    public TerrainType[] getPossibleFeatures() {
        return possibleFeatures;
    }

    public ResourceType[] getPossibleResources() {
        return possibleResources;
    }
}
