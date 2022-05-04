package model.building;

import model.technology.Technology;

public enum Building {
    //Ancient Era Buildings
    BARRACKS(80, 1, Technology.BRONZE_WORKING),
    GRANARY(100, 1, Technology.POTTERY),
    LIBRARY(80, 1, Technology.WRITING),
    MONUMENT(60, 1, null),
    WALLS(100, 1, Technology.MASONRY),
    WATER_MILL(120, 2, Technology.THE_WHEEL),

    //Classical Era Buildings
    ARMORY(130, 3, Technology.IRON_WORKING),
    BURIAL_TOMB(120, 0, Technology.PHILOSOPHY),
    CIRCUS(150, 3, Technology.HORSE_BACK_RIDING),
    COLOSSEUM(150, 3, Technology.CONSTRUCTION),
    COURTHOUSE(200, 5, Technology.MATHEMATICS),
    STABLE(100, 1, Technology.HORSE_BACK_RIDING),
    TEMPLE(120, 2, Technology.PHILOSOPHY),

    //Medieval Era Buildings
    CASTLE(200, 3, Technology.CHIVALRY),
    FORGE(150, 2, Technology.METAL_CASTING),
    GARDEN(120, 2, Technology.THEOLOGY),
    MARKET(120, 0, Technology.CURRENCY),
    MINT(120, 0, Technology.CURRENCY),
    MONASTERY(120, 2, Technology.THEOLOGY),
    UNIVERSITY(200, 3, Technology.EDUCATION),
    WORKSHOP(100, 2, Technology.METAL_CASTING),

    //Renaissance Era Buildings
    BANK(220, 0, Technology.BANKING),
    MILITARY_ACADEMY(350, 3, Technology.MILITARY_SCIENCE),
    MUSEUM(350, 3, Technology.ARCHAEOLOGY),
    OPERA_HOUSE(220, 3, Technology.ACOUSTICS),
    PUBLIC_SCHOOL(350, 3, Technology.SCIENTIFIC_THEORY),
    SATRAP_S_COURT(220, 0, Technology.BANKING),
    THEATER(300, 5, Technology.PRINTING_PRESS),
    WINDMILL(180, 2, Technology.ECONOMICS),

    //Industrial Era Buildings
    ARSENAL(350, 3, Technology.RAILROAD),
    BROADCAST_TOWER(600, 3, Technology.RADIO),
    FACTORY(300, 3, Technology.STEAM_POWER),
    HOSPITAL(400, 2, Technology.BIOLOGY),
    MILITARY_BASE(450, 4, Technology.TELEGRAPH),
    STOCK_EXCHANGE(650, 0, Technology.ELECTRICITY);

    private final int cost;
    private final int maintenance;
    private final Technology technologyRequiredName;
    private boolean isAvailableTechnologyRequired;

    Building(int cost, int maintenance, Technology technologyRequiredName) {
        this.cost = cost;
        this.maintenance = maintenance;
        this.technologyRequiredName = technologyRequiredName;
    }

    public int getCost() {
        return this.cost;
    }

    public int getMaintenance() {
        return this.maintenance;
    }

    public Technology getRequiredTechnology() {
        return this.technologyRequiredName;
    }

    public boolean getIsAvailableTechnologyRequired() {
        return this.isAvailableTechnologyRequired;
    }

    public void setIsAvailableTechnologyRequired(boolean isAvailableTechnologyRequired) {
        this.isAvailableTechnologyRequired = isAvailableTechnologyRequired;
    }

}
