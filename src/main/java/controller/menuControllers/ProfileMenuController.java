package controller.menuControllers;

import model.User;

public class ProfileMenuController {
    private User user;

    public ProfileMenuController(User user){
        this.user = user;
    }

    public void changePassword(String newPassword){

    }

    public boolean checkNewPassword(String newPassword){
        return true;
    }

    public void changeNickname(String newNickname){

    }

    public boolean checkNewNickname(String newNickname){
        return true;
    }



}
