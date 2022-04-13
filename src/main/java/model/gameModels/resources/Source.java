package model.gameModels.resources;

import java.util.ArrayList;

public class Source {
    private String name;
    private int food;
    private int production;
    private int gold;
    private ArrayList<String> allowableLands;
    // todo ( pishraft lazam baray bahrebardary ??)

    public Source(String name, int food, int production, int gold) {
        this.name = name;
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.allowableLands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public ArrayList<String> getAllowableLands() {
        return allowableLands;
    }

    public void setAllowableLands(ArrayList<String> allowableLands) {
        this.allowableLands = allowableLands;
    }

    public void addAllowableLands(String nameOfLand){
        this.allowableLands.add(nameOfLand);
    }

}
