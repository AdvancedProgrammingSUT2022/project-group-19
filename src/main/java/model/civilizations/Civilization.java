package model.civilizations;

import model.Player;
import model.building.Building;
import model.resource.ResourceType;
import model.technology.Technology;
import model.unit.Unit;
import model.unit.UnitType;
import model.unit.Worker;

import java.io.Serializable;
import java.util.*;

public class Civilization implements Serializable {
    private String leaderName;
    private List<Unit> units = new ArrayList<>();
    private List<City> cities = new ArrayList<>();
    private List<Technology> reachedTechs = new ArrayList<Technology>() {{
        add(Technology.AGRICULTURE);
    }};
    private Technology inStudyTech;
    private HashMap<Technology, Integer> pausedInStudyTechs = new HashMap<>();
    private List<String> notification = new ArrayList<>();

    private int gold;
    private int production;
    private int happinessIndex;
    private int cupOfScience;
    public int[][] fogOfWarFlags;
    private List<ResourceType> resources = new ArrayList<>();
    private int technologyCounter = 0;
    private int turnCounter = 0;


    /*
     * This method must be called at the beginning of each turn.
     */
    public void eachTurn() {
        turnCounter++;

        //reset the MP of all units
        for (Unit unit : units)
            unit.resetMP();

        //add science
        int amount = 3;
        for (City city : this.getCities()) {
            if (city.getBuildings().contains(Building.LIBRARY) || city.getBuildings().contains(Building.UNIVERSITY))
                amount += 2 * city.getPopulation();
            else
                amount += city.getPopulation();
        }
        this.addCupOfScience(amount);

        //research and techs
        if (technologyCounter != 0) {
            technologyCounter--;
            if (technologyCounter == 0) {
                reachedTechs.add(inStudyTech);
                log("You have reached the technology " + inStudyTech);
                inStudyTech = null;
                if (pausedInStudyTechs.size() != 0) {
                    Map.Entry<Technology, Integer> entry = pausedInStudyTechs.entrySet().iterator().next();
                    inStudyTech = entry.getKey();
                    technologyCounter = entry.getValue();
                    pausedInStudyTechs.remove(entry.getKey());
                }
            }
        }


        //workers:
        for (int i = 0; i < units.size(); i++) {
            if(units.get(i).getType().equals(UnitType.WORKER)){
                System.out.println(units.get(i).getWorkCounter());
                Worker worker = (Worker) units.get(i);
                System.out.println(worker.getWorkCounter());
                worker.work();
            }
        }


        //TODO:
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

    public int getHappinessIndex() {
        return happinessIndex;
    }

    public void setHappinessIndex(int happinessIndex) {
        this.happinessIndex = happinessIndex;
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public boolean hasUnit(Unit unit) {
        for (Unit unitInList : units)
            if (unit == unitInList)
                return true;
        return false;
    }

    public void deleteUnit(Unit unit) {
        units.remove(unit);
    }

    public void addGold(int amount) {
        this.gold += amount;
    }

    public int getCupOfScience() {
        return cupOfScience;
    }

    public void addCupOfScience(int amount) {
        this.cupOfScience += amount;
    }


    public int getPopulation() {
        int amount = 0;
        for (City city : this.getCities())
            amount += city.getPopulation();
        return amount;
    }

    public Technology getInStudyTech() {
        return inStudyTech;
    }

    public HashMap<Technology, Integer> getPausedInStudyTechs() {
        return pausedInStudyTechs;
    }

    public void studyTech(Technology technology, int counter) {
        if (inStudyTech != null) {
            pausedInStudyTechs.put(inStudyTech, technologyCounter);
            if (pausedInStudyTechs.get(technology) != null) {
                inStudyTech = technology;
                technologyCounter = pausedInStudyTechs.get(technology);
                pausedInStudyTechs.remove(technology);
                log("You have started researching about the technology " + inStudyTech);
                return;
            }
        }
        inStudyTech = technology;
        technologyCounter = counter;
        log("You have started researching about the technology " + inStudyTech);
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public ArrayList<Technology> getAvailableForStudyTechs() {
        ArrayList<Technology> result = new ArrayList<>();
        for (Technology technology : Technology.values()) {
            boolean havePreTech = true;
            if (technology.getPrerequisiteTechs() != null) {
                for (Technology preTech : technology.getPrerequisiteTechs()) {
                    if (!reachedTechs.contains(preTech)) {
                        havePreTech = false;
                        break;
                    }
                }
            }
            if (havePreTech)
                result.add(technology);
        }
        result.removeAll(getReachedTechs());
        return result;
    }

    public List<Unit> getMilitaryUnits() {
        List<Unit> result = new ArrayList<>();
        for (Unit unit : units)
            if (unit.isMilitary())
                result.add(unit);
        return result;
    }

    public List<String> getNotification() {
        return notification;
    }

    public void log(String notificationSting) {
        notification.add("turn: " + turnCounter + "- " + notificationSting);
    }
}
