package model.technology;

import java.io.Serializable;

public class InStudyTechs implements Serializable {
    private Technology technology;
    private int remainingCups;
    //a civilization can work on only one tech at a time
    private boolean IsBeingWorkOn;
}
