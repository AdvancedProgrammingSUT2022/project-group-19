package model.people;

public class ArcherSoldier extends MilitaryPersonnel{
    private int attackPowerFromAfar;

    public ArcherSoldier(int speed, int militaryPower, int attackRange, int attackPowerFromAfar) {
        super(speed, militaryPower, attackRange);
        this.attackPowerFromAfar = attackPowerFromAfar;
    }
}
