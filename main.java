import classes_SQL.*;
import func_Helpers.*;

import java.sql.*;

import static java.lang.System.exit;


public class Main {
    public static void main(String[] args) {
        User currUser;
        do {
            currUser = Menu.initMenu();
        } while (currUser.getAdmin()==-1 || currUser.getAdmin()==9);

        Menu.displayUserMenu(currUser);


    }
}