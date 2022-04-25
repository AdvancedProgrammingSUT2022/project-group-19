package model.civilizations;

import model.technology.Technology;
import model.unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class Civilization {
    private String leaderName;
    private List<Unit> units;
    private List<City> cities;
    private List<Technology> reachedTechs;
    private List<Technology> InStudyTechs;
    private int Gold;
    private int production;
    private int happinessIndex;
    private int scienceIndex;
    private int population;
    private int cups;
    public int[][] fogOfWarFlags;


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

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public void setReachedTechs(List<Technology> reachedTechs) {
        this.reachedTechs = reachedTechs;
    }

    public List<Technology> getReachedTechs() {
        return reachedTechs;
    }

}
