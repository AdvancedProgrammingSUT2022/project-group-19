package view;

import controller.Controller;
import model.Database;
import model.Function;

import java.util.HashMap;

public class ProfileMenu extends MainMenu {
    private final HashMap<String, Function> functions = new HashMap<>();

    public ProfileMenu() {
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
        String currentPassword = matcher.group("currentPassword>");
        String newPassword = matcher.group("newPassword");
        String massage = Controller.changePassword(currentPassword, newPassword, loggedInUser);
        System.out.println(massage);
    }

    private void changeNickname() {
        String nickname  = matcher.group("nickName");
        String massage = Controller.changeNickname(nickname, loggedInUser);
        System.out.println(massage);
    }
}
