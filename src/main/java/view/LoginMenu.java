package view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenu {
    protected String command;
    protected Scanner scanner = new Scanner(System.in);

    public void run() {
        String showMenuRegex = "menu show-current";
        String exitMenuRegex = "";
        String createUserRegex = "user create --username (?<username>) --nickname <nickname> --password <password>";
        String loginUserRegex = "";
        String enterMenuRegex = "";
        command = scanner.nextLine();
        while (true) {
            if (getCommandMatcher(command, enterMenuRegex) != null) {

            } else if (getCommandMatcher(command, showMenuRegex) != null) {
                System.out.println("Login Menu");
            } else if (getCommandMatcher(command, createUserRegex) != null) {

            } else if (getCommandMatcher(command, loginUserRegex) != null) {

            } else if (getCommandMatcher(command, exitMenuRegex) != null) {
                break;
            } else System.out.println("invalid command :)");
        }
    }
    protected Matcher getCommandMatcher(String command, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(command);
        return matcher.matches() ? matcher : null;
    }

    protected void printMenuName() {
    }

}
