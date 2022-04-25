package view;

import controller.Controller;
import model.Database;
import model.Function;

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
        String nextMenuName = matcher.group("menuName");
        if (nextMenuName.equals("main menu")) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.run();
        } else
            System.out.println("menu navigation is not possible");
    }

    private void addUser() {
        String username = matcher.group("username");
        String password = matcher.group("password");
        String nickname = matcher.group("nickname");
        String message = Controller.addUser(username, password, nickname);
        System.out.println(message);
    }

    private void login() {
        String username = matcher.group("username");
        String password = matcher.group("password");
        //TODO this
        String message = "test";// = Controller.loginCheck(username,password);
        System.out.println(message);
    }
}
