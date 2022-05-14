package model;

import model.civilizations.City;
import model.civilizations.Civilization;
import model.land.Tile;
import model.unit.Unit;
import model.unit.UnitType;
import model.unit.Worker;

public class Player {
    private final User user;
    private Civilization civilization;

    public Player(User user) {
        this.user = user;
        this.civilization = new Civilization();

        //create the first unit of the player:


        //insert the unit in the map:
        int y = 4;
        Tile tile = Database.map[2][y];
        while (tile.getCivilianUnit() != null) {
            tile = Database.map[2][y += 4];
        }
        new Unit(UnitType.SCOUT, civilization, 2, y);
        new Worker(new Unit(UnitType.WORKER, civilization, 2, y));
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
