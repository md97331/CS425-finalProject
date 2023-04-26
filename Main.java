import classes_SQL.*;
import func_Helpers.*;
import GUI.*;

import java.sql.*;



public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        User currUser;
        do {
            currUser = Menu.initMenu();
        } while (currUser.getAdmin()==-1 || currUser.getAdmin()==9);

        do {
            int selectedOptionFromFirstMenu = Menu.displayMenu(currUser);
            if(currUser.getAdmin() == 1){//admin
                int selectedOptionFromSubMenu = Menu.displaySubMenu(selectedOptionFromFirstMenu);
                Menu.runQueryBySelectedOptions(currUser.getAdmin(),selectedOptionFromFirstMenu, selectedOptionFromSubMenu);
            }else if(currUser.getAdmin() == 2){//user
                Menu.runQueryBySelectedOptions(currUser.getAdmin(),selectedOptionFromFirstMenu, 0);
            }
        } while (true);
//       GUI.main();



        
    }
    
}