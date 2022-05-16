package model.resource;

import model.Improvement;
import model.technology.Technology;

import java.io.Serializable;

public class Resource implements Serializable {
    private int food;
    private int gold;
    private int production;
    private ResourceType type;
    private Improvement requiredImprovement;
    private Technology requiredTechnology;


    public Resource(ResourceType type) {
        this.type = type;
        this.food = type.getFood();
        this.gold = type.getGold();
        this.production = type.getProduction();
        this.requiredImprovement = type.getRequiredImprovement();
        this.requiredTechnology = type.getRequiredTechnology();
    }

    public ResourceType getType() {
        return type;
    }
}
