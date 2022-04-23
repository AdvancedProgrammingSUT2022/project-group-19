package view;

import controller.menucontroller.ProfileMenuController;
import model.Function;
import model.User;

import java.util.HashMap;
import java.util.Scanner;

public class ProfileMenu extends MainMenu {
    private ProfileMenuController profileMenuController;
    private User user;

    private final HashMap<String, Function> regexToFunction = new HashMap<>(){{
        put("^menu enter (?<menuName>.+)$", () -> System.out.println("hello"));
        put("^menu exit$", () -> System.out.println("hello"));
        put("^menu show-current$", () -> System.out.println("hello"));
        put("^profile change --nickname (?<nickname>.+)$", () -> System.out.println("hello"));
        put("^profile change --password --current (?<currentPassword>.+) --new (?<newPassword>.+)$", () -> System.out.println("hello"));
    }};

    public ProfileMenu(User user){
        this.user = user;
        this.profileMenuController = new ProfileMenuController(user);
    }

    public void run(Scanner scanner) {
        String showMenuRegex = "";
        String changeNicknameRegex = "";
        String changePasswordRegex = "";
        String exitMenuRegex = "";
        while (true) {
            command = scanner.nextLine();
            if(getCommandMatcher(command, showMenuRegex) != null){
                System.out.println("Profile Menu");
            }else if(getCommandMatcher(command, changeNicknameRegex) != null){

            }else if(getCommandMatcher(command, changePasswordRegex) != null){

            }else if(getCommandMatcher(command, exitMenuRegex) != null){
                break;
            }else System.out.println("invalid command :)");
        }
    }

}
