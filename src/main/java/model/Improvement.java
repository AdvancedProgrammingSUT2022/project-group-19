package model;

import model.technology.Technology;

public enum Improvement {
    CAMP(0, 0, 0, Technology.TRAPPING),
    FARM(1, 0, 0, Technology.AGRICULTURE),
    LUMBER_MILL(0, 1, 0, Technology.CONSTRUCTION),
    MINE(0, 1, 0, Technology.MINING),
    PASTURE(0, 0, 0, Technology.ANIMAL_HUSBANDRY),
    FARMING(0, 0, 0, Technology.CALENDER),
    STONE_MINE(0, 0, 0, Technology.MASONRY),
    TRADING_POST(0, 0, 1, Technology.TRAPPING),
    FACTORY(0, 2, 0, Technology.ENGINEERING);

    private final int food;
    private final int production;
    private final int gold;
    private final Technology requiredTechnology;
    //TODO: Implement where this improvements can be constructed

    Improvement(int food, int production, int gold, Technology requiredTechnology) {
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.requiredTechnology = requiredTechnology;
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
}
