//بسم الله الرحمن الرحیم

import controller.Controller;
import model.Database;
import view.LoginMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to our amazing game! ❤💻✋✔🎁💕⚡");

        //print the map [FOR TEST]
        Controller.printMap();

        //get the information from file in the beginning:
        Database.readSavedUsers();

        //enter the menu:
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.run();
    }
}