package controller;

import model.*;
import model.civilizations.City;
import model.land.Tile;
import model.unit.Unit;
import view.GameMenu;

public class GameController {
    private Player turn;
    SelectedType selectedType = null;

    public void gameLoop() {
        while (true) {
            for (Player player : Database.getPlayers()) {
                GameMenu gameMenu = new GameMenu(player);
                turn = player;
                while (aUnitNeedsOrder(player)) {
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

                    while (gameMenu.runWithMessage(selectedTile, selectedType) != Message.OK) {
                    }
                }
                System.out.println(Color.BLUE_BACKGROUND + Color.WHITE + "============== NEXT TURN =============" + Color.RESET);
                //At the end of each turn all units must unAssigned:
                unAssignAllUnits(player);
                selectedType = null;
            }
        }
        //TODO: save the game
    }

    private boolean aUnitNeedsOrder(Player player) {
        for (Unit unit : player.getCivilization().getUnits())
            if (!unit.isSleep() && !unit.isAssigned())
                return true;
        return false;
    }

    private void unAssignAllUnits(Player player) {
        for (Unit unit : player.getCivilization().getUnits())
            unit.resetMP();
        for (City city : player.getCivilization().getCities())
            city.cityProduction();
    }
}
