package model.resources;

import model.Progress;
import model.Technology;

public class Resource {
    private ResourceType type;
    private int food;
    private int production;
    private int gold;
    private Progress requiredProgress;
    private Technology requiredTechnology;


    public Resource(ResourceType type) {
        this.type = type;
        this.food = type.getFood();
        this.production = type.getProduction();
        this.gold = type.getGold();
        this.requiredProgress = type.getRequiredProgress();
        this.requiredTechnology = type.getRequiredTechnology();
    }
}
