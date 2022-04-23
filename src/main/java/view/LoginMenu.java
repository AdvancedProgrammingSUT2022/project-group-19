package view;

import model.Database;
import model.Function;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenu {
    protected Database database = new Database();
    protected Scanner scanner = new Scanner(System.in);
    protected Matcher matcher;
    private final HashMap<String, Function> functions = new HashMap<>();
    protected HashMap<String, Function> basicFunctions = new HashMap<>() {{
        put("^menu exit$", null);
        put("^menu show-current$", () -> showCurrentMenu());
        put("^menu enter (?<menuName>(login menu|main menu|profile menu|game menu))$", () -> gotoMenu());
    }};

    public LoginMenu() {
        functions.putAll(basicFunctions);
        functions.put("^user login --username (?<username>.+) --password (?<password>.+)$", this::login);
        functions.put("^user create --username (?<username>.+) --nickname (?<nickname>.+) --password (?<password>.+)$", this::addUser);
    }

    public void run() {
        menuLoop(functions);
    }

    protected void gotoMenu() {
        String nextMenuName = matcher.group("menuName");
        if (nextMenuName.equals("main menu")) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.run();
        } else
            System.out.println("menu navigation is not possible");
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

    private void addUser() {
        String username = matcher.group("username");
        String password = matcher.group("password");
        String nickname = matcher.group("nickname");
        //TODO this
        String message = "test";//= Controller.checkNewUser(username, password, nickname);
        System.out.println(message);
    }

    private void login() {
        String username = matcher.group("username");
        String password = matcher.group("password");
        //TODO this
        String message = "test";// = Controller.loginCheck(username,password);
        System.out.println(message);
    }

    protected void showCurrentMenu() {
        String className = this.getClass().getSimpleName();
        System.out.println(className);
    }
}
