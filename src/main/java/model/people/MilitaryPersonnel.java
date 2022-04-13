package model.people;

public class MilitaryPersonnel extends Unit{
    private int attackRange;

    public MilitaryPersonnel(int speed, int militaryPower, int attackRange) {
        super(speed, militaryPower);
        this.attackRange = attackRange;
    }
}
