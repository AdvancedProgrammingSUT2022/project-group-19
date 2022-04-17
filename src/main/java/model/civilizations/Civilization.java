package model.civilizations;

import model.technology.Technology;

import java.util.ArrayList;

public class Civilization {
    private String name;
    //private City capital; I think it's not needed
    private ArrayList<City> cities;
    private ArrayList<Technology> reachedTechs;
    private ArrayList<Technology> InStudyTechs;
    private Leader leader;
    private int Gold;
    private int production;
    private int happinessIndex;
    private int scienceIndex;
    private int population;
    private int cups;

}
