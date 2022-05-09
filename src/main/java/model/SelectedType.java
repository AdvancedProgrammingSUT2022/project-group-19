package model;

public enum SelectedType {
    CITY("city"),
    CIVILIAN_UNIT("civilian unit"),
    MILITARY_UNIT("military unit"),
    ;

    private final String name;

    SelectedType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
