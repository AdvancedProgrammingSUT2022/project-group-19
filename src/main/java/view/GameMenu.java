package view;


import java.util.regex.Matcher;

public class GameMenu extends MainMenu {
    private String command;

    public void menuLoop() {
        String infoResearchRegex = "";
        String infoUnitsRegex = "";
        String infoCitiesRegex = "";
        String infoDiplomacyRegex = "";
        String infoVictoryRegex = "";
        String infoDemographicsRegex = "";
        String infoNotificationRegex = "";
        String infoMilitaryRegex = "";
        String infoEconomicRegex = "";
        String infoDiplomaticRegex = "";
        String infoDealsRegex = "";
        String selectUnitCombatRegex = "";
        String selectUnitNoncombatRegex = "";
        String selectCityNameRegex = "";
        String selectCityPositionRegex = "";
        String unitMoveToRegex = "";
        String unitSleepRegex = "";
        String unitAlertRegex = "";
        String unitFortifyRegex = "";
        String unitFortifyHealRegex = "";
        String unitGarrisonRegex = "";
        String unitSetupRegex = "";
        String unitAttackRegex = "";
        String unitFoundCityRegex = "";
        String unitCancelMissionRegex = "";
        String unitWakeRegex = "";
        String unitDeleteRegex = "";
        String unitBuildRoadRegex = "";
        String unitBuildRailroadRegex = "";
        String unitBuildFarmRegex = "";
        String unitBuildMineRegex = "";
        String unitBuildTradingPosRegex = "";
        String unitBuildLumberMillRegex = "";
        String unitBuildPastureRegex = "";
        String unitBuildCampRegex = "";
        String unitBuildPlantationRegex = "";
        String unitBuildQuarryRegex = "";
        String unitRemoveJungleRegex = "";
        String unitRemoveRouteRegex = "";
        String unitRepairRegex = "";
        String MapShowRegex = "";
        String MapMoveRegex = "";
        while (true) {
            command = scanner.nextLine();
            if (getCommandMatcher(command, infoResearchRegex) != null) {
            } else if (getCommandMatcher(command, infoUnitsRegex) != null) {
            } else if (getCommandMatcher(command, infoCitiesRegex) != null) {
            } else if (getCommandMatcher(command, infoDiplomacyRegex) != null) {
            } else if (getCommandMatcher(command, infoVictoryRegex) != null) {
            } else if (getCommandMatcher(command, infoDemographicsRegex) != null) {
            } else if (getCommandMatcher(command, infoNotificationRegex) != null) {
            } else if (getCommandMatcher(command, infoMilitaryRegex) != null) {
            } else if (getCommandMatcher(command, infoEconomicRegex) != null) {
            } else if (getCommandMatcher(command, infoDiplomaticRegex) != null) {
            } else if (getCommandMatcher(command, infoDealsRegex) != null) {
            } else if (getCommandMatcher(command, selectUnitCombatRegex) != null) {
            } else if (getCommandMatcher(command, selectUnitNoncombatRegex) != null) {
            } else if (getCommandMatcher(command, selectCityNameRegex) != null) {
            } else if (getCommandMatcher(command, selectCityPositionRegex) != null) {
            } else if (getCommandMatcher(command, unitMoveToRegex) != null) {
            } else if (getCommandMatcher(command, unitSleepRegex) != null) {
            } else if (getCommandMatcher(command, unitAlertRegex) != null) {
            } else if (getCommandMatcher(command, unitFortifyRegex) != null) {
            } else if (getCommandMatcher(command, unitFortifyHealRegex) != null) {
            } else if (getCommandMatcher(command, unitGarrisonRegex) != null) {
            } else if (getCommandMatcher(command, unitSetupRegex) != null) {
            } else if (getCommandMatcher(command, unitAttackRegex) != null) {
            } else if (getCommandMatcher(command, unitFoundCityRegex) != null) {
            } else if (getCommandMatcher(command, unitCancelMissionRegex) != null) {
            } else if (getCommandMatcher(command, unitWakeRegex) != null) {
            } else if (getCommandMatcher(command, unitDeleteRegex) != null) {
            } else if (getCommandMatcher(command, unitBuildRoadRegex) != null) {
            } else if (getCommandMatcher(command, unitBuildRailroadRegex) != null) {
            } else if (getCommandMatcher(command, unitBuildFarmRegex) != null) {
            } else if (getCommandMatcher(command, unitBuildMineRegex) != null) {
            } else if (getCommandMatcher(command, unitBuildTradingPosRegex) != null) {
            } else if (getCommandMatcher(command, unitBuildLumberMillRegex) != null) {
            } else if (getCommandMatcher(command, unitBuildPastureRegex) != null) {
            } else if (getCommandMatcher(command, unitBuildCampRegex) != null) {
            } else if (getCommandMatcher(command, unitBuildPlantationRegex) != null) {
            } else if (getCommandMatcher(command, unitBuildQuarryRegex) != null) {
            } else if (getCommandMatcher(command, unitRemoveJungleRegex) != null) {
            } else if (getCommandMatcher(command, unitRemoveRouteRegex) != null) {
            } else if (getCommandMatcher(command, unitRepairRegex) != null) {
            } else if (getCommandMatcher(command, MapShowRegex) != null) {
            } else if (getCommandMatcher(command, MapMoveRegex) != null) {
            } else System.out.println("invalid command :)");
        }
    }

    @Override
    protected void gotoMenu() {
        System.out.println("menu navigation is not possible");
    }

    public Matcher getCommandMatcher(String command, String regex) {
        return null;
    }
}
