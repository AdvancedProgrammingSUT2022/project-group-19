package view;

import controller.Controller;
import model.Database;
import model.Function;
import model.Player;
import model.SelectedType;
import model.land.Tile;

import java.util.HashMap;

public class GameMenu extends Menu {
    private final HashMap<String, Function> functions = new HashMap<>();
    private Tile selectedTile = null;
    private SelectedType selected = null;

    public GameMenu(Player player) {

        System.out.println("Turn: " + player.getUser().getNickname());
        System.out.println("select a tile first. for additional help information enter: 'help'");

        this.functions.putAll(basicFunctions);
        this.functions.put("^help$", this::help);
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
//        this.functions.put("^select unit combat X: (?<xPosition>[-]?\\d+) Y: (?<yPosition>[-]?\\d+)$", this::selectUnitCombat);
//        this.functions.put("^select unit noncombat X: (?<xPosition>[-]?\\d+) Y: (?<yPosition>[-]?\\d+)$", this::selectUnitNoncombat);
//        this.functions.put("^select city (?<cityName>.+)$", this::selectCityName);
//        this.functions.put("^select city X: (?<xPosition>[-]?\\d+) Y: (?<yPosition>[-]?\\d+)$", this::selectCityPosition);
        this.functions.put("^select tile X: (?<xPosition>[-]?\\d+) Y: (?<yPosition>[-]?\\d+)$", this::selectTile);
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

    private void help() {
        System.out.println("=======================HELP======================");
        System.out.println("Select a tile by it's coordination's. then select units or cities.");
        System.out.println("You can enter these commands:");
        System.out.println("=======================HELP======================");
        for (String string : functions.keySet()) {
            StringBuilder stringBuilder = new StringBuilder(string);
            stringBuilder.deleteCharAt(0);  //remove '^'
            stringBuilder.deleteCharAt(stringBuilder.length() - 1); //remove '$'
            System.out.println(stringBuilder);
        }
    }

    public Tile run(Tile selectedTile, SelectedType selectedType) {
        this.selectedTile = selectedTile;
        this.selected = selectedType;
        getCommandOnce(functions);
        return selectedTile;
    }

    @Override
    protected void gotoMenu() {
        String nextMenuName = matcher.group("menuName");
        if (nextMenuName.equals("main menu"))
            loopFlag = false;
        else
            System.out.println("menu navigation is not possible");
    }

    private void selectTile() {
        int x = Integer.parseInt(matcher.group("xPosition"));
        int y = Integer.parseInt(matcher.group("yPosition"));
        if (Controller.isInvalidCoordinate(x, y)) { //invalid entered positions
            System.out.println("Invalid position. Please enter a valid X and Y");
            return;
        }
        selectedTile = Database.map[x][y];
        System.out.println("Tile selected successfully.");
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

//    private void selectUnitCombat() {
//        int x = Integer.parseInt(matcher.group("xPosition"));
//        int y = Integer.parseInt(matcher.group("yPosition"));
//        if (Controller.isInvalidCoordinate(x, y)) { //invalid entered positions
//            System.out.println("Invalid position");
//            return;
//        }
//        Unit unit = Database.map[x - 1][y - 1].getMilitaryUnit();
//        if (unit == null) {
//            System.out.println("No military unit there are in this tile.");
//            return;
//        }
//        selectedUnit = unit;
//        System.out.println("Unit selected successfully.");
//    }
//
//    private void selectUnitNoncombat() {
//        int x = Integer.parseInt(matcher.group("xPosition"));
//        int y = Integer.parseInt(matcher.group("yPosition"));
//        if (Controller.isInvalidCoordinate(x, y)) { //invalid entered positions
//            System.out.println("Invalid position");
//            return;
//        }
//        Unit unit = Database.map[x - 1][y - 1].getCivilianUnit();
//        if (unit == null) {
//            System.out.println("No civilian unit there are in this tile.");
//            return;
//        }
//        selectedUnit = unit;
//        System.out.println("Unit selected successfully.");
//    }
//
//    private void selectCityName() {
//        String cityName = matcher.group("cityName");
//        City cityInMap = null;
//        for (Player player : Database.getPlayers())
//            for (City city : player.getCivilization().getCities())
//                if (city.getName().equals(cityName)) {
//                    cityInMap = city;
//                    break;
//                }
//        if (cityInMap == null)
//            System.out.println("There is not any city named " + cityName + " in the map.");
//        else {
//            selectedCity = cityInMap;
//        }
//    }

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

    public SelectedType selectUnitOrCity(Tile tile) {
        HashMap<SelectedType, String> selectableMap = new HashMap<>();
        boolean haveCity = false;
        boolean haveUnit = false;
        if (tile.getCity() != null)
            selectableMap.put(SelectedType.CITY, "Select City " + tile.getCity().getName());
        if (tile.getMilitaryUnit() != null)
            selectableMap.put(SelectedType.MILITARY_UNIT, "Select Military Unit " + tile.getMilitaryUnit().getType());
        if (tile.getCivilianUnit() != null)
            selectableMap.put(SelectedType.CIVILIAN_UNIT, "Select Civilian Unit " + tile.getCivilianUnit().getType());

        if (selectableMap.size() == 0) {
            System.out.println("There is not any selectable unit in this tile.");
            return null;
        } else if (selectableMap.size() == 1) {
            SelectedType selectedType = (SelectedType) selectableMap.keySet().toArray()[0];
            System.out.println("The " + selectedType.getName() + " is selected.");
            return selectedType;
        } else {
            System.out.println("Which one do you want to select? Please enter it's number:");
            int index = 1;
            for (String string : selectableMap.values()) {
                System.out.println(index + "- " + string);
                index++;
            }
            index--;
            while (true) {
                int choose;
                try {
                    choose = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    continue;
                }
                if (choose < 1 || choose > index) {
                    System.out.println("Please enter a valid number. your number is out of range.");
                    continue;
                }
                SelectedType selectedType = (SelectedType) selectableMap.keySet().toArray()[choose - 1];
                System.out.println("You have selected the " + selectedType.getName() + ".");
                return selectedType;
            }
        }
    }
}


