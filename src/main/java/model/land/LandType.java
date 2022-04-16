package model.land;

import model.resource.ResourceType;

public enum LandType {
    //features:
    JOLGE(2, 0, 0, -0.33, 1, null,
        new ResourceType[]{ResourceType.WHEAT, ResourceType.SUGAR}),

    JUNGLE(1, 1, 0, 0.25, 2, null,
        new ResourceType[]{ResourceType.GAZELLE, ResourceType.COLOR, ResourceType.SILK}),

    ICE(0, 0, 0, 0, 9999, null,
        new ResourceType[]{}),

    DARK_JUNGLE(1, -1, 0, 0.25, 2, null,
        new ResourceType[]{ResourceType.BANANA, ResourceType.COLOR}),

    SWAMP(-1, 0, 0, -0.33, 2, null,
        new ResourceType[]{ResourceType.SUGAR}),

    OASIS(3, 0, 1, -0.33, 1, null,
        new ResourceType[]{}),

    RIVER(0, 0, 1, 0, 0, null,
        new ResourceType[]{}),


    //terrains:
    DESERT(0, 0, 0, -0.33, 1,
        new LandType[]{OASIS, JOLGE},
        new ResourceType[]{ResourceType.IRON, ResourceType.GOLD, ResourceType.SILVER, ResourceType.MARBLE,
            ResourceType.COTTON, ResourceType.INCENSE, ResourceType.SHEEP}),

    GRASS_LAND(2, 0, 0, -0.33, 1,
        new LandType[]{JUNGLE, SWAMP},
        new ResourceType[]{ResourceType.IRON, ResourceType.HORSE, ResourceType.COAL, ResourceType.COW,
            ResourceType.GOLD, ResourceType.MARBLE, ResourceType.COTTON, ResourceType.SHEEP}),

    HILL(0, 2, 0, 0.25, 2,
        new LandType[]{JUNGLE, DARK_JUNGLE},
        new ResourceType[]{ResourceType.IRON, ResourceType.COAL, ResourceType.GAZELLE, ResourceType.GOLD,
            ResourceType.SILVER, ResourceType.SHEEP}),

    MOUNTAIN(0, 0, 0, 0, 9999,
        new LandType[]{},
        new ResourceType[]{}),

    OCEAN(0, 0, 0, 0, 9999,
        new LandType[]{},
        new ResourceType[]{}),

    PLAIN(1, 1, 0, -0.33, 1,
        new LandType[]{JUNGLE, DARK_JUNGLE},
        new ResourceType[]{ResourceType.IRON, ResourceType.HORSE, ResourceType.COAL, ResourceType.WHEAT, ResourceType.GOLD,
            ResourceType.MARBLE, ResourceType.IVORY, ResourceType.COTTON, ResourceType.INCENSE, ResourceType.SHEEP}),

    SNOW(0, 0, 0, -0.33, 1,
        new LandType[]{},
        new ResourceType[]{ResourceType.IRON}),

    TUNDRA(1, 0, 0, -0.33, 1,
        new LandType[]{JUNGLE},
        new ResourceType[]{ResourceType.IRON, ResourceType.HORSE, ResourceType.GAZELLE, ResourceType.SILVER, ResourceType.MARBLE});


    private final int food;
    private final int gold;
    private final int movePoint;
    private final int production;
    private final double fightChanges;
    private final LandType[] possibleFeatures;
    private final ResourceType[] possibleResources;

    LandType(int food, int production, int gold, double fightChanges, int movePoint, LandType[] possibleFeatures, ResourceType[] possibleResources) {
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

    public LandType[] getPossibleFeatures() {
        return possibleFeatures;
    }

    public ResourceType[] getPossibleResources() {
        return possibleResources;
    }
}
