package model;

import model.civilizations.City;
import model.civilizations.Civilization;
import model.land.Tile;
import model.unit.Unit;
import model.unit.UnitType;
import model.unit.Worker;

import java.io.Serializable;

public class Player implements Serializable {
    private final User user;
    private Civilization civilization;
    //fogOfWar status:  0 = hidden    /   1 = not hidden   /   2 = visible
    public int[][] fogOfWar = new int[Database.numOfRows][Database.numOfCols];

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
        Unit unit = new Unit(UnitType.SCOUT, civilization, 2, y);
        civilization.addUnit(unit);
        Worker worker = new Worker(new Unit(UnitType.WORKER, civilization, 2, y));
        civilization.addUnit(worker);
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
