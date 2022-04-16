package model.land;

public enum LandType {
    //TODO: Implement resources that may be found on each terrain and feature:
    //TODO: Implement features that may be found on each terrain:
    //terrains:
    DESERT(0, 0, 0, -0.33, 1),
    GRASS_LAND(2, 0, 0, -0.33, 1),
    HILL(0, 2, 0, 0.25, 2),
    MOUNTAIN(0, 0, 0, 0, 9999),
    OCEAN(0, 0, 0, 0, 9999),
    PLAIN(1, 1, 0, -0.33, 1),
    SNOW(0, 0, 0, -0.33, 1),
    TUNDRA(1, 0, 0, -0.33, 1),

    //features:
    JOLGE(2, 0, 0, -0.33, 1),
    JUNGLE(1, 1, 0, 0.25, 2),
    ICE(0, 0, 0, 0, 9999),
    DARK_JUNGLE(1, -1, 0, 0.25, 2),
    SWAMP(-1, 0, 0, -0.33, 2),
    OASIS(3, 0, 1, -0.33, 1),
    RIVER(0, 0, 1, 0, -1);
    //TODO: Implement a mechanism that spoils all movePoints. for example: in RIVER, MP = -1 .

    private final int food;
    private final int gold;
    private final int movePoint;
    private final int production;
    private final double fightChanges;

    LandType(int food, int production, int gold, double fightChanges, int movePoint) {
        this.food = food;
        this.gold = gold;
        this.movePoint = movePoint;
        this.production = production;
        this.fightChanges = fightChanges;
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
}
