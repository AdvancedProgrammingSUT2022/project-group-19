package view;

import model.Function;
import model.User;

import java.util.HashMap;
import java.util.regex.Matcher;

public class MainMenu extends Menu {
    protected User loggedInUser;
    private final HashMap<String, Function> regexToFunction = new HashMap<>(){{
        put("^menu enter (?<menuName>.+)$", () -> System.out.println("hello"));
        put("^menu exit$", () -> System.out.println("hello"));
        put("^menu show-current$", () -> System.out.println("hello"));
        put("^user logout$", () -> System.out.println("hello"));
        put("^play game --player1 (?<username1>.+) --player2 (?<username2>.+).*", () -> System.out.println("hello"));
    }};

    public void run() {
        String enterMenuRegex = "";
        String exitMenuRegex = "";
        String showNameMenuRegex = "";
        while (true) {
            command = scanner.nextLine();
            if (getCommandMatcher(command, enterMenuRegex) != null) {

            } else if (getCommandMatcher(command, showNameMenuRegex) != null) {

            } else if (getCommandMatcher(command, exitMenuRegex) != null) {

            } else System.out.println("invalid command :)");
        }
    }

    private void startGame(Matcher matcher) {
    }
}
