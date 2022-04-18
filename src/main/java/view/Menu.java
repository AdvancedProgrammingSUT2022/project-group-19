package view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    protected String command;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            command = scanner.nextLine();

        }
    }

    protected Matcher getCommandMatcher(String command, String regex){
        Matcher matcher = Pattern.compile(regex).matcher(command);
        return matcher.matches() ? matcher : null;
    }
}
