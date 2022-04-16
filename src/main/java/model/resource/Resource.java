package model.resource;

import model.Improvement;
import model.technology.Technology;

public class Resource {
    private int food;
    private int gold;
    private int production;
    private ResourceType type;
    private Improvement requiredProgress;
    private Technology requiredTechnology;


    public Resource(ResourceType type) {
        this.type = type;
        this.food = type.getFood();
        this.gold = type.getGold();
        this.production = type.getProduction();
        this.requiredProgress = type.getRequiredProgress();
        this.requiredTechnology = type.getRequiredTechnology();
    }
}
