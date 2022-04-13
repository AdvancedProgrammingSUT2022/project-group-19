package model.lands;

public enum LandType {
    //lands:
    DESERT(0, 0, 0, -33, 1),
    GRASS_LAND(2, 0, 0, -33, 1),
    HILL(0, 2, 0, 25, 2),
    MOUNTAIN(0, 0, 0, 0, 9999),
    OCEAN(0, 0, 0, 0, 9999),
    PLAIN(1, 1, 0, -33, 1),
    SNOW(0, 0, 0, -33, 1),
    TUNDRA(1, 0, 0, -33, 1),

    //features:
    JOLGE(2,0,0,-33,1),
    JUNGEL(1,1,0,25,2),
    ICE(0,0,0,0,9999),
    DARK_JUNGLE(1,-1,0,25,2),
    SWAMP(-1,0,0,-33,2),
    OASIS(3, 0, 1, -33, 1);

    private final int food;
    private final int production;
    private final int gold;
    private final int fightChanges;
    private final int movePoint;

    LandType(int food, int production, int gold, int fightChanges, int movePoint) {
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.fightChanges = fightChanges;
        this.movePoint = movePoint;
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

    public int getFightChanges() {
        return fightChanges;
    }

    public int getMovePoint() {
        return movePoint;
    }
}
