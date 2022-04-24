package controller;

import model.Database;
import model.User;

public class Controller {
    static public String addUser(String username, String password, String nickname) {
        if (Database.getUser(username) != null)
            return "user with username " + username + " already exists";
        else if (Database.getUserByNickname(nickname) != null)
            return "user with nickname " + nickname + " already exists";
        User newUser = new User(username, password, nickname);
        Database.addUser(newUser);
        return "user created successfully!";
    }
}
