package controller;

import model.Database;
import model.Player;
import model.SelectedType;
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
                Controller.printMap();
                while (aUnitNeedsOrder(player)) {
                    //select a tile:
                    System.out.println("Please select a Tile");
                    Tile selectedTile = gameMenu.run(null, null);
                    if (selectedTile == null)
                        continue;

                    //select a unit or a city in selected tile:
                    selectedType = gameMenu.selectUnitOrCity(selectedTile);
                    if (selectedType == null)
                        continue;
                    boolean notAssigned = true;
                    while (notAssigned) {
                        gameMenu.run(selectedTile, selectedType);
                        switch (selectedType) {
                            case CIVILIAN_UNIT:
                                notAssigned = !selectedTile.getCivilianUnit().isAssigned();
                                break;
                            case MILITARY_UNIT:
                                notAssigned = !selectedTile.getMilitaryUnit().isAssigned();
                                break;
                            case CITY:
                                notAssigned = !selectedTile.getCity().isAssigned();
                                break;
                        }
                    }
                    Controller.printMap();
                }
                //At the end of each turn all units must unAssigned:
                unAssignAllUnits(player);
                selectedType = null;
            }
        }
    }

    private boolean aUnitNeedsOrder(Player player) {
        for (Unit unit : player.getCivilization().getUnits())
            if (!unit.isAssigned())
                return true;
        return false;
    }

    private void unAssignAllUnits(Player player) {
        for (Unit unit : player.getCivilization().getUnits())
            unit.setAssigned(false);
        for (City city : player.getCivilization().getCities())
            city.setAssigned(false);
    }
}
