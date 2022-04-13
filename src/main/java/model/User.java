package model;

import model.Civilization;

import java.util.ArrayList;

public class User {
    String username;
    String password;
    String nickname;
    private static ArrayList<User> users;

    public User(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }
}
