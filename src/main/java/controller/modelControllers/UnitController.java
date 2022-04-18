package controller.modelControllers;

import model.civilizations.City;
import model.land.Land;
import model.unit.Unit;

import java.util.ArrayList;

public class UnitController {
    private Unit unit;

    public UnitController(Unit unit) {
        this.unit = unit;
    }

    public void makeNewCity(){

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

    public void checkIfOnRuin(){

    }

    //combat
    public void AttackOtherUnits(Unit enemyUnit) {

    }

    public boolean checkIfInWar(Unit enemyUnit) {
        return false;
    }

    public void coldWeaponAttackToUnit(Unit enemyUnit) {

    }

    public void rangedAttackToUnit(Unit enemyUnit) {

    }

    public void coldWeaponAttackToCity(City enemyCity) {

    }

    public void rangedAttackToCity(City enemyCity) {

    }

    public ArrayList<Land> visibleArea() {
        return null;
    }

    public void giveBattleReward() {

    }

    public void alert() {

    }
    public void fortify(){

    }
    public void SiegePreAttack(){

    }
}
