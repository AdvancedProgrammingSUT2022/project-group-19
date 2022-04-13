package model.resources;

import model.Progress;

import java.util.ArrayList;

public class Resource {
    private ResourceType type;
    private int food;
    private int production;
    private int gold;
    private ArrayList<Progress> requiredProgress;

    public Resource(ResourceType type) {
        this.type = type;
        this.food = type.getFood();
        this.production = type.getProduction();
        this.gold = type.getGold();
        this.requiredProgress = type.getRequiredProgress();
    }
}
