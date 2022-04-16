package model.technology;

public enum Technology {
    //Ancient Era
    AGRICULTURE(20, null),
    ANIMAL_HUSBANDRY(35, new Technology[]{AGRICULTURE}),
    ARCHERY(35, new Technology[]{AGRICULTURE}),
    MINING(35, new Technology[]{AGRICULTURE}),
    BRONZE_WORKING(55, new Technology[]{MINING}),
    MASONRY(55, new Technology[]{MINING}),
    POTTERY(35, new Technology[]{AGRICULTURE}),
    CALENDER(70, new Technology[]{POTTERY}),
    THE_WHEEL(55, new Technology[]{ANIMAL_HUSBANDRY}),
    TRAPPING(55, new Technology[]{ANIMAL_HUSBANDRY}),
    WRITING(55, new Technology[]{POTTERY}),

    //Classical Era
    CONSTRUCTION(100, new Technology[]{MASONRY}),
    HORSE_BACK_RIDING(100, new Technology[]{THE_WHEEL}),
    IRON_WORKING(150, new Technology[]{BRONZE_WORKING}),
    MATHEMATICS(100, new Technology[]{THE_WHEEL, ARCHERY}),
    PHILOSOPHY(100, new Technology[]{WRITING}),

    //Medieval Era
    CIVIL_SERVICE(400, new Technology[]{PHILOSOPHY, TRAPPING}),
    CURRENCY(250, new Technology[]{MATHEMATICS}),
    CHIVALRY(440, new Technology[]{CIVIL_SERVICE, CURRENCY, HORSE_BACK_RIDING}),
    ENGINEERING(250, new Technology[]{MATHEMATICS, CONSTRUCTION}),
    MACHINERY(440, new Technology[]{ENGINEERING}),
    METAL_CASTING(240, new Technology[]{IRON_WORKING}),
    PHYSICS(440, new Technology[]{ENGINEERING, METAL_CASTING}),
    STEEL(440, new Technology[]{METAL_CASTING}),
    THEOLOGY(250, new Technology[]{CALENDER, PHILOSOPHY}),
    EDUCATION(440, new Technology[]{THEOLOGY}),

    //Renaissance Era
    ACOUSTICS(650, new Technology[]{EDUCATION}),
    ARCHAEOLOGY(1300, new Technology[]{ACOUSTICS}),
    BANKING(650, new Technology[]{EDUCATION, CHIVALRY}),
    GUNPOWDER(680, new Technology[]{PHYSICS, STEEL}),
    CHEMISTRY(900, new Technology[]{GUNPOWDER}),
    FERTILIZER(1300, new Technology[]{CHEMISTRY}),
    METALLURGY(900, new Technology[]{GUNPOWDER}),
    PRINTING_PRESS(650, new Technology[]{MACHINERY, PHYSICS}),
    ECONOMICS(900, new Technology[]{BANKING, PRINTING_PRESS}),
    MILITARY_SCIENCE(1300, new Technology[]{ECONOMICS, CHEMISTRY}),
    RIFLING(1425, new Technology[]{METALLURGY}),
    SCIENTIFIC_THEORY(1300, new Technology[]{ACOUSTICS}),

    //Industrial Era
    BIOLOGY(1680, new Technology[]{ARCHAEOLOGY, SCIENTIFIC_THEORY}),
    DYNAMITE(1900, new Technology[]{FERTILIZER, RIFLING}),
    STEAM_POWER(1680, new Technology[]{SCIENTIFIC_THEORY, MILITARY_SCIENCE}),
    ELECTRICITY(1900, new Technology[]{BIOLOGY, STEAM_POWER}),
    RADIO(2200, new Technology[]{ELECTRICITY}),
    RAILROAD(1900, new Technology[]{STEAM_POWER}),
    REPLACEABLE_PARTS(1900, new Technology[]{STEAM_POWER}),
    COMBUSTION(2200, new Technology[]{REPLACEABLE_PARTS, RAILROAD, DYNAMITE}),
    TELEGRAPH(2200, new Technology[]{ELECTRICITY});

    private int cost;
    private Technology[] prerequisiteTechs;

    Technology(int cost, Technology[] prerequisiteTechs) {
        this.cost = cost;
        this.prerequisiteTechs = prerequisiteTechs;
    }

    public int getCost() {
        return cost;
    }

    public Technology[] getPrerequisiteTechs() {
        return prerequisiteTechs;
    }
}
