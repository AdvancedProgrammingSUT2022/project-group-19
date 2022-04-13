package model.people;

public class ArcherSoldier extends MilitaryPersonnel{
    private int attackPower = 7;
    private int defencePower = 4;


    private int attackPowerFromAfar;

    public ArcherSoldier(int speed, int militaryPower, int attackRange, int attackPowerFromAfar) {
        super(speed, militaryPower, attackRange);
        this.attackPowerFromAfar = attackPowerFromAfar;
    }

    public void prepareForRemoteAttack(){}

    public void remoteAttack(){}

}
