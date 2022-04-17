package controller.modelControllers;

import model.building.Building;
import model.civilizations.City;
import model.civilizations.Civilization;
import model.technology.Technology;

import java.util.ArrayList;

public class BuildingController {
    private ArrayList<Civilization> civilizations =  new ArrayList<>();



    public boolean isValidTechnology(Civilization civilization, Technology technology){
        return civilization.getReachedTechs().contains(technology);
    }

    public void buildCastle(Civilization civilization){

    }

    public void DestroyingMilitaryBuildings(City city){

    }

    public void randomDestroyingOtherBuildings(City city){

    }

    public int castleGoldProduction(Civilization civilization){

    }

    public int castleScienceProduction(Civilization civilization){

    }

    public int castleProduction(Civilization civilization){

    }

    public void payBuildingMaintenance(Building building){

    }

    public void changeBuilding(City city){

    }

    public void CreateAnExpert(Building building){

    }

    public int growthRateCity(){

    }

    public void buildBuilding(){

    }
}
