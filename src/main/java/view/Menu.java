package view;

import model.Function;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Matcher matcher;
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

    protected void menuLoop(HashMap<String, Function> functions) {
        while (true) {
            String command = scanner.nextLine();
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
    }
}
