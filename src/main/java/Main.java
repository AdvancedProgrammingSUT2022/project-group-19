//بسم الله الرحمن الرحیم
import controller.Controller;
import model.Database;
import view.LoginMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                "Hello Sky Stars! This is an empty project.\n" +
                "please configure your java version to 13\n" +
                "good luck :)");
        Controller.printMap();
        //create a new database
        Database database = new Database();
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.run();
    }
}