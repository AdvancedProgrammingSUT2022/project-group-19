package model;

import model.civilizations.Civilization;

public class Player {
    User user;
    Civilization civilization;

    public Player(User user, Civilization civilization){
        this.civilization  = civilization;
        this.user = user;
    }
}
