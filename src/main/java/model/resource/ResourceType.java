package model.resource;

import model.Improvement;
import model.technology.Technology;

public enum ResourceType {
    //score resources:
    BANANA(1, 0, 0, Improvement.FARMING, null),
    COW(1, 0, 0, Improvement.PASTURE, null),
    GAZELLE(1, 0, 0, Improvement.CAMP, null),
    SHEEP(1, 0, 0, Improvement.PASTURE, null),
    WHEAT(1, 0, 0, Improvement.FARM, null),

    //luxury resources:
    COTTON(0, 0, 2, Improvement.FARMING, null),
    COLOR(0, 0, 2, Improvement.FARMING, null),
    FUR(0, 0, 2, Improvement.CAMP, null),
    VALUABLE_STONE(0, 0, 3, Improvement.MINE, null),
    GOLD(0, 0, 2, Improvement.MINE, null),
    INCENSE(0, 0, 2, Improvement.FARMING, null),
    IVORY(0, 0, 2, Improvement.CAMP, null),
    MARBLE(0, 0, 2, Improvement.STONE_MINE, null),
    SILK(0, 0, 2, Improvement.FARMING, null),
    SILVER(0, 0, 2, Improvement.MINE, null),
    SUGAR(0, 0, 2, Improvement.FARMING, null),

    //strategic resources:
    COAL(0, 1, 0, Improvement.MINE, Technology.SCIENTIFIC_THEORY),
    HORSE(0, 1, 0, Improvement.PASTURE, Technology.ANIMAL_HUSBANDRY),
    IRON(0, 1, 0, Improvement.MINE, Technology.IRON_WORKING);


    private final int food;
    private final int production;
    private final int gold;
    private final Improvement requiredProgress;
    private final Technology requiredTechnology;

    ResourceType(int food, int production, int gold, Improvement requiredProgress, Technology requiredTechnology) {
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.requiredProgress = requiredProgress;
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

    public Improvement getRequiredProgress() {
        return requiredProgress;
    }

    public Technology getRequiredTechnology() {
        return requiredTechnology;
    }
}
