package model;

import model.technology.Technology;
import model.unit.Unit;

import java.util.ArrayList;

public class Ruin {
    ArrayList<Technology> technologies;
    Unit settler = null;
    Unit worker = null;
    int gold;
    boolean FogOfWarRemover = false;
    boolean haveOnePerson = false;

    public Ruin() {
        //generate a ruin with random initialized fields
    }
}
