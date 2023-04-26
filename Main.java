import classes_SQL.*;
import func_Helpers.*;
//import GUI.*;

import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        boolean still = false;
        Scanner sc = new Scanner(System.in);
        do {
            User currUser;
            int userStatus = 0;
            do {
                currUser = Menu.initMenu();
                userStatus = currUser.getAdmin();
            } while (userStatus==-1 || userStatus==9);

            int selectedOptionFromFirstMenu = Menu.displayMenu(currUser);
            if(userStatus == 1){
                int selectedOptionFromSubMenu = Menu.displaySubMenu(selectedOptionFromFirstMenu);
                Menu.runQueryBySelectedOptions(userStatus, selectedOptionFromFirstMenu, selectedOptionFromSubMenu);
            }else if(userStatus == 2){
                Menu.runQueryBySelectedOptions(userStatus, selectedOptionFromFirstMenu, 0);
            }
            System.out.print("Do you wanna make any other request? (y/n): ");
            still = sc.nextBoolean();
            sc.close();
        }while (still);



    }

}