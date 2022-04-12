package model.gameModels.land;

public abstract class Land {
    private int food;
    private int production;
    private int gold;
    private int movePoint;

    public Land(int food, int production, int gold, int movePoint) {
        this.food = food;
        this.production = production;
        this.gold = gold;
        this.movePoint = movePoint;
    }
}