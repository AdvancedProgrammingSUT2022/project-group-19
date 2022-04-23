package view;

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
        menuLoop(functions);
    }

    @Override
    protected void gotoMenu() {
        System.out.println("menu navigation is not possible");
    }

    private void changePassword() {
        //TODO
        System.out.println("change password");
    }

    private void changeNickname() {
        //TODO
        System.out.println("change nickname");
    }
}
