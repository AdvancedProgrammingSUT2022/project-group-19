//بسم الله الرحمن الرحیم

import controller.Controller;
import model.Color;
import model.Database;
import view.LoginMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n" +
                "\n" +
                "                                                                                                    \n" +
                "              ,,               ,,    ,,    ,,                             ,,                        \n" +
                "  .g8\"\"\"bgd   db               db  `7MM    db                     mm      db                        \n" +
                ".dP'     `M                          MM                           MM                                \n" +
                "dM'       ` `7MM  `7M'   `MF'`7MM    MM  `7MM  M\"\"\"MMV  ,6\"Yb.  mmMMmm  `7MM   ,pW\"Wq.  `7MMpMMMb.  \n" +
                "MM            MM    VA   ,V    MM    MM    MM  '  AMV  8)   MM    MM      MM  6W'   `Wb   MM    MM  \n" +
                "MM.           MM     VA ,V     MM    MM    MM    AMV    ,pm9MM    MM      MM  8M     M8   MM    MM  \n" +
                "`Mb.     ,'   MM      VVV      MM    MM    MM   AMV  , 8M   MM    MM      MM  YA.   ,A9   MM    MM  \n" +
                "  `\"bmmmd'  .JMML.     W     .JMML..JMML..JMML.AMMmmmM `Moo9^Yo.  `Mbmo .JMML. `Ybmd9'  .JMML  JMML.\n" +
                "                                                                                                    \n" +
                "                                                                                                    \n" +
                "\n");

        //get the information from file in the beginning:
        Database.readSavedUsers();

//        //enter the menu:
//        LoginMenu loginMenu = new LoginMenu();
//        loginMenu.run();

        //FOR TEST ONLY
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.autoLogin();
    }
}