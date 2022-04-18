package model;

import model.civilizations.Civilization;
import model.game.Game;
import model.land.Land;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBase {
    private ArrayList<User> users; //all registered users
    Game game = new Game();

    public DataBase() {
        //read the data from file at first.
        this.users = null;
        map = null;
        playersInGame = null;
    }

    public void saveDataBase() {
        //a method to write the database contents to a file.
        //this method should always be called
    }

}
