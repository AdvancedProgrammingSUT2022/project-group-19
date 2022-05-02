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
        functions.put("^user login --(username|u) (?<username>.+) --(password|p) (?<password>.+)$", this::login);
        functions.put("^user login --(password|p) (?<password>.+) --(username|u) (?<username>.+)$", this::login);

        functions.put("^user create --(username|u) (?<username>.+) --(nickname|n) (?<nickname>.+) --(password|p) (?<password>.+)$", this::addUser);
        functions.put("^user create --(username|u) (?<username>.+) --(password|p) (?<password>.+) --(nickname|n) (?<nickname>.+)$", this::addUser);
        functions.put("^user create --(nickname|n) (?<nickname>.+) --(username|u) (?<username>.+) --(password|p) (?<password>.+)$", this::addUser);
        functions.put("^user create --(nickname|n) (?<nickname>.+) --(password|p) (?<password>.+) --(username|u) (?<username>.+)$", this::addUser);
        functions.put("^user create --(password|p) (?<password>.+) --(nickname|n) (?<nickname>.+) --(username|u) (?<username>.+)$", this::addUser);
        functions.put("^user create --(password|p) (?<password>.+) --(username|u) (?<username>.+) --(nickname|n) (?<nickname>.+)$", this::addUser);
    }

    public void run() {
        getCommand(functions);
    }

    @Override
    protected void gotoMenu() {
        String nextMenuName = matcher.group("menuName");
        if (nextMenuName.equals("main menu"))
            System.out.println("Please login first.\nEnter: 'user login --username <your username> --password <your password>' to login.");
        else
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
