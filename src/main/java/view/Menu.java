package view;

import model.Database;
import model.Function;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    protected Database database = new Database();
    protected Scanner scanner = new Scanner(System.in);
    protected String command;
    protected Matcher matcher;
    protected boolean loopFlag = true;

    protected HashMap<String, Function> basicFunctions = new HashMap<>() {{
        put("^menu exit$", null);
        put("^menu show-current$", () -> showCurrentMenu());
        put("^menu enter (?<menuName>(login menu|main menu|profile menu|game menu))$", () -> gotoMenu());
    }};

    protected void gotoMenu() {
        System.out.println("menu navigation is not possible");
    }

    protected void showCurrentMenu() {
        String className = this.getClass().getSimpleName();
        System.out.println(className);
    }

    protected void getCommand(HashMap<String, Function> functions) {
        while (loopFlag) {
            command = scanner.nextLine();
            boolean validCommand = false;
            for (String regex : functions.keySet()) {
                matcher = Pattern.compile(regex).matcher(command);
                if (matcher.find()) {
                    if (functions.get(regex) == null)
                        return;
                    functions.get(regex).function();
                    validCommand = true;
                    break;
                }
            }
            if (!validCommand)
                System.out.println("invalid command");
        }
        loopFlag = true;
    }
}
