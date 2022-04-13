package model.people;

public class Unit {
    private int speed;
    private int power;
    // todo ( ertegha ?? )


    public Unit(int speed, int militaryPower) {
        this.speed = speed;
        power = militaryPower;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void move(){}

    public void sleep(){}

    public void standby(){}

    public void reinforcement(){}

    public void fullReinforcement(){}

    public void settle(){}

    public void plunder(){}

    public void cancel(){}

    public void wakeUp(){}

    public void removeUnit(){}

}
