package controller.menucontroller;

import model.User;

import java.util.regex.Matcher;

public class LoginMenuController {

    private boolean checkUniqueNickname(String nickname){
        return true;
    }

    private boolean checkUniqueUsername(String username){
        return true;
    }

    private boolean checkUniquePassword(String password){
        return true;
    }

    private void registerUser(User user){

    }

    private boolean isAvailableUser(User user){
        return true;
    }

    private boolean isCorrectPassword(User user, String password){
        return true;
    }

    protected void enterMenu(Matcher matcher) {

    }
}
