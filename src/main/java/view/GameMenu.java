package view;

import model.Function;

import java.util.HashMap;

public class GameMenu extends MainMenu {
    private final HashMap<String, Function> functions = new HashMap<>();

    public GameMenu() {
        this.functions.putAll(basicFunctions);
        functions.put("^info research$", this::infoResearch);
        functions.put("^info units$", this::infoUnits);
        functions.put("^info cities$", this::infoCities);
        functions.put("^info diplomacy$", this::infoDiplomacy);
        functions.put("^info victory$", this::infoVictory);
        functions.put("^info demographics$", this::infoDemographics);
        functions.put("^info notifications$", this::infoNotifications);
        functions.put("^info military$", this::infoMilitary);
        functions.put("^info economic$", this::infoEconomic);
        functions.put("^info diplomatic$", this::infoDiplomatic);
        functions.put("^info deals$", this::infoDeals);
        functions.put("^select unit combat X: (?<xPosition>[-]?\\d+) Y: (?<xPosition>[-]?\\d+)$", this::selectUnitCombat);
        functions.put("^select unit noncombat X: (?<xPosition>[-]?\\d+) Y: (?<xPosition>[-]?\\d+)$", this::selectUnitNoncombat);
        functions.put("^select city (?<cityName>.+)$", this::selectCityName);
        functions.put("^select city X: (?<xPosition>[-]?\\d+) Y: (?<xPosition>[-]?\\d+)$", this::selectCityPosition);
        functions.put("^unit move to X: (?<xPosition>[-]?\\d+) Y: (?<xPosition>[-]?\\d+)$", this::unitMove);
        functions.put("^unit sleep$", this::unitSleep);
        functions.put("^unit alert$", this::unitAlert);
        functions.put("^unit fortify$", this::unitFortify);
        functions.put("^unit fortify heal$", this::unitFortifyHeal);
        functions.put("^unit garrison$", this::unitGarrison);
        functions.put("^unit setup$", this::unitSetup);
        functions.put("^unit attack$", this::unitAttack);
        functions.put("^unit found$", this::unitFound);
        functions.put("^unit cancel$", this::unitCancel);
        functions.put("^unit wake$", this::unitWake);
        functions.put("^unit delete$", this::unitDelete);
        functions.put("^unit build road$", this::unitBuildRoad);
        functions.put("^unit build railroad$", this::unitBuildRailroad);
        functions.put("^unit build farm$", this::unitBuildFarm);
        functions.put("^unit build mine$", this::unitBuildMine);
        functions.put("^unit build trading post$", this::unitBuildTradingPost);
        functions.put("^unit build lumber mill$", this::unitBuildLumberMill);
        functions.put("^unit build pasture$", this::unitBuildPasture);
        functions.put("^unit build camp$", this::unitBuildCamp);
        functions.put("^unit build plantation$", this::unitBuildPlantation);
        functions.put("^unit build quarry$", this::unitBuildQuarry);
        functions.put("^unit remove jungle$", this::removeJungle);
        functions.put("^unit remove route$", this::removeRoute);
        functions.put("^unit repair$", this::unitRepair);
        functions.put("^map show X: (?<xPosition>[-]?\\d+) Y: (?<xPosition>[-]?\\d+)$", this::mapShowPosition);
        functions.put("^map show (?<cityName>.+)$", this::mapShowName);
        functions.put("^map move right (?<NumberOfMoves>\\d+)$", this::moveRight);
        functions.put("^map move left (?<NumberOfMoves>\\d+)$", this::moveLeft);
        functions.put("^map move up (?<NumberOfMoves>\\d+)$", this::moveUp);
        functions.put("^map move down (?<NumberOfMoves>\\d+)$", this::moveDown);
    }


    public void run() {
        menuLoop(functions);
    }

    @Override
    protected void gotoMenu() {
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
