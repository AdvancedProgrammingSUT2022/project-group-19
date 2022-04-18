package view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenu {
    protected String command;
    protected Scanner scanner = new Scanner(System.in);
    private Matcher matcher;

    public void run() {
    }

    protected Matcher getCommandMatcher(String command, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(command);
        return matcher.matches() ? matcher : null;
    }

    protected void printMenuName() {
    }


}
