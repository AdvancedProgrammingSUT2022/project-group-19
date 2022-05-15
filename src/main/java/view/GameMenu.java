package view;

import controller.Controller;
import model.*;
import model.land.Tile;
import model.unit.Unit;
import model.unit.UnitType;
import model.unit.Worker;

import java.util.HashMap;

public class GameMenu extends Menu {
    private final HashMap<String, Function> functions = new HashMap<>();
    private Tile selectedTile = null;
    private SelectedType selectedType = null;
    private Message message = Message.OK;
    private final Player player;

    public GameMenu(Player player) {
        this.player = player;
        String color = (player.getCivilization().equals(Database.getPlayers().get(0).getCivilization())) ? Color.BLUE : Color.RED;
        System.out.println(color + "Turn: " + player.getUser().getNickname() + Color.RESET);
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

        this.functions.put("^select tile (?<xPosition>[-]?\\d+) (?<yPosition>[-]?\\d+)$", this::selectTile);
        this.functions.put("^unselect$", () -> message = Message.OK);
        this.functions.put("^unit move to (?<xPosition>[-]?\\d+) (?<yPosition>[-]?\\d+)$", this::unitMove);

        this.functions.put("^unit sleep$", this::unitSleep);
        this.functions.put("^unit wake$", this::unitWake);
        this.functions.put("^unit alert$", this::unitAlert);
        this.functions.put("^unit fortify$", this::unitFortify);
        this.functions.put("^unit fortify heal$", this::unitFortifyHeal);
        this.functions.put("^unit garrison$", this::unitGarrison);
        this.functions.put("^unit setup$", this::unitSetup);
        this.functions.put("^unit attack$", this::unitAttack);
        this.functions.put("^unit found$", this::unitFound);
        this.functions.put("^unit cancel$", this::unitCancel);
        this.functions.put("^unit delete$", this::unitDelete);
        this.functions.put("^unit build road$", this::unitBuildRoad);
        this.functions.put("^unit build railroad$", this::unitBuildRailroad);
        this.functions.put("^unit remove route$", this::unitRemoveRoute);

        this.functions.put("^next turn$", this::nextTurn);
        this.functions.put("^next turn --force$", () -> message = Message.NEXT_TURN);

        this.functions.put("^unit build (?<improvement>farm|mine|trading post|lumber mill|pasture|camp|plantation|quarry)$", this::unitBuildImprovement);

        this.functions.put("^unit remove feature$", this::removeFeature);
        this.functions.put("^unit repair$", this::unitRepair);

        this.functions.put("^map show (?<xPosition>[-]?\\d+) (?<yPosition>[-]?\\d+)$", this::mapShowPosition);
        this.functions.put("^map show (?<cityName>.+)$", this::mapShowName);
        this.functions.put("^map move right (?<NumberOfMoves>\\d+)$", this::moveRight);
        this.functions.put("^map move left (?<NumberOfMoves>\\d+)$", this::moveLeft);
        this.functions.put("^map move up (?<NumberOfMoves>\\d+)$", this::moveUp);
        this.functions.put("^map move down (?<NumberOfMoves>\\d+)$", this::moveDown);
    }


    private void nextTurn() {
        if (Controller.aUnitNeedsOrder(player)) {
            System.out.println("Your units needs order.");
            System.out.println("for additional information enter: 'info units'");
            System.out.println("for ignore all units enter: 'next turn --force'");
            message = Message.invalidCommand;
        } else
            message = Message.NEXT_TURN;
    }

    private void unitRemoveRoute() {
        if (notSelectedTile())
            return;
        Worker worker = (Worker) selectedTile.getCivilianUnit();
        if (worker == null || !worker.getType().equals(UnitType.WORKER))
            System.out.println("No worker in this tile");
        else {
            worker.destroyRoad();
            System.out.println("Route removed successfully");
        }
    }

    private void unitBuildImprovement() {
        if (notSelectedTile())
            return;
        message = Message.NULL;
        String improvement = matcher.group("improvement");
        Worker worker = (Worker) selectedTile.getCivilianUnit();
        if (worker == null || !worker.getType().equals(UnitType.WORKER))
            System.out.println("No worker in this tile");
        else {
            switch (improvement) {
                case "farm":
                    message = worker.buildImprovement(Improvement.FARM);
                    break;
                case "mine":
                    message = worker.buildImprovement(Improvement.MINE);
                    break;
                case "trading post":
                    message = worker.buildImprovement(Improvement.TRADING_POST);
                    break;
                case "lumber mill":
                    message = worker.buildImprovement(Improvement.LUMBER_MILL);
                    break;
                case "pasture":
                    message = worker.buildImprovement(Improvement.PASTURE);
                    break;
                case "camp":
                    message = worker.buildImprovement(Improvement.CAMP);
                    break;
                case "plantation":
                    message = worker.buildImprovement(Improvement.FARMING);
                    break;
                case "quarry":
                    message = worker.buildImprovement(Improvement.STONE_MINE);
                    break;
            }
        }
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

    public Message runWithMessage() {
        getCommandOnce(functions);
        return message;
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
        int index = 1;
        for (Unit unit : player.getCivilization().getUnits()) {
            System.out.println("Unit No. " + index);
            System.out.println("type:              " + unit.getType());
            System.out.println("Position:          " + unit.getTile().getPositionI() + " " + unit.getTile().getPositionJ());
            System.out.println("Power/rangedPower: " + unit.getPower() + " / " + unit.getRangedPower());
            System.out.println("Work counter:      " + unit.getWorkCounter());
            System.out.println("Is sleep:          " + unit.isSleep());
            System.out.println("Remained MP:       " + unit.getRemainMP());
            System.out.println("=============================");
            index++;
        }
        index--;
        System.out.println("\nYou can select a unit here by entering it's number or enter 'exit'");
        while (true) {
            String input = "";
            int number;
            try {
                input = scanner.nextLine();
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                if (input.equals("exit"))
                    break;
                System.out.println("Please enter a number.");
                continue;
            }
            if (number < 1 || number > index) {
                System.out.println("Please enter a valid number.");
                continue;
            }
            Unit unit = player.getCivilization().getUnits().get(number - 1);
            selectedTile = unit.getTile();
            selectedType = unit.isMilitary() ? SelectedType.MILITARY_UNIT : SelectedType.CIVILIAN_UNIT;
            break;
        }
        message = Message.NULL;
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

    private void unitMove() {
        if (notSelectedTile())
            return;
        int x = Integer.parseInt(matcher.group("xPosition"));
        int y = Integer.parseInt(matcher.group("yPosition"));
        if (Controller.isInvalidCoordinate(x, y))
            System.out.println("Please enter a valid coordinate.");
        else {
            message = Message.NULL;
            switch (selectedType) {
                case CITY:
                    System.out.println("You can not move a city.");
                    message = Message.OK;
                    break;
                case CIVILIAN_UNIT:
                    message = selectedTile.getCivilianUnit().moveOrder(x, y);
                    break;
                case MILITARY_UNIT:
                    message = selectedTile.getMilitaryUnit().moveOrder(x, y);
                    break;
            }
            System.out.println(message.getErrorMessage());
        }
    }

    private void unitSleep() {
        if (notSelectedTile())
            return;
        switch (selectedType) {
            case CITY:
                System.out.println("You can not sleep a city.");
                break;
            case CIVILIAN_UNIT:
                selectedTile.getCivilianUnit().setSleep(true);
                break;
            case MILITARY_UNIT:
                selectedTile.getMilitaryUnit().setSleep(true);
                break;
        }
        message = Message.OK;
    }

    private void unitWake() {
        if (notSelectedTile())
            return;
        switch (selectedType) {
            case CITY:
                System.out.println("You can not wake a city.");
                break;
            case CIVILIAN_UNIT:
                selectedTile.getCivilianUnit().setSleep(false);
                break;
            case MILITARY_UNIT:
                selectedTile.getMilitaryUnit().setSleep(false);
                break;
        }
        message = Message.OK;
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

    private void unitDelete() {
        if (notSelectedTile())
            return;
        switch (selectedType) {
            case CITY:
                System.out.println("You can not delete a city");
                break;
            case CIVILIAN_UNIT:
                player.getCivilization().addGold(selectedTile.getCivilianUnit().getCost() / 10);
                player.getCivilization().deleteUnit(selectedTile.getCivilianUnit());
                selectedTile.setCivilianUnit(null);
                break;
            case MILITARY_UNIT:
                player.getCivilization().addGold(selectedTile.getMilitaryUnit().getCost() / 10);
                player.getCivilization().deleteUnit(selectedTile.getMilitaryUnit());
                selectedTile.setMilitaryUnit(null);
                break;
        }
        message = Message.OK;
        System.out.println("unit deleted successfully.");
    }

    private void unitBuildRoad() {
    }

    private void unitBuildRailroad() {
    }


    //    private void unitBuildFarm() {
//    }
//
//    private void unitBuildMine() {
//    }
//
//    private void unitBuildTradingPost() {
//    }
//
//    private void unitBuildLumberMill() {
//    }
//
//    private void unitBuildPasture() {
//    }
//
//    private void unitBuildCamp() {
//    }
//
//    private void unitBuildPlantation() {
//    }
//
//    private void unitBuildQuarry() {
//    }
    private Worker getWorker() {
        Unit unit = selectedTile.getCivilianUnit();
        if (unit == null) {
            System.out.println("there is no unit in this tile.");
            return null;
        }
        Worker worker = new Worker(unit);
        if (!worker.getType().equals(UnitType.WORKER)) {
            System.out.println("there is no worker unit in this tile.");
            return null;
        }
        return worker;
    }

    private void removeFeature() {
        Worker worker = getWorker();
        if (worker == null)
            return;
        message = worker.destroyFeature();
        System.out.println(message);
    }

    private void unitRepair() {
        if (notSelectedTile())
            return;
        Worker worker = (Worker) selectedTile.getCivilianUnit();
        if (worker == null || !worker.getType().equals(UnitType.WORKER))
            System.out.println("No worker in this tile");
        else
            message = worker.repair();
        System.out.println(message.getErrorMessage());
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

    public Message selectUnitOrCity() {
        HashMap<SelectedType, String> selectableMap = new HashMap<>();
        boolean haveCity = false;
        boolean haveUnit = false;
        if (GameMenu.this.selectedTile.isCityCenter() && player.getCivilization().getCities().contains(GameMenu.this.selectedTile.getCity()))
            selectableMap.put(SelectedType.CITY, "Select City '" + GameMenu.this.selectedTile.getCity().getName() + "'");
        if (GameMenu.this.selectedTile.getMilitaryUnit() != null && player.getCivilization().getUnits().contains(GameMenu.this.selectedTile.getMilitaryUnit()))
            selectableMap.put(SelectedType.MILITARY_UNIT, "Select Military Unit " + GameMenu.this.selectedTile.getMilitaryUnit().getType());
        if (GameMenu.this.selectedTile.getCivilianUnit() != null && player.getCivilization().getUnits().contains(GameMenu.this.selectedTile.getCivilianUnit()))
            selectableMap.put(SelectedType.CIVILIAN_UNIT, "Select Civilian Unit " + GameMenu.this.selectedTile.getCivilianUnit().getType());

        if (selectableMap.size() == 0) {
            System.out.println("There is not any selectable unit in this tile.");
            return Message.noUnit;
        } else if (selectableMap.size() == 1) {
            selectedType = (SelectedType) selectableMap.keySet().toArray()[0];
            System.out.println("The " + selectedType.getName() + " is selected.");
            //debug
            if (!selectedType.equals(SelectedType.CITY)) {
                Unit unit;
                if (selectedType.equals(SelectedType.CIVILIAN_UNIT))
                    unit = selectedTile.getCivilianUnit();
                else
                    unit = selectedTile.getMilitaryUnit();
                System.out.println("type:         " + unit.getType());
                System.out.println("is sleep:     " + unit.isSleep());
                System.out.println("remain MP:    " + unit.getRemainMP());
                System.out.println("work counter: " + unit.getWorkCounter());
            }
            //
            return Message.OK;
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
                    System.out.println("Please enter a number.");
                    continue;
                }
                if (choose < 1 || choose > index) {
                    System.out.println("Please enter a valid number. your number is out of range.");
                    continue;
                }
                selectedType = (SelectedType) selectableMap.keySet().toArray()[choose - 1];
                System.out.println("You have selected the " + selectedType.getName() + ".");
                switch (selectedType) {
                    case CITY:
                        break;
                    case CIVILIAN_UNIT:
                    case MILITARY_UNIT:
                        Unit unit;
                        if (selectedType.equals(SelectedType.CIVILIAN_UNIT))
                            unit = selectedTile.getCivilianUnit();
                        else
                            unit = selectedTile.getMilitaryUnit();
                        System.out.println("type:         " + unit.getType());
                        System.out.println("is sleep:     " + unit.isSleep());
                        System.out.println("remain MP:    " + unit.getRemainMP());
                        System.out.println("work counter: " + unit.getWorkCounter());
                        break;
                }
                return Message.OK;
            }
        }
    }

    private boolean notSelectedTile() {
        if (selectedTile == null) {
            message = Message.invalidCommand;
            System.out.println("You must select a tile and a city/unit first.");
            return true;
        }
        return false;
    }

    public Tile getSelectedTile() {
        return selectedTile;
    }

    public SelectedType getSelectedType() {
        return selectedType;
    }

    public void setSelectedTile(Tile selectedTile) {
        this.selectedTile = selectedTile;
    }

    public void setSelectedType(SelectedType selectedType) {
        this.selectedType = selectedType;
    }

    public Message getMessage() {
        return message;
    }
}


