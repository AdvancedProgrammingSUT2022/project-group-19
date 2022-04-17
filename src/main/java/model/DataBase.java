package model;

import model.civilizations.Civilization;
import model.land.Land;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBase {
    private User loggedInUser;
    private ArrayList<User> users; //all registered users
    private HashMap<User, Civilization> playersInGame = new HashMap<>();
    private Land[][] map = new Land[10][5];

    public DataBase() {
        //read the data from file at first.
        this.users = null;
        map = null;
        loggedInUser = null;
        playersInGame = null;
    }

    public void saveDataBase() {
        //a method to write the database contents to a file.
        //this method should always be called
    }

}
