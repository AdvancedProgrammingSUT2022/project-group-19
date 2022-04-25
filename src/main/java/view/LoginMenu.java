package view;

import controller.Controller;
import model.Database;
import model.Function;
import model.User;

import java.util.HashMap;

public class LoginMenu extends Menu {
    private final HashMap<String, Function> functions = new HashMap<>();

    public LoginMenu() {
        functions.putAll(basicFunctions);
        functions.put("^user login --username (?<username>.+) --password (?<password>.+)$", this::login);
        functions.put("^user create --username (?<username>.+) --nickname (?<nickname>.+) --password (?<password>.+)$", this::addUser);
    }

    public void run() {
        getCommand(functions);
    }

    @Override
    protected void gotoMenu() {
        System.out.println("menu navigation is not possible");
    }

    private void addUser() {
        String message = Controller.addUser(matcher.group("username"), matcher.group("password"), matcher.group("nickname"));
        System.out.println(message);
    }

    private void login() {
        String message = Controller.loginCheck(matcher.group("username"), matcher.group("password"));
        System.out.println(message);
        if (message.equals("user logged in successfully!")) {
            User loggedInUser = Database.getUser(matcher.group("username"));
            MainMenu mainMenu = new MainMenu(loggedInUser);
            mainMenu.run();
        }
    }
}
