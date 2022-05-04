package model;

public enum Message {
    notEnoughGold("You don't have enough gold!"),
    cantMakeUnit("You can not make this unit."),
    moveUnitFromCity("You must move the unit from the city first."),
    noProduction("There is not any Unit to produce."),
    invalidIndex("You entered an invalid index!"),
    tileHasOwner("You can not purchase a tile that has purchased before by you or another civilization."),
    OK("OK"),
    ;
    private final String errorMessage;

    Message(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
