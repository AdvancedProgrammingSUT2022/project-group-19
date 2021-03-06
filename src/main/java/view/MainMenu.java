package view;

import controller.GameController;
import model.*;
import model.land.Tile;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu extends Menu {
    protected User loggedInUser;
    private final HashMap<String, Function> functions = new HashMap<>();

    public MainMenu(User loggedInUser) {
        this.loggedInUser = loggedInUser;
        functions.putAll(basicFunctions);
        functions.put("^user logout$", this::logout);
        functions.put("^load game$", this::loadGame);
        functions.put("^play game(?<player> (--player|-p)(?<numberPlayer>[1-9][0-9]*) (?<username1>\\S+))+", this::startGame);
    }

    public void run() {
        getCommandInLoop(functions);
    }

    @Override
    protected void gotoMenu() {
        String nextMenuName = matcher.group("menuName");
        if (nextMenuName.equals("profile menu")) {
            ProfileMenu profileMenu = new ProfileMenu(loggedInUser);
            profileMenu.run();
        } else if (nextMenuName.equals("game menu"))
            System.out.println("Enter: 'play game --player1 ali --player2 sajjad' to start a game.");
        else if (nextMenuName.equals("login menu"))
            loopFlag = false;
        else
            System.out.println("menu navigation is not possible");
    }

    private void startGame() {
        Matcher matcher1 = Pattern.compile("(?<player> (--player|-p)(?<numberPlayer>[1-9][0-9]*) (?<username>\\S+))").matcher(command);
        List<Player> players = new ArrayList<>();
        while (matcher1.find()) {
            String username = matcher1.group("username");
            User user = Database.getUser(username);
            if (user == null) {
                System.out.println("No user exists with name: " + username);
                return;
            }
            players.add(new Player(user));
        }
        System.out.println("Starting the game...");
        Database.setPlayers(players);
        GameController gameController = new GameController();
        gameController.gameLoop();
    }

    private void logout() {
        System.out.println("logged out.");
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.run();
    }

    private void loadGame() {
        try {
            FileInputStream fileStream = new FileInputStream(Database.getSaveGamePath());
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);

            Database.setPlayers((List<Player>) objectStream.readObject());
            Database.gameMap = (GameMap) objectStream.readObject();
            Database.map = (Tile[][]) objectStream.readObject();

            fileStream.close();
            objectStream.close();
        } catch (Exception e) {
            System.out.println("Can not load game :(");
            System.out.println("Error : " + Arrays.toString(e.getStackTrace()));
            return;
        }
        GameController gameController = new GameController();
        gameController.gameLoop();
    }

    //FOR TEST ONLY
    public void autoStartGame() {
        command = "play game -p1 ali -p2 sajad";
        System.out.println(command);
        startGame();
    }
}
