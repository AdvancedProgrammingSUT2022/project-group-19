package controller;

import model.Database;
import model.Player;
import model.User;
import model.civilizations.Civilization;
import model.land.Tile;
import model.unit.Unit;


public class Controller {
    static public String addUser(String username, String password, String nickname) {
        if (Database.getUser(username) != null)
            return "user with username " + username + " already exists";
        else if (Database.getUserByNickname(nickname) != null)
            return "user with nickname " + nickname + " already exists";
        User newUser = new User(username, password, nickname);
        Database.addUser(newUser);
        return "user created successfully!";
    }

    static public String changePassword(String currentPassword, String newPassword, User loggedInUser) {
        if (!loggedInUser.getPassword().equals(currentPassword))
            return "current password is invalid";
        if (loggedInUser.getPassword().equals(newPassword))
            return "please enter a new password";
        loggedInUser.setPassword(newPassword);
        return "password changed successfully!";
    }

    static public String changeNickname(String nickname, User loggedInUser) {
        if (Database.getUserByNickname(nickname) != null)
            return "user with nickname " + nickname + " already exists";
        loggedInUser.setNickname(nickname);
        return "nickname changed successfully!";
    }

    static public String loginCheck(String username, String password) {
        if (Database.getUser(username) == null || !Database.getUser(username).getPassword().equals(password))
            return "Username and password didn't match!";
        return "user logged in successfully!";
    }

    static public void printMap() {
        Tile[][] map = Database.map;

        for (int i = 0; i < 4; i++)
            printRow(i, map);

    }

    private static void printRow(int row, Tile[][] map) {
        String[] hex = {
                "  /       \\         ",
                " /         \\        ",
                "/           \\_______",
                "\\           /       ",
                " \\         /        ",
                "  \\_______/         "
        };
        for (int k = 0; k < hex.length; k++) {
            for (int i = 0; i < 5; i++) {
                if (k == 2) {
                    StringBuilder str = new StringBuilder(map[row][i].getType().toString());
                    int numOfSpace = 10 - str.length();
                    str.append(" ".repeat(Math.max(0, numOfSpace)));
                    System.out.print("/ " + str + "\\_______");
                } else
                    System.out.print(hex[k]);
            }
            System.out.println();
        }
    }

    public static boolean isInSight(Player player, int x, int y) {
        Civilization civil = player.getCivilization();
        for (Unit unit : civil.getUnits()) {
            //TODO x y of unit
            int x_unit = 1;
            int y_unit = 1;
            civil.fogOfWarFlags[x_unit][y_unit] = 1; //area is visible
            if (nearEachOther(unit.getPosition(), x, y))
                return true;
        }
        return false;
    }

    private static boolean nearEachOther(Tile position, int x, int y) {
        //TODO: this method
        return true;
    }
}

//  /       \
// /         \
///           \_______
//\           /
// \         /
//  \_______/