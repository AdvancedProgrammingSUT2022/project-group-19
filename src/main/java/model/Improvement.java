package model;

import model.land.TerrainType;
import model.technology.Technology;

public enum Improvement {
    CAMP(0, 0, 0, Technology.TRAPPING,
        new TerrainType[]{TerrainType.FOREST, TerrainType.TUNDRA, TerrainType.PLAIN, TerrainType.HILL}),

    FARM(1, 0, 0, Technology.AGRICULTURE,
        new TerrainType[]{TerrainType.PLAIN, TerrainType.DESERT, TerrainType.GRASS_LAND}),

    LUMBER_MILL(0, 1, 0, Technology.CONSTRUCTION,
        new TerrainType[]{TerrainType.FOREST}),

    MINE(0, 1, 0, Technology.MINING,
        new TerrainType[]{TerrainType.PLAIN, TerrainType.DESERT, TerrainType.GRASS_LAND, TerrainType.TUNDRA, TerrainType.SNOW,
            TerrainType.HILL, TerrainType.FOREST, TerrainType.JUNGLE, TerrainType.MARSH,}),

    PASTURE(0, 0, 0, Technology.ANIMAL_HUSBANDRY,
        new TerrainType[]{TerrainType.PLAIN, TerrainType.DESERT, TerrainType.GRASS_LAND, TerrainType.TUNDRA, TerrainType.HILL}),

    FARMING(0, 0, 0, Technology.CALENDER,
        new TerrainType[]{TerrainType.PLAIN, TerrainType.DESERT, TerrainType.GRASS_LAND, TerrainType.FOREST, TerrainType.JUNGLE,
            TerrainType.MARSH, TerrainType.JOLGE}),

    STONE_MINE(0, 0, 0, Technology.MASONRY,
        new TerrainType[]{TerrainType.PLAIN, TerrainType.DESERT, TerrainType.GRASS_LAND, TerrainType.TUNDRA, TerrainType.HILL}),

    TRADING_POST(0, 0, 1, Technology.TRAPPING,
        new TerrainType[]{TerrainType.PLAIN, TerrainType.DESERT, TerrainType.GRASS_LAND, TerrainType.TUNDRA}),

    FACTORY(0, 2, 0, Technology.ENGINEERING,
        new TerrainType[]{TerrainType.PLAIN, TerrainType.DESERT, TerrainType.GRASS_LAND, TerrainType.TUNDRA, TerrainType.SNOW});

    private final int food;
    private final int production;
    private final int gold;
    private final Technology requiredTechnology;
    private final TerrainType[] foundOn;
    private boolean isPlundered = false;

    Improvement(int food, int production, int gold, Technology requiredTechnology, TerrainType[] foundOn) {
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

    public TerrainType[] getFoundOn() {
        return foundOn;
    }

    public boolean isPlundered() {
        return isPlundered;
    }

    public void setPlundered(boolean plundered) {
        isPlundered = plundered;
    }
}
