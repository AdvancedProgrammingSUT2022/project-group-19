package model;

import model.civilizations.Civilization;
import model.land.Tile;
import model.unit.Unit;
import model.unit.UnitType;

public class Player {
    private final User user;
    private Civilization civilization;

    public Player(User user) {
        this.user = user;
        this.civilization = new Civilization();

        //create the first unit of the player:
        Unit settler = new Unit(UnitType.SETTLER, civilization);
        civilization.addUnit(settler);

        //insert the unit in the map:
        int y = 2;
        Tile tile = Database.map[3][y];
        while (tile.getCivilianUnit() != null) {
            tile = Database.map[3][++y];
        }
        tile.setCivilianUnit(settler);
    }

    public void setCivilization(Civilization civilization) {
        this.civilization = civilization;
    }

    public User getUser() {
        return user;
    }

    public Civilization getCivilization() {
        return civilization;
    }
}
