package model.gameModels.land;

public abstract class Land {
    private String name;
    private int food;
    private int production;
    private int gold;
    private int fightChanges;
    private int movePoint;

    public Land(String name, int food, int production, int gold, int fightChanges, int movePoint) {
        this.name = name;
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.fightChanges = fightChanges;
        this.movePoint = movePoint;
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

    public int getFightChanges() {
        return fightChanges;
    }

    public void setFightChanges(int fightChanges) {
        this.fightChanges = fightChanges;
    }

    public int getMovePoint() {
        return movePoint;
    }

    public void setMovePoint(int movePoint) {
        this.movePoint = movePoint;
    }
}