package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import controller.modelcontroller.MapController;
import model.land.Tile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;


public class Database implements Serializable {
    private static List<User> users = new ArrayList<>(); //all registered users
    private static List<Player> players = new ArrayList<>();  //players in game
    private static final String saveGamePath = "./data/game.dat";
    private static final String usersPath = "./data/users.json";
    public static MapController mapController = new MapController();
    public static final int numOfRows = 6;
    public static final int numOfCols = 14;
    public static GameMap gameMap = mapController.generateRandomMap(numOfRows, numOfCols);
    public static Tile[][] map = gameMap.getMap();

//    public Database() {
//        //read the data from file at first.
//        readSavedUsers();
//        readSavedGame();
//    }


    public static void readSavedUsers() {
        try {
            Type type = new TypeToken<List<User>>() {
            }.getType();
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(usersPath));
            users = gson.fromJson(reader, type);
            reader.close();
        } catch (Exception e) {
            System.out.println("No users.json file | " + e.getMessage());
        }
    }

    public static void updateUsersFile() {
        try {
            Writer writer = new FileWriter(usersPath);
            new Gson().toJson(users, writer);
//            Gson gson = new GsonBuilder().create();
//            gson.toJson(users, writer);
            writer.close();
        } catch (Exception e) {
            System.out.println("An Error occurred :( " + e.getMessage());
        }
    }

    private static void readSavedGame() {
    }

    private static void updateGameFile() {

    }

    public static List<User> getUsers() {
        return users;
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static void addUser(User newUser) {
        users.add(newUser);
        updateUsersFile();
    }

    public static User getUser(String username) {
        for (User user : users)
            if (user.getUsername().equals(username))
                return user;
        return null;
    }

    public static User getUserByNickname(String nickname) {
        for (User user : users)
            if (user.getNickname().equals(nickname))
                return user;
        return null;
    }

    public static void addPlayer(Player player) {
        players.add(player);
    }

    public static void setPlayers(List<Player> players) {
        Database.players = players;
    }

    public static String getSaveGamePath() {
        return saveGamePath;
    }
}

class DatabaseTest {

    @Test
    public void fileHandleTest() {
        Database.addUser(new User("ali", "aaallliii", "ali24"));
        Database.addUser(new User("sajad", "jaaaadddd", "sajad1234"));
        Database.addUser(new User("shalchianmh", "abcdefg", "mohammad hossein"));
        Database.updateUsersFile();
        Assertions.assertTrue(true);
    }

    @Test
    public void fileReadTest() {
        Database.readSavedUsers();
        for (User user : Database.getUsers()) {
            System.out.println("user-> " + user.getUsername() + " // nickname: " + user.getNickname());
        }
    }
}
