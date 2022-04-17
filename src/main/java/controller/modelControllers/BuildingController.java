package controller.modelControllers;

import model.civilizations.Civilization;
import model.technology.Technology;

public class BuildingController {
    Civilization civilization;

    public BuildingController(){
        this.civilization = new Civilization();
    }

    public boolean isValidTechnology(Technology technology){
        return civilization.getReachedTechs().contains(technology);
    }



}
