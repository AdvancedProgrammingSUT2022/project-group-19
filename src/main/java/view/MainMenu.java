package view;

import model.User;

import java.util.regex.Matcher;

public class MainMenu extends LoginMenu {
    protected User loggedInUser;

    public void run() {
        while (true) {
            command = scanner.nextLine();

        }
    }

    private void startGame(Matcher matcher) {
    }
}
