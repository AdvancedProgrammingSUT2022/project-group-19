package model;

public enum Message {
    NULL(""),
    noEnoughGold("You don't have enough gold!"),
    cantMakeUnit("You can not make this unit."),
    moveUnitFromCity("You must move the unit from the city first."),
    invalidIndex("You entered an invalid index!"),
    tileHasOwner("You can not purchase a tile that has purchased before by you or another civilization."),
    improvementCityError("You only can make improvement in your tiles."),
    improvementLandError("Making this improvement in this land type is not allowed."),
    noTechnology("you do not have necessary technologies."),
    OK("OK"),
    busy("This Unit is busy now"),
    invalidCommand("invalid command :/"),
    noIdlePerson("No idle person in city. Please free someone first."),
    loginOK("user logged in successfully!"),
    tileHasPerson("This tile have a person. Please free him first."),
    loginFail("Username and password didn't match!"),
    destinationIsFull("Two units in one tile is forbidden."),
    assigned("You can not assign a unit twice in a turn."),
    noRemovableFeature("There is no eny forest, jungle, or marsh in this tile."),
    NEXT_TURN("let's go next turn!"),
    noUnit("There is not any selectable unit in this tile."),
    noSelectedTile("You must select a tile first");
    private final String errorMessage;


    Message(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
