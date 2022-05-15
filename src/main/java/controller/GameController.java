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
                while (true) {
                    if (aUnitNeedsOrder(player)) {
                        Controller.printMap();
                        //select a tile:
                        System.out.println("Please select a Tile");
                        Tile selectedTile = gameMenu.run(null, null);
                        if (selectedTile == null)
                            continue;

                        //select a unit or a city in selected tile:
                        selectedType = gameMenu.selectUnitOrCity(selectedTile);
                        if (selectedType == null)
                            continue;
                    }
                    // TODO: 5/15/2022 بعد از اضافه شدن بخش تکنولوژی باید اگر تکنولوژی ای در حال مطالعه نبود آن هم سلکت شود، همچنین پروداکشن
                    else {
                        break;
                    }
                    //while (gameMenu.runWithMessage(selectedTile, selectedType) != Message.OK) {
                    //}
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

    private boolean aUnitNeedsOrder(Player player) {
        for (Unit unit : player.getCivilization().getUnits())
            if (!unit.isSleep() && (unit.getWay().size() == 0))
                return true;
        return false;
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
