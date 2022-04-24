package view;

import model.Function;
import model.User;

import java.util.HashMap;

public class MainMenu extends Menu {
    protected User loggedInUser;
    private final HashMap<String, Function> functions = new HashMap<>();

    public MainMenu() {
        functions.putAll(basicFunctions);
        functions.put("^user logout$", this::logout);
        functions.put("^play game --player1 (?<username1>.+) --player2 (?<username2>.+).*", this::startGame);
    }

    public void run() {
        menuLoop(functions);
    }

    @Override
    protected void gotoMenu() {
        String nextMenuName = matcher.group("menuName");
        if (nextMenuName.equals("profile menu")) {
            ProfileMenu profileMenu = new ProfileMenu();
            profileMenu.run();
        } else if (nextMenuName.equals("game menu")) {
            GameMenu gameMenu = new GameMenu();
            gameMenu.run();
        } else
            System.out.println("menu navigation is not possible");
    }

    private void startGame() {
        System.out.println("start the game (X_x)");
        //TODO
    }

    private void logout() {
        System.out.println("logout (X_x)");
        //TODO
    }
}
