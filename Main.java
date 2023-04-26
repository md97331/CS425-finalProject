import classes_SQL.*;
import func_Helpers.*;
//import GUI.*;

import java.io.IOException;
import java.sql.*;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        User currUser;
        int userStatus = 0;

        do {
            currUser = Menu.initMenu();
            userStatus = currUser.getAdmin();
        } while (userStatus==-1 || userStatus==9);

        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {

            int selectedOptionFromFirstMenu = Menu.displayMenu(currUser);
            if(userStatus == 1){
                int selectedOptionFromSubMenu = Menu.displaySubMenu(selectedOptionFromFirstMenu);
                Menu.runQueryBySelectedOptions(userStatus, selectedOptionFromFirstMenu, selectedOptionFromSubMenu);
            }else if(userStatus == 2){
                Menu.runQueryBySelectedOptions(userStatus, selectedOptionFromFirstMenu, 0);
            }
            System.out.print("\nDo you wanna make any other request? (y/n): ");

            String input = "";
            input = scanner.nextLine();
            input = input.toUpperCase();


            if (input.equals("Y")) {
                flag = true;
            } else if (input.equals("N")) {
                flag = false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
            System.out.println("Bye!");
        }



    }

}