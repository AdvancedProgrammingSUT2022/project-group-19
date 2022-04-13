package model.people;

public class Unit {
    private int speed;
    private int MilitaryPower;
    // todo ( ertegha ?? )


    public Unit(int speed, int militaryPower) {
        this.speed = speed;
        MilitaryPower = militaryPower;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMilitaryPower() {
        return MilitaryPower;
    }

    public void setMilitaryPower(int militaryPower) {
        MilitaryPower = militaryPower;
    }
}
