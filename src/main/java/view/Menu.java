package view;

import model.Function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    protected Scanner scanner = new Scanner(System.in);
    protected String command;
    protected Matcher matcher;
    protected HashMap<String, String> args;
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

    protected HashMap<String, String> getArgs(String input) {
        ArrayList<String> args = new ArrayList<>();
        Matcher nonSpace = Pattern.compile("\\S+").matcher(input);
        while (nonSpace.find())
            args.add(nonSpace.group());
        if (args.size() % 2 != 0) {
            System.out.println("the number of args is not even");
            return null;
        }
        HashMap<String, String> argsHashMap = new HashMap<>();
        for (int i = 0; i < args.size(); i++) {
            if (args.get(i).charAt(0) != '-') {
                System.out.println("insert - or -- before each option");
                return null;
            }
            if (argsHashMap.get(args.get(i)) != null) {
                System.out.println("repeated switch error");
                return null;
            }
            argsHashMap.put(args.get(i), args.get(++i));
        }
        return argsHashMap;
    }


    protected void getCommandInLoop(HashMap<String, Function> functions) {
        while (loopFlag)
            getCommandOnce(functions);
        loopFlag = true;
    }

    protected void getCommandOnce(HashMap<String, Function> functions) {
        command = scanner.nextLine();
        boolean validCommand = false;
        args = new HashMap<>();
        for (String regex : functions.keySet()) {
            matcher = Pattern.compile(regex).matcher(command);
            if (matcher.find()) {
                if (functions.get(regex) == null)
                    loopFlag = false;
                try {
                    args = getArgs(matcher.group("args"));
                    if (args == null) break;
                } catch (IllegalArgumentException ignored) {
                }
                functions.get(regex).function();
                validCommand = true;
                break;
            }
        }
        if (!validCommand)
            System.out.println("invalid command");
    }
}
