package model;

import model.civilizations.Civilization;

public class Player {
    private final User user;
    private Civilization civilization = new Civilization();

    public Player(User user){
        this.user = user;
    }

    public void setCivilization(Civilization civilization){
        this.civilization = civilization;
    }

    public User getUser() {
        return user;
    }

    public Civilization getCivilization() {
        return civilization;
    }
}
