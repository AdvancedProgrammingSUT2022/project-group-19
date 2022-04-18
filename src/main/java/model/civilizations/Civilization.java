package model.civilizations;

import model.technology.Technology;
import model.unit.Unit;

import java.util.ArrayList;

public class Civilization {
    private String leaderName;
    private ArrayList<Unit> units;
    private ArrayList<City> cities;
    private ArrayList<Technology> reachedTechs;
    private ArrayList<Technology> InStudyTechs;
    private int Gold;
    private int production;
    private int happinessIndex;
    private int scienceIndex;
    private int population;
    private int cups;


    /*
     * This method must be called at the beginning of each turn.
     */
    public void turnStart() {
        //prepare units
        for (Unit unit : units)
            unit.resetMP();


        //spend gold each turn
        //buildings
        //roads
        //units
        //
    }



    public ArrayList<Technology> getReachedTechs() {
        return reachedTechs;
    }

}
