import classes_SQL.*;
import func_Helpers.*;
//import GUI.*;

import java.sql.*;



public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        User currUser;
        int userStatus = 0;
        do {
            currUser = Menu.initMenu();
            userStatus = currUser.getAdmin();
        } while (userStatus==-1 || userStatus==9);

        int selectedOptionFromFirstMenu = Menu.displayMenu(currUser);
        if(userStatus == 1){
            int selectedOptionFromSubMenu = Menu.displaySubMenu(selectedOptionFromFirstMenu);
            Menu.runQueryBySelectedOptions(selectedOptionFromFirstMenu, selectedOptionFromSubMenu, userStatus);
        }else if(userStatus == 2){
            Menu.runQueryBySelectedOptions(selectedOptionFromFirstMenu, 0, userStatus);
        }

    }

}