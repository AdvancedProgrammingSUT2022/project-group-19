package model;

import model.civilizations.City;
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

        Unit scout = new Unit(UnitType.SCOUT, civilization);
        civilization.addUnit(scout);

        //insert the unit in the map:
        int y = 4;
        Tile tile = Database.map[2][y];
        while (tile.getCivilianUnit() != null) {
            tile = Database.map[2][y+=4];
        }
        tile.setCivilianUnit(settler);
        tile.setMilitaryUnit(scout);

        City city = new City(civilization, 2, y);

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
