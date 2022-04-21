package view;

import controller.menucontroller.ProfileMenuController;
import model.User;

import java.util.Scanner;

public class ProfileMenu extends MainMenu {
    private ProfileMenuController profileMenuController;
    private User user;

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
