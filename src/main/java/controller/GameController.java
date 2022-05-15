package controller;

import model.*;
import model.civilizations.City;
import model.land.Tile;
import model.unit.Unit;
import model.unit.UnitType;
import view.GameMenu;

public class GameController {
    private Player turn;
    SelectedType selectedType = null;

    public void gameLoop() {
        while (true) {
            for (Player player : Database.getPlayers()) {
                GameMenu gameMenu = new GameMenu(player);
                turn = player;
                boolean loopFlag = true;
                while (loopFlag) {
                    Tile selectedTile = null;
                    if (!(gameMenu.getMessage().equals(Message.invalidCommand) || gameMenu.getMessage().equals(Message.NULL)))
                        Controller.printMap();
                    if (!Controller.aUnitNeedsOrder(player)) {
                        System.out.println("All units are assigned. Please enter: 'next turn'");
                    } else {
                        System.out.println("Please select a Tile");
                    }
                    //select a tile:
                    if (gameMenu.runWithMessage() == Message.NEXT_TURN)
                        break;
                    if (gameMenu.getSelectedTile() == null)
                        continue;

                    if (gameMenu.getSelectedType() == null){
                        //select a unit or a city in selected tile:
                        if (gameMenu.selectUnitOrCity() == Message.NEXT_TURN)
                            break;
                        if (gameMenu.getSelectedType() == null)
                            continue;
                    }

                    System.out.println("Order the selected unit/city.");
                    while (true) {
                        Message message = gameMenu.runWithMessage();
                        if (message == Message.OK)
                            break;
                        if ((message == Message.NEXT_TURN))
                            loopFlag = false;
                    }
                    gameMenu.setSelectedTile(null);
                    gameMenu.setSelectedType(null);

                }
                //حرکت یونیت ها اینجا انجام میشود
                moveAllUnits(player);
                System.out.println(Color.BLUE_BACKGROUND + Color.BLACK + "============== NEXT TURN =============" + Color.RESET);
                //At the end of each turn all units must unAssigned:
                restoreMP(player);
                selectedType = null;
            }
        }
        //TODO: save the game
    }

    private void restoreMP(Player player) {
        for (Unit unit : player.getCivilization().getUnits())
            if (!unit.getType().equals(UnitType.WORKER))    //Worker MP must not increase at each turn
                unit.resetMP();
        for (City city : player.getCivilization().getCities())
            city.cityProduction();
    }

    private void moveAllUnits(Player player) {
        for (Unit unit : player.getCivilization().getUnits()) {
            unit.move();
        }
    }
}
