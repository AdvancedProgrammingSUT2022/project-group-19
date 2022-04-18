package model;

import model.civilizations.Civilization;

public class Player {
    private final User user;
    private final Civilization civilization;

    public Player(User user, Civilization civilization){
        this.civilization  = civilization;
        this.user = user;
    }
}
