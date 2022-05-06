package controller;

import model.Database;
import model.Message;
import model.Player;
import model.User;
import model.civilizations.Civilization;
import model.land.Tile;
import model.resource.ResourceType;
import model.unit.Unit;

import java.util.Arrays;


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

    static public Message loginCheck(String username, String password) {
        if (Database.getUser(username) == null || !Database.getUser(username).getPassword().equals(password))
            return Message.loginFail;
        return Message.loginOK;
    }

    static public void printMap() {
        Tile[][] map = Database.map;
        String[] hex = {
                "  /       \\         ",
                " /         \\        ",
                "/           \\_______",
                "\\           /       ",
                " \\         /        ",
                "  \\_______/         "
        };
        for (int rowOfMap = 0; rowOfMap < 5; rowOfMap++) {
            for (int rowInHex = 0; rowInHex < hex.length; rowInHex++) {
                for (int i = 0; i < 14; i += 2) {
                    if (rowInHex == 0) {
                        String information = getInformation("resource", i, map[rowOfMap]);
                        System.out.print("  /" + information + "\\         ");
                    } else if (rowInHex == 1) {
                        String information = getInformation("feature", i, map[rowOfMap]);
                        System.out.print(" / " + information + " \\        ");
                    } else if (rowInHex == 2) {
                        String information = getInformation("landType", i, map[rowOfMap]);
                        System.out.print("/  " + information + "  \\_______");
                    } else if (rowInHex == 4) {
                        String information = getInformation("feature", i + 1, map[rowOfMap]);
                        System.out.print(" \\         / " + information);
                    } else if (rowInHex == 5) {
                        String information = getInformation("landType", i + 1, map[rowOfMap]);
                        System.out.print("  \\_______/  " + information);
                    } else
                        System.out.print(hex[rowInHex]);
                }
                System.out.println();
            }
        }
    }

    private static String getInformation(String information, int columnOfMap, Tile[] map) {
        StringBuilder str = null;
        if (information.equals("landType"))
            str = new StringBuilder(map[columnOfMap].getType().toString());
        else if (information.equals("feature"))
            str = new StringBuilder(map[columnOfMap].getFeature().toString());
        else if (information.equals("unit"))
            return null;
        else if (information.equals("resource")) {
            ResourceType resource = map[columnOfMap].getResource();
            if (resource == null)
                str = new StringBuilder("");
            else
                str = new StringBuilder(resource.toString());
        } else if (information.equals("none"))
            str = new StringBuilder("");
        else
            throw new RuntimeException();

        if (str.toString().equals("NULL"))
            str = new StringBuilder("");

        if (str.length() >= 7)
            str.setLength(7);
        else
            str.append(" ".repeat(7 - str.length()));

        return String.valueOf(str);
    }

    public static boolean isInSight(Player player, int x, int y) {
        Civilization civil = player.getCivilization();
        for (Unit unit : civil.getUnits()) {
            //TODO x y of unit
            int x_unit = 1;
            int y_unit = 1;
            civil.fogOfWarFlags[x_unit][y_unit] = 1; //area is visible
            if (nearEachOther(unit.getTile(), x, y))
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