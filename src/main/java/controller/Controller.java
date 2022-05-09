package controller;

import model.*;
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
        String areaColor = Color.RESET;
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
                        String unitName = getInformation("militaryUnit", i + 1, map[rowOfMap]);
                        System.out.print("  /" + information + "\\ " + unitName + " ");
                    } else if (rowInHex == 1) {
                        String information = getInformation("feature", i, map[rowOfMap]);
                        String unitName = getInformation("civilianUnit", i + 1, map[rowOfMap]);
                        System.out.print(" / " + information + " \\ " + unitName);
                    } else if (rowInHex == 2) {
                        String information = getInformation("landType", i, map[rowOfMap]);
                        System.out.print("/  " + information + "  \\_______");
                    } else if (rowInHex == 3) {
                        String information = getInformation("resource", i + 1, map[rowOfMap]);
                        String unitName = getInformation("militaryUnit", i, map[rowOfMap]);
                        System.out.print("\\  " + unitName + "  /" + information);
                    } else if (rowInHex == 4) {
                        String information = getInformation("feature", i + 1, map[rowOfMap]);
                        String unitName = getInformation("civilianUnit", i, map[rowOfMap]);
                        System.out.print(" \\ " + unitName + " / " + information);
                    } else {
                        String information = getInformation("landType", i + 1, map[rowOfMap]);
                        System.out.print("  \\_______/  " + information);
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }

    private static String getInformation(String information, int columnOfMap, Tile[] map) {
        StringBuilder turnColor = new StringBuilder("");
        StringBuilder str = new StringBuilder();
        if (information.equals("landType"))
            str.append(map[columnOfMap].getType().toString());
        else if (information.equals("feature"))
            str.append(map[columnOfMap].getFeature().toString());
        else if (information.equals("unit"))
            return null;
        else if (information.equals("resource")) {
            ResourceType resource = map[columnOfMap].getResource();
            if (resource != null)
                str.append(resource.toString());
        } else if (information.equals("civilianUnit")) {
            Unit unit = map[columnOfMap].getCivilianUnit();
            if (unit != null) {
                if (unit.getCivilization().equals(Database.getPlayers().get(0).getCivilization()))
                    turnColor = new StringBuilder(Color.BLUE);
                else
                    turnColor = new StringBuilder(Color.RED);
                str = new StringBuilder(turnColor + unit.getType().toString());
            }
        } else if (information.equals("militaryUnit")) {
            Unit unit = map[columnOfMap].getMilitaryUnit();
            if (unit != null) {
                if (unit.getCivilization().equals(Database.getPlayers().get(0).getCivilization()))
                    turnColor = new StringBuilder(Color.BLUE);
                else
                    turnColor = new StringBuilder(Color.RED);
                str = new StringBuilder(turnColor + unit.getType().toString());
            }
        } else
            throw new RuntimeException();


        if (str.toString().equals("NULL"))
            str = new StringBuilder("");


        if (str.length() > 7 + turnColor.length()) {
            str.setLength(7 + turnColor.length());
        } else if (str.length() == 0) {
            str.append(" ".repeat(7));
        } else {
            str.append(" ".repeat(7 + turnColor.length() - str.length()));
        }
        str.append(Color.RESET);
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

    public static boolean isInvalidCoordinate(int x, int y) {
        return (x < 1 || x > GameMap.getNumOfRows() || y < 1 || y > GameMap.getNumOfCols());
    }
}

//  /       \
// /         \
///           \_______
//\           /
// \         /
//  \_______/