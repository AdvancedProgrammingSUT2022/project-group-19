package view;

import controller.Controller;
import model.Database;
import model.Function;
import model.User;

import java.util.HashMap;

public class  ProfileMenu extends MainMenu {

    private final HashMap<String, Function> functions = new HashMap<>();

    public ProfileMenu(User loggedInUser) {
        super(loggedInUser);
        functions.putAll(basicFunctions);
        functions.put("^profile change (--nickname|-n) (?<nickname>.+)$", this::changeNickname);
        functions.put("profile change (--password|-p)(?<args>(?=.+(-c|--current) (\\S+))(?=.+(-n|--new) (\\S+)).+)", this::changePassword);
    }

    public void run() {
        getCommandInLoop(functions);
    }

    @Override
    protected void gotoMenu() {
        String nextMenuName = matcher.group("menuName");
        if (nextMenuName.equals("main menu"))
            loopFlag = false;
        else
            System.out.println("menu navigation is not possible");
    }

    private void changePassword() {
        String currentPassword = args.get("-c") != null ? args.get("-c") : args.get("--current");
        String newPassword = args.get("-n") != null ? args.get("-n") : args.get("--new");
        String message = Controller.changePassword(currentPassword, newPassword, loggedInUser);
        Database.updateUsersFile();
        System.out.println(message);
    }

    private void changeNickname() {
        String message = Controller.changeNickname(matcher.group("nickname"), loggedInUser);
        Database.updateUsersFile();
        System.out.println(message);
    }
}
