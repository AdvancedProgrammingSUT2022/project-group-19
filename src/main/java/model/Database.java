package model;

import java.util.ArrayList;
import java.util.List;


public class Database {
    private static List<User> users; //all registered users
    private static List<Player> players = new ArrayList<>();  //players in game

    public Database() {
        //read the data from file at first.
        users = null;
        players = null;
    }

    public void saveDataInFile() {
        //a method to write the database contents to a file.
        //this method should always be called
    }

    public static List<User> getUsers() {
        return users;
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static void addUser(User newUser) {
        users.add(newUser);
        //TODO: update file
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

}
