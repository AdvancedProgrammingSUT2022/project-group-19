package model;

import model.technology.Technology;
import model.unit.Unit;

import java.io.Serializable;
import java.util.ArrayList;

public class Ruin implements Serializable {
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
