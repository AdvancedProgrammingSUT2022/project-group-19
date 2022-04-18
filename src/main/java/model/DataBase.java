package model;

import model.civilizations.Civilization;
import model.land.Land;

import java.util.ArrayList;


public class DataBase {
    private static final int mapLength = 10;
    private static final int mapWidth = 5;
    private static ArrayList<User> users; //all registered users
    private static ArrayList<Player> players = new ArrayList<>();  //players in game
    private static Land[][] map = new Land[mapLength][mapWidth];

    public DataBase() {
        //read the data from file at first.
        users = null;
        map = null;
        players = null;
    }

    public void saveDataInFile() {
        //a method to write the database contents to a file.
        //this method should always be called
    }

    public void generateMap() {
        //generate a random map
        Land[][] newMap = new Land[mapLength][mapWidth];
        map = newMap;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        DataBase.users = users;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void setPlayers(ArrayList<Player> players) {
        DataBase.players = players;
    }

    public static Land[][] getMap() {
        return map;
    }

    public static void setMap(Land[][] map) {
        DataBase.map = map;
    }
}
