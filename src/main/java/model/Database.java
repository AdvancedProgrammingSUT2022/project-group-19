package model;

import java.util.ArrayList;
import java.util.List;


public class Database {
    private List<User> users; //all registered users
    private List<Player> players = new ArrayList<>();  //players in game

    public Database() {
        //read the data from file at first.
        users = null;
        players = null;
    }

    public void saveDataInFile() {
        //a method to write the database contents to a file.
        //this method should always be called
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
