package view;

import controller.Controller;
import model.Database;
import model.Function;
import model.Message;
import model.User;

import java.util.HashMap;

public class LoginMenu extends Menu {
    private final HashMap<String, Function> functions = new HashMap<>();

    public LoginMenu() {
        Database.readSavedUsers();
        functions.putAll(basicFunctions);
        functions.put("user login(?<args>(?=.+(-u|--username) (\\S+))(?=.+(-p|--password) (\\S+)).+)", this::login);
        functions.put("user create(?<args>(?=.+(-u|--username) (\\S+))(?=.+(-p|--password) (\\S+))(?=.+(-n|--nickname) (\\S+)).+)", this::addUser);
    }

    public void run() {
        getCommandInLoop(functions);
    }

    @Override
    protected void gotoMenu() {
        String nextMenuName = matcher.group("menuName");
        if (nextMenuName.equals("main menu"))
            System.out.println("Please login first.\nEnter: 'user login --username <your username> --password <your password>' to login.");
        else
            System.out.println("menu navigation is not possible");
    }

    private void addUser() {
        String username = args.get("-u") != null ? args.get("-u") : args.get("--username");
        String password = args.get("-p") != null ? args.get("-p") : args.get("--password");
        String nickname = args.get("-n") != null ? args.get("-n") : args.get("--nickname");
        String message = Controller.addUser(username, password, nickname);
        System.out.println(message);
    }

    private void login() {
        String username = args.get("-u") != null ? args.get("-u") : args.get("--username");
        String password = args.get("-p") != null ? args.get("-p") : args.get("--password");
        Message message = Controller.loginCheck(username, password);
        System.out.println(message.getErrorMessage());
        if (message.equals(Message.loginOK)) {
            User loggedInUser = Database.getUser(username);
            MainMenu mainMenu = new MainMenu(loggedInUser);
            mainMenu.run();
        }
    }

    //FOR TEST ONLY
    public void autoLogin(){
        System.out.println("user login -u ali -p aaaa");
        Message message = Controller.loginCheck("ali", "aaaa");
        System.out.println(message.getErrorMessage());
        if (message.equals(Message.loginOK)) {
            User loggedInUser = Database.getUser("ali");
            MainMenu mainMenu = new MainMenu(loggedInUser);
            mainMenu.autoStartGame();
        }
    }
}
