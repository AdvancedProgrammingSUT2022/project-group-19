package view;

import model.Database;
import model.Function;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    protected Database database;
    protected Matcher matcher;
    protected String command;
    protected Scanner scanner = new Scanner(System.in);

    private final HashMap<String, Function> functions = new HashMap<>() {{
    }};

    public void run() {
        while (true) {
            command = scanner.nextLine();
            for (String regex : functions.keySet()) {
                matcher = Pattern.compile(regex).matcher(command);
                if (matcher.find()) {
                    if (functions.get(regex) == null)
                        return; //exit the menu
                    functions.get(regex).function();
                    break;
                }
            }
            System.out.println("invalid command");
        }
    }
}
