package model.civilizations;

import model.resource.ResourceType;
import model.technology.Technology;
import model.unit.Unit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Civilization {
    private String leaderName;
    private List<Unit> units = new ArrayList<>();
    private List<City> cities = new ArrayList<>();
    private List<Technology> reachedTechs = new ArrayList<>();
    private List<Technology> InStudyTechs = new ArrayList<>();
    private int gold;
    private int production;
    private int happinessIndex;
    private int scienceIndex;
    private int population;
    private int cups;
    public int[][] fogOfWarFlags;
    private List<ResourceType> resources = new ArrayList<>();


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

    public void addUnit(Unit unit) {
        units.add(unit);
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

    public void increaseGold(int amount) {
        gold += amount;
    }

    public void decreaseGold(int amount) {
        gold -= amount;
    }

    public int getGold() {
        return gold;
    }

    public List<ResourceType> getResources() {
        //TODO: this must be done. page 13-14 game doc
        return resources;
    }

    public void addCity(City city) {
        cities.add(city);
    }

}
