package model.game;

import model.User;
import model.civilizations.Civilization;
import model.land.Land;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private HashMap<User, Civilization> playersInGame = new HashMap<>();
    private Land[][] map = new Land[10][5];
}
