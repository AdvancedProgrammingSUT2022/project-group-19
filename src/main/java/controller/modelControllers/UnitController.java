package controller.modelControllers;

import model.land.Land;
import model.land.LandType;
import model.technology.Technology;
import model.unit.Unit;

public class UnitController {
    private Unit unit;

    public UnitController(Unit unit) {
        this.unit = unit;
    }

    public void move(Land destination) {
        //Calculate the distance of the destination
//        int distance = 1;
//        movePoint -= distance;
//        if (movePoint >= 0) {
//            if (destination.getType().equals(LandType.RIVER))
//                movePoint = 0;
//            //move the unit
//        }
    }

    public void sleep() {
    }

    public void standby() {
    }

    public void reinforcement() {
    }

    public void fullReinforcement() {
    }

    public void settle() {
    }

    public void plunder() {
    }

    public void cancel() {
    }

    public void wakeUp() {
    }

    public void removeUnit() {
    }

    //combat
    public void AttackOtherUnits(Unit enemyUnit){

    }
    public boolean checkIfInWar(Unit enemyUnit){
        return false;
    }
    public void coldWeaponAttack(Unit enemyUnit){

    }
    public void rangedAttack(Unit enemyUnit){

    }

}
