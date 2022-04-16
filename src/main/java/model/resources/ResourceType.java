package model.resources;

import model.Progress;
import model.technology.Technology;

public enum ResourceType {
    //score resources:
    BANANA(1, 0, 0, Progress.FARMING, null),
    COW(1, 0, 0, Progress.PASTURE, null),
    GAZELLE(1, 0, 0, Progress.CAMP, null),
    SHEEP(1, 0, 0, Progress.PASTURE, null),
    WHEAT(1, 0, 0, Progress.FARM, null),

    //luxury resources:
    COTTON(0, 0, 2, Progress.FARMING, null),
    COLOR(0, 0, 2, Progress.FARMING, null),
    FUR(0, 0, 2, Progress.CAMP, null),
    VALUABLE_STONE(0, 0, 3, Progress.MINE, null),
    GOLD(0, 0, 2, Progress.MINE, null),
    INCENSE(0, 0, 2, Progress.FARMING, null),
    IVORY(0, 0, 2, Progress.CAMP, null),
    MARBLE(0, 0, 2, Progress.STONE_MINE, null),
    SILK(0, 0, 2, Progress.FARMING, null),
    SILVER(0, 0, 2, Progress.MINE, null),
    SUGAR(0, 0, 2, Progress.FARMING, null),

    //strategic resources:
    COAL(0, 1, 0, Progress.MINE, Technology.SCIENTIFIC_THEORY),
    HOURSE(0, 1, 0, Progress.PASTURE, Technology.ANIMAL_HUSBANDRY),
    IRON(0, 1, 0, Progress.MINE, Technology.IRON_WORKING);


    private final int food;
    private final int production;
    private final int gold;
    private final Progress requiredProgress;
    private final Technology requiredTechnology;

    ResourceType(int food, int production, int gold, Progress requiredProgress, Technology requiredTechnology) {
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

    public Progress getRequiredProgress() {
        return requiredProgress;
    }

    public Technology getRequiredTechnology() {
        return requiredTechnology;
    }
}
