package model.resources;

import model.Progress;

import java.util.ArrayList;

public enum ResourceType {
    //score resources:
    BANANA(1, 0, 0, null),
    COW(1, 0, 0, null),
    GAZELLE(1, 0, 0, null),
    SHEEP(1, 0, 0, null),
    WHEAT(1, 0, 0, null),

    //luxury resources:
    COTTON(0, 0, 2, null),
    COLOR(0, 0, 2, null),
    FUR(0, 0, 2, null),
    VALUABLE_STONE(0, 0, 3, null),
    GOLD(0, 0, 2, null),
    INCENSE(0, 0, 2, null),
    IVORY(0, 0, 2, null),
    MARBLE(0, 0, 2, null),
    SILK(0, 0, 2, null),
    SILVER(0, 0, 2, null),
    SUGAR(0, 0, 2, null),

    //strategic resources:
    COAL(0, 1, 0, null),
    HOURSE(0, 1, 0, null),
    IRON(0, 1, 0, null);


    private final int food;
    private final int production;
    private final int gold;
    private final ArrayList<Progress> requiredProgress;

    ResourceType(int food, int production, int gold, ArrayList<Progress> requiredProgress) {
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.requiredProgress = requiredProgress;
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

    public ArrayList<Progress> getRequiredProgress() {
        return requiredProgress;
    }
}
