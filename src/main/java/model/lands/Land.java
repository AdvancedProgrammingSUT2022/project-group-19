package model.lands;

public class Land {
    private final int food;
    private final int production;
    private final int gold;
    private final int fightChanges;
    private final int movePoint;

    public Land(LandType type,LandFeature feature){
        this.food = type.getFood() + feature.getFood();
        this.gold = type.getGold() + feature.getGold();
        this.movePoint = type.getMovePoint() + feature.getMovePoint();
        this.production = type.getProduction() + feature.getProduction();
        this.fightChanges = type.getFightChanges() + feature.getFightChanges();
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

    public int getFightChanges() {
        return fightChanges;
    }

    public int getMovePoint() {
        return movePoint;
    }
}