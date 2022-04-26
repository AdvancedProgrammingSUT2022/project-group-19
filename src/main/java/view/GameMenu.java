package view;

import model.Function;

import java.util.HashMap;

public class GameMenu extends Menu {
    private final HashMap<String, Function> functions = new HashMap<>();

    public GameMenu() {
        this.functions.putAll(basicFunctions);
        this.functions.put("^info research$", this::infoResearch);
        this.functions.put("^info units$", this::infoUnits);
        this.functions.put("^info cities$", this::infoCities);
        this.functions.put("^info diplomacy$", this::infoDiplomacy);
        this.functions.put("^info victory$", this::infoVictory);
        this.functions.put("^info demographics$", this::infoDemographics);
        this.functions.put("^info notifications$", this::infoNotifications);
        this.functions.put("^info military$", this::infoMilitary);
        this.functions.put("^info economic$", this::infoEconomic);
        this.functions.put("^info diplomatic$", this::infoDiplomatic);
        this.functions.put("^info deals$", this::infoDeals);
        this.functions.put("^select unit combat X: (?<xPosition>[-]?\\d+) Y: (?<yPosition>[-]?\\d+)$", this::selectUnitCombat);
        this.functions.put("^select unit noncombat X: (?<xPosition>[-]?\\d+) Y: (?<yPosition>[-]?\\d+)$", this::selectUnitNoncombat);
        this.functions.put("^select city (?<cityName>.+)$", this::selectCityName);
        this.functions.put("^select city X: (?<xPosition>[-]?\\d+) Y: (?<yPosition>[-]?\\d+)$", this::selectCityPosition);
        this.functions.put("^unit move to X: (?<xPosition>[-]?\\d+) Y: (?<yPosition>[-]?\\d+)$", this::unitMove);
        this.functions.put("^unit sleep$", this::unitSleep);
        this.functions.put("^unit alert$", this::unitAlert);
        this.functions.put("^unit fortify$", this::unitFortify);
        this.functions.put("^unit fortify heal$", this::unitFortifyHeal);
        this.functions.put("^unit garrison$", this::unitGarrison);
        this.functions.put("^unit setup$", this::unitSetup);
        this.functions.put("^unit attack$", this::unitAttack);
        this.functions.put("^unit found$", this::unitFound);
        this.functions.put("^unit cancel$", this::unitCancel);
        this.functions.put("^unit wake$", this::unitWake);
        this.functions.put("^unit delete$", this::unitDelete);
        this.functions.put("^unit build road$", this::unitBuildRoad);
        this.functions.put("^unit build railroad$", this::unitBuildRailroad);
        this.functions.put("^unit build farm$", this::unitBuildFarm);
        this.functions.put("^unit build mine$", this::unitBuildMine);
        this.functions.put("^unit build trading post$", this::unitBuildTradingPost);
        this.functions.put("^unit build lumber mill$", this::unitBuildLumberMill);
        this.functions.put("^unit build pasture$", this::unitBuildPasture);
        this.functions.put("^unit build camp$", this::unitBuildCamp);
        this.functions.put("^unit build plantation$", this::unitBuildPlantation);
        this.functions.put("^unit build quarry$", this::unitBuildQuarry);
        this.functions.put("^unit remove jungle$", this::removeJungle);
        this.functions.put("^unit remove route$", this::removeRoute);
        this.functions.put("^unit repair$", this::unitRepair);
        this.functions.put("^map show X: (?<xPosition>[-]?\\d+) Y: (?<yPosition>[-]?\\d+)$", this::mapShowPosition);
        this.functions.put("^map show (?<cityName>.+)$", this::mapShowName);
        this.functions.put("^map move right (?<NumberOfMoves>\\d+)$", this::moveRight);
        this.functions.put("^map move left (?<NumberOfMoves>\\d+)$", this::moveLeft);
        this.functions.put("^map move up (?<NumberOfMoves>\\d+)$", this::moveUp);
        this.functions.put("^map move down (?<NumberOfMoves>\\d+)$", this::moveDown);
    }

    public void run() {
        getCommand(functions);
    }

    @Override
    protected void gotoMenu() {
        String nextMenuName = matcher.group("menuName");
        if (nextMenuName.equals("main menu"))
            loopFlag = false;
        else
            System.out.println("menu navigation is not possible");
    }

    private void infoResearch() {
    }

    private void infoUnits() {
    }

    private void infoCities() {
    }

    private void infoDiplomacy() {
    }

    private void infoVictory() {
    }

    private void infoDemographics() {
    }

    private void infoNotifications() {
    }

    private void infoMilitary() {
    }

    private void infoEconomic() {
    }

    private void infoDiplomatic() {
    }

    private void infoDeals() {
    }

    private void selectUnitCombat() {
    }

    private void selectUnitNoncombat() {
    }

    private void selectCityName() {
    }

    private void selectCityPosition() {
    }

    private void unitMove() {
    }

    private void unitSleep() {
    }

    private void unitAlert() {
    }

    private void unitFortify() {
    }

    private void unitFortifyHeal() {
    }

    private void unitGarrison() {
    }

    private void unitSetup() {
    }

    private void unitAttack() {
    }

    private void unitFound() {
    }

    private void unitCancel() {
    }

    private void unitWake() {
    }

    private void unitDelete() {
    }

    private void unitBuildRoad() {
    }

    private void unitBuildRailroad() {
    }

    private void unitBuildFarm() {
    }

    private void unitBuildMine() {
    }

    private void unitBuildTradingPost() {
    }

    private void unitBuildLumberMill() {
    }

    private void unitBuildPasture() {
    }

    private void unitBuildCamp() {
    }

    private void unitBuildPlantation() {
    }

    private void unitBuildQuarry() {
    }

    private void removeJungle() {
    }

    private void removeRoute() {
    }

    private void unitRepair() {
    }

    private void mapShowPosition() {
    }

    private void mapShowName() {
    }

    private void moveRight() {
    }

    private void moveLeft() {
    }

    private void moveUp() {
    }

    private void moveDown() {
    }
}
