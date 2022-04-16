package model.land;

public class Land {
    private final int food;
    private final int production;
    private final int gold;
    private final int movePoint;
    private final double fightChanges;
    private final LandType type;
    private final LandType feature;

    public Land(LandType type, LandType feature) {
        this.type = type;
        this.feature = feature;
        this.food = type.getFood() + feature.getFood();
        this.gold = type.getGold() + feature.getGold();
        this.movePoint = type.getMovePoint() + feature.getMovePoint();
        this.production = type.getProduction() + feature.getProduction();
        this.fightChanges = type.getFightChanges() + feature.getFightChanges();
    }

    public LandType getType() {
        return type;
    }

    public LandType getFeature() {
        return feature;
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

    public int getMovePoint() {
        return movePoint;
    }

    public double getFightChanges() {
        return fightChanges;
    }
}