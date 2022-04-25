package view;

import controller.Controller;
import model.Function;
import model.User;

import java.util.HashMap;

public class ProfileMenu extends Menu {
    private final User loggedInUser;
    private final HashMap<String, Function> functions = new HashMap<>();

    public ProfileMenu(User loggedInUser) {
        this.loggedInUser = loggedInUser;
        functions.putAll(basicFunctions);
        functions.put("^profile change --nickname (?<nickname>.+)$", this::changeNickname);
        functions.put("^profile change --password --current (?<currentPassword>.+) --new (?<newPassword>.+)$", this::changePassword);
    }

    public void run() {
        getCommand(functions);
    }

    @Override
    protected void gotoMenu() {
        System.out.println("menu navigation is not possible");
    }

    private void changePassword() {
        String message = Controller.changePassword(matcher.group("currentPassword>"), matcher.group("newPassword"), loggedInUser);
        System.out.println(message);
    }

    private void changeNickname() {
        String message = Controller.changeNickname(matcher.group("nickName"), loggedInUser);
        System.out.println(message);
    }
}
