package model;

public enum Message {
    noEnoughGold("You don't have enough gold!"),
    cantMakeUnit("You can not make this unit."),
    moveUnitFromCity("You must move the unit from the city first."),
    invalidIndex("You entered an invalid index!"),
    tileHasOwner("You can not purchase a tile that has purchased before by you or another civilization."),
    improvementCityError("You only can make improvement in your tiles."),
    improvementLandError("Making this improvement in this land type is not allowed."),
    noTechnology("you do not have necessary technologies."),
    OK("OK"),
    busy("This Unit is busy now");
    private final String errorMessage;

    Message(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
