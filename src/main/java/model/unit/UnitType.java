package model.unit;

import model.technology.Technology;
import model.resource.ResourceType;

public enum UnitType {
    //Ancient era units:
    ARCHER(70, 4, 6, 2, 2, null, Technology.ARCHERY),
    CHARIOT_ARCHER(60, 3, 6, 2, 4, ResourceType.HORSE, Technology.THE_WHEEL),
    SCOUT(25, 4, 0, 0, 2, null, null),
    SETTLER(89, 0, 0, 0, 2, null, null),
    SPEARMAN(50, 7, 0, 0, 2, null, Technology.BRONZE_WORKING),
    WARRIOR(40, 6, 0, 0, 2, null, null),
    WORKER(70, 0, 0, 0, 2, null, null),

    //Classical era units:
    CATAPULT(100, 4, 14, 2, 2, ResourceType.IRON, Technology.MATHEMATICS),
    HORSE_MAN(80, 12, 0, 0, 4, ResourceType.HORSE, Technology.HORSE_BACK_RIDING),
    SWORDS_MAN(80, 11, 0, 0, 2, ResourceType.IRON, Technology.IRON_WORKING),

    //medieval era units:
    CROSSBOW_MAN(120, 6, 12, 2, 2, null, Technology.MACHINERY),
    KNIGHT(150, 18, 0, 0, 3, ResourceType.HORSE, Technology.CHIVALRY),
    LONG_SWORDS_MAN(150, 18, 0, 0, 3, ResourceType.IRON, Technology.STEEL),
    PIKE_MAN(100, 10, 0, 0, 2, null, Technology.CIVIL_SERVICE),
    TREBUCHET(170, 6, 20, 2, 2, ResourceType.IRON, Technology.PHYSICS),

    //Renaissance era units:
    CANON(250, 10, 26, 2, 2, null, Technology.CHEMISTRY),
    CAVALRY(260, 25, 0, 0, 3, ResourceType.HORSE, Technology.MILITARY_SCIENCE),
    LANCER(220, 22, 0, 0, 4, ResourceType.HORSE, Technology.METALLURGY),
    MUSKET_MAN(120, 16, 0, 0, 2, null, Technology.GUNPOWDER),
    RIFLE_MAN(200, 25, 0, 0, 2, null, Technology.RIFLING),


    //Industrial era units:
    ANTI_TANK_GUN(300, 32, 0, 0, 2, null, Technology.REPLACEABLE_PARTS),
    ARTILLERY(420, 16, 32, 3, 2, null, Technology.DYNAMITE),
    INFANTRY(300, 36, 0, 0, 2, null, Technology.REPLACEABLE_PARTS),
    PANZER(450, 60, 0, 0, 5, null, Technology.COMBUSTION),
    TANK(450, 50, 0, 0, 4, null, Technology.COMBUSTION);

    private final int cost;
    private final int power;
    private final int rangedPower;
    private final int range;
    private final int movePoint;
    private final ResourceType requiredResource;
    private final Technology requiredTechnology;

    UnitType(int cost, int power, int rangedPower, int range, int movePoint, ResourceType requiredResource, Technology requiredTechnology) {
        this.cost = cost;
        this.power = power;
        this.rangedPower = rangedPower;
        this.range = range;
        this.movePoint = movePoint;
        this.requiredResource = requiredResource;
        this.requiredTechnology = requiredTechnology;
    }

    public int getCost() {
        return cost;
    }

    public int getPower() {
        return power;
    }

    public int getRangedPower() {
        return rangedPower;
    }

    public int getRange() {
        return range;
    }

    public int getMovePoint() {
        return movePoint;
    }

    public ResourceType getRequiredResource() {
        return requiredResource;
    }

    public Technology getRequiredTechnology() {
        return requiredTechnology;
    }

    public boolean isMilitary() {
        return !(this.equals(UnitType.WORKER) || this.equals(UnitType.SETTLER));
    }

    public boolean isSiege() {
        return this.equals(CATAPULT) || this.equals(TREBUCHET) || this.equals(CANON) || this.equals(ARTILLERY);
    }

    public boolean isMelee() {
        return this.equals(SPEARMAN) || this.equals(WARRIOR) || this.equals(SWORDS_MAN) || this.equals(LONG_SWORDS_MAN) ||
                this.equals(PIKE_MAN);
    }

    public boolean isRanged() {
        return this.equals(ARCHER) || this.equals(CHARIOT_ARCHER) || this.equals(CROSSBOW_MAN) ||
                this.equals(TANK) || this.equals(PANZER) || this.equals(ANTI_TANK_GUN) || this.equals(RIFLE_MAN) ||
                this.equals(MUSKET_MAN) || this.equals(LANCER) || this.equals(CAVALRY) || this.equals(KNIGHT) ||
                this.equals(HORSE_MAN) || this.equals(SCOUT) || this.equals(INFANTRY);
    }
}
