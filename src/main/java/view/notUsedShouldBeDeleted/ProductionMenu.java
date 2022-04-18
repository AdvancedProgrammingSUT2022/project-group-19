package view.notUsedShouldBeDeleted;

import model.civilizations.City;

import java.util.Scanner;

public class ProductionMenu extends Menu {
    City city;

    public ProductionMenu(City city) {
        this.city = city;
    }

    public void run(Scanner scanner) {
        while (true) {
            command = scanner.nextLine();

        }
    }
}
