package view;

import model.User;

import java.util.regex.Matcher;

public class MainMenu extends LoginMenu {
    protected User loggedInUser;

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
