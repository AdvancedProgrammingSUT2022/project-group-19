package controller;

import model.*;
import model.civilizations.City;
import model.land.Tile;
import model.unit.Unit;
import model.unit.UnitType;
import view.GameMenu;

import java.io.*;
import java.util.Arrays;

public class GameController {
    SelectedType selectedType = null;

    public void gameLoop() {
        while (true) {
            for (Player player : Database.getPlayers()) {
                GameMenu gameMenu = new GameMenu(player);
                boolean loopFlag = true;
                while (loopFlag) {
                    updateFogOfWar(player);
                    saveGame();
                    if (!(gameMenu.getMessage().equals(Message.invalidCommand) || gameMenu.getMessage().equals(Message.NULL)))
                        Controller.printMap(player);
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

                    if (gameMenu.getSelectedType() == null) {
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
    }

    /*
      update the visibility of the map each turn
      the fogOfWar field may be:
      0 = hidden    /   1 = not hidden   /   2 = visible
     */
    private void updateFogOfWar(Player player) {

        //fog of war - Units:
        for (Unit unit : player.getCivilization().getUnits()) {
            int x = unit.getTile().getPositionI();
            int y = unit.getTile().getPositionJ();

            for (int i = 0; i < Database.numOfRows; i++)
                for (int j = 0; j < Database.numOfCols; j++)
                    if (player.fogOfWar[i][j] == 2)
                        player.fogOfWar[i][j] = 1;

            for (int i = x - 2; i <= x + 1; i++) {
                for (int j = y - 2; j <= y + 2; j++) {
                    if (i == x - 2 && (j == y - 2 || j == y + 2))
                        continue;
                    try {
                        player.fogOfWar[i][j] = 2;
                    } catch (Exception ignored) {
                    }
                }
            }
            try {
                player.fogOfWar[x + 2][y] = 2;
            } catch (Exception ignored) {
            }
        }


        //fog of war - cities:
        for (int i = 0; i < Database.numOfRows; i++) {
            for (int j = 0; j < Database.numOfCols; j++) {
                Tile tile = Database.map[i][j];
                if (tile.getCity() != null && tile.getCity().getCivilization().equals(player.getCivilization())) {
                    player.fogOfWar[i][j] = 2;
                    for (Tile neighbor : tile.getNeighborOnBounds()) {
                        if (neighbor != null) {
                            int x = neighbor.getPositionI();
                            int y = neighbor.getPositionJ();
                            player.fogOfWar[x][y] = 2;
                        }
                    }
                }
            }
        }
    }

    //Save the entire game data to a file. You can resume the game from Main menu by entering 'load game'.
    private void saveGame() {
        try {
            FileOutputStream fileStream = new FileOutputStream(Database.getSaveGamePath());
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

            objectStream.writeObject(Database.getPlayers());
            objectStream.writeObject(Database.gameMap);
            objectStream.writeObject(Database.map);

            objectStream.close();
            fileStream.close();

        } catch (Exception e) {
            System.out.println("An Error occurred during auto saving the game : ");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
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
            if (unit.getWay() == null || unit.getWay().size() == 0) continue;
            unit.move();
        }
    }
}
