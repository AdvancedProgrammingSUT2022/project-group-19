package view;

import model.Database;
import model.Function;
import model.User;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenu extends Menu{
    private final HashMap<String, Function> functions = new HashMap<>() {{
        put("^menu exit$", null);
        put("^menu show-current$", () -> showCurrentMenu());
        put("^menu enter (?<menuName>(login menu|main menu|profile menu|game menu))$", () -> gotoMenu());
        put("^user login --username (?<username>.+) --password (?<password>.+)$", () -> login());
        put("^user create --username (?<username>.+) --nickname (?<nickname>.+) --password (?<password>.+)$", () -> addUser());
    }};

    private void addUser() {
        String username = matcher.group("username");
        String password = matcher.group("password");
        String nickname = matcher.group("nickname");
        //TODO this
        String message = "test";// = Controller.checkNewUser(username, password, nickname);
        if (message.equals("it is ok")) {
            User user = new User(username, password, nickname);
            //database.addUser(user);
        }
    }

    private void login() {
        String username = matcher.group("username");
        String password = matcher.group("password");
        //TODO this
        String message = "test";// = Controller.loginCheck(username,password);
        System.out.println(message);
        if (message.equals("user logged in successfully!")) {
            //TODO: go to main menu
        }
    }

    private void showCurrentMenu() {
        String className = this.getClass().getSimpleName();
        System.out.println(className);
    }

    protected void gotoMenu() {
        String nextMenuName = matcher.group("menuName");
        String currentMenuName = this.getClass().getSimpleName();
        switch (nextMenuName) {
            case "login menu":
                break;
            //TODO: in anjam beshe
            case "main menu":
                break;

            case "profile menu":
                break;

            case "game menu":
                break;
        }
    }
}
