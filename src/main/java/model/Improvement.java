package model;

import model.land.LandType;
import model.technology.Technology;

public enum Improvement {
    CAMP(0, 0, 0, Technology.TRAPPING,
        new LandType[]{LandType.JUNGLE, LandType.TUNDRA, LandType.PLAIN, LandType.HILL}),

    FARM(1, 0, 0, Technology.AGRICULTURE,
        new LandType[]{LandType.PLAIN, LandType.DESERT, LandType.GRASS_LAND}),

    LUMBER_MILL(0, 1, 0, Technology.CONSTRUCTION,
        new LandType[]{LandType.JUNGLE}),

    MINE(0, 1, 0, Technology.MINING,
        new LandType[]{LandType.PLAIN, LandType.DESERT, LandType.GRASS_LAND, LandType.TUNDRA, LandType.SNOW,
            LandType.HILL, LandType.JUNGLE, LandType.DARK_JUNGLE, LandType.SWAMP,}),

    PASTURE(0, 0, 0, Technology.ANIMAL_HUSBANDRY,
        new LandType[]{LandType.PLAIN, LandType.DESERT, LandType.GRASS_LAND, LandType.TUNDRA, LandType.HILL}),

    FARMING(0, 0, 0, Technology.CALENDER,
        new LandType[]{LandType.PLAIN, LandType.DESERT, LandType.GRASS_LAND, LandType.JUNGLE, LandType.DARK_JUNGLE,
            LandType.SWAMP, LandType.JOLGE}),

    STONE_MINE(0, 0, 0, Technology.MASONRY,
        new LandType[]{LandType.PLAIN, LandType.DESERT, LandType.GRASS_LAND, LandType.TUNDRA, LandType.HILL}),

    TRADING_POST(0, 0, 1, Technology.TRAPPING,
        new LandType[]{LandType.PLAIN, LandType.DESERT, LandType.GRASS_LAND, LandType.TUNDRA}),

    FACTORY(0, 2, 0, Technology.ENGINEERING,
        new LandType[]{LandType.PLAIN, LandType.DESERT, LandType.GRASS_LAND, LandType.TUNDRA, LandType.SNOW});

    private final int food;
    private final int production;
    private final int gold;
    private final Technology requiredTechnology;
    private final LandType[] foundOn;

    Improvement(int food, int production, int gold, Technology requiredTechnology, LandType[] foundOn) {
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.requiredTechnology = requiredTechnology;
        this.foundOn = foundOn;
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

    public Technology getRequiredTechnology() {
        return requiredTechnology;
    }

    public LandType[] getFoundOn() {
        return foundOn;
    }
}
