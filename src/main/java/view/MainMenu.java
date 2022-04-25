package view;

import model.Database;
import model.Function;
import model.Player;
import model.User;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu extends Menu {
    protected User loggedInUser;
    private final HashMap<String, Function> functions = new HashMap<>();

    public MainMenu(User loggedInUser) {
        this.loggedInUser = loggedInUser;
        functions.putAll(basicFunctions);
        functions.put("^user logout$", this::logout);
        functions.put("^play game(?<player> --player(?<numberPlayer>[1-9][0-9]*) (?<username1>\\S+))+", this::startGame);
    }

    public void run() {
        getCommand(functions);
    }

    @Override
    protected void gotoMenu() {
        String nextMenuName = matcher.group("menuName");
        if (nextMenuName.equals("profile menu")) {
            ProfileMenu profileMenu = new ProfileMenu(loggedInUser);
            profileMenu.run();
        } else if (nextMenuName.equals("game menu")) {
            GameMenu gameMenu = new GameMenu();
            gameMenu.run();
        } else
            System.out.println("menu navigation is not possible");
    }

    private void startGame() {
        System.out.println("start the game (X_x)");
        Matcher matcher1 = Pattern.compile("(?<player> --player(?<numberPlayer>[1-9][0-9]*) (?<username>\\S+))").matcher(command);
        while (matcher1.find()){
            Player player = new Player(Database.getUser(matcher1.group("username")));
            Database.addPlayer(player);
        }
    }

    private void logout() {
        System.out.println("logout (X_x)");
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.run();
    }
}
