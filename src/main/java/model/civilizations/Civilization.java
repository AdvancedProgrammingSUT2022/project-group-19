package model.civilizations;

import model.technology.Technology;

import java.util.ArrayList;

public class Civilization {
    private String name;
    private String leaderName;
    private ArrayList<City> cities;
    private ArrayList<Technology> reachedTechs;
    private ArrayList<Technology> InStudyTechs;
    private int Gold;
    private int production;
    private int happinessIndex;
    private int scienceIndex;
    private int population;
    private int cups;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public ArrayList<Technology> getReachedTechs() {
        return reachedTechs;
    }

    public void setReachedTechs(ArrayList<Technology> reachedTechs) {
        this.reachedTechs = reachedTechs;
    }

    public ArrayList<Technology> getInStudyTechs() {
        return InStudyTechs;
    }

    public void setInStudyTechs(ArrayList<Technology> inStudyTechs) {
        InStudyTechs = inStudyTechs;
    }

    public int getGold() {
        return Gold;
    }

    public void setGold(int gold) {
        Gold = gold;
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    public int getHappinessIndex() {
        return happinessIndex;
    }

    public void setHappinessIndex(int happinessIndex) {
        this.happinessIndex = happinessIndex;
    }

    public int getScienceIndex() {
        return scienceIndex;
    }

    public void setScienceIndex(int scienceIndex) {
        this.scienceIndex = scienceIndex;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }
}
