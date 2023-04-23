package func_Helpers;

import java.sql.*;
import java.util.*;
import classes_SQL.*;
import static java.lang.System.exit;

public class Menu {

    public Map<Integer, String> initAdminMenu() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Passenger");
        map.put(2, "Flight");
        map.put(3, "Connection");
        map.put(4, "FlightClass");
        map.put(5, "Ticket");
        map.put(6, "Payment");
        map.put(7, "Quit");
        return map;
    }

    public Map<Integer, String> initAdminSubMenu() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "View");
        map.put(2, "Add");
        map.put(3, "Update");
        map.put(4, "Delete");
        map.put(5, "Quit");
        return map;
    }

    public Map<Integer, String> initUserMenu() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Search Flight");
        map.put(2, "Search Passenger");
        map.put(3, "Book Ticket");
        map.put(4, "Quit");
        return map;
    }

//            map.put("A11", "Add Passenger");
//        map.put("A21", "Add Flight");
//        map.put("A31", "Add Connection");
//        map.put("A41", "Add FlightClass");
//        map.put("A51", "Add Ticket");
//        map.put("A61", "Add Payment");
//        map.put("A12", "Edit Passenger");
//        map.put("A22", "Edit Flight");
//        map.put("A32", "Edit Connection");
//        map.put("A42", "Edit FlightClass");
//        map.put("A52", "Edit Ticket");
//        map.put("A62", "Edit Payment");
//        map.put("A13", "Delete Passenger");
//        map.put("A23", "Delete Flight");
//        map.put("A33", "Delete Connection");
//        map.put("A43", "Delete FlightClass");
//        map.put("A53", "Delete Ticket");
//        map.put("A63", "Delete Payment");
//        map.put("A14", "Search Passenger");
//        map.put("A24", "Search Flight");
//        map.put("A34", "Search Connection");
//        map.put("A44", "Search FlightClass");
//        map.put("A54", "Search Ticket");
//        map.put("A64", "Search Payment");
//        map.put("A15", "Quit Passenger");
//        map.put("A25", "Quit Flight");
//        map.put("A35", "Quit Connection");
//        map.put("A45", "Quit FlightClass");
//        map.put("A55", "Quit Ticket");
//        map.put("A65", "Quit Payment");
//        map.put("U1", "Search Flight");
//        map.put("U2", "Search Passenger");
//        map.put("U3", "Book Ticket");
//        map.put("U4", "Quit");


    public static void displayAdminSubMenu(Map<Integer, String> AdminMenuTitle, User userAccount, Statement stmt) {
        Map<Integer, String> AdminSubMenuTitle = new Menu().initAdminSubMenu();
        System.out.println("\n--------" + AdminMenuTitle.get(userAccount.getMenuOption()) + "---------");
        for(int i = 1; i<= AdminSubMenuTitle.size(); i++)
            System.out.println("(" + i + ") " + AdminSubMenuTitle.get(i));
        System.out.println("-----------------------");
        Scanner sc = new Scanner(System.in);
        int integerOfMenuOption = 0;
        do
        {
            try
            {
                System.out.println("Please choose an option : ");
                integerOfMenuOption = Integer.parseInt(sc.nextLine());
                if(1> integerOfMenuOption || integerOfMenuOption> AdminSubMenuTitle.size()){
                    System.out.println("Please type between 1-"+ AdminSubMenuTitle.size() + ".Please try again");
                }
            }
            catch(Exception e)
            {
                System.out.println("This is not a valid number. Please try again");
            }
        }while(1> integerOfMenuOption || integerOfMenuOption> AdminSubMenuTitle.size());
        userAccount.setSubMenuOption(integerOfMenuOption);
        if (integerOfMenuOption == AdminSubMenuTitle.size()) {
            displayAdminMenu(userAccount, stmt);
        } else{
            System.out.println("please type the condition you would like to " + AdminSubMenuTitle.get(integerOfMenuOption)
                    + " in " + AdminMenuTitle.get(userAccount.getMenuOption()));
            //get the column names of target table
            try {
                ResultSet rs = stmt.executeQuery("select * from " + AdminMenuTitle.get(userAccount.getMenuOption()));
                ResultSetMetaData rsMetaData = rs.getMetaData();
                int count = rsMetaData.getColumnCount();
                for(int i = 1; i<=count; i++) {
                    System.out.println("please type the condition '" + rsMetaData.getColumnName(i) + "':");
                    String conditionValue = sc.nextLine();

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            sc.nextLine();
        }
    }
    public static void displayAdminMenu(User userAccount, Statement stmt) {
        Map<Integer, String> AdminMenuTitle = new Menu().initAdminMenu();
        System.out.println("\n--------Admin Menu----------");
        for(int i = 1; i<= AdminMenuTitle.size(); i++)
            System.out.println("(" + i + ") " + AdminMenuTitle.get(i));
        System.out.println("----------------------------");
        Scanner sc = new Scanner(System.in);
        int integerOfMenuOption = 0;
        do
        {
            try
            {
                System.out.println("Please choose an option : ");
                integerOfMenuOption = Integer.parseInt(sc.nextLine());
                if(1> integerOfMenuOption || integerOfMenuOption> AdminMenuTitle.size()){
                    System.out.println("Please type between 1-" + AdminMenuTitle.size() + ".Please try again");
                }
            }
            catch(Exception e)
            {
                System.out.println("This is not a valid number.Please try again");
            }
        }while(1> integerOfMenuOption || integerOfMenuOption> AdminMenuTitle.size());
        if (integerOfMenuOption == AdminMenuTitle.size())
            exit(0);
        userAccount.setMenuOption(integerOfMenuOption);
        displayAdminSubMenu(AdminMenuTitle, userAccount, stmt);
    }
    public static void displayUserMenu(User userAccount) {
        Map<Integer, String> UserMenuTitle = new Menu().initUserMenu();
        System.out.println("\n----------- Menu----------");
        for(int i = 1; i<= UserMenuTitle.size(); i++)
            System.out.println("(" + i + ") " + UserMenuTitle.get(i));
        System.out.println("---------------------------");
        Scanner sc = new Scanner(System.in);
        int integerOfMenuOption = 0;
        do
        {
            try
            {
                System.out.println("Please choose an option : ");
                integerOfMenuOption = Integer.parseInt(sc.nextLine());
                if(1> integerOfMenuOption || integerOfMenuOption> UserMenuTitle.size()){
                    System.out.println("Please type between 1-" + UserMenuTitle.size() + ".Please try again");
                }
            }
            catch(Exception e)
            {
                System.out.println("This is not a valid number.Please try again");
            }
        }while(1> integerOfMenuOption || integerOfMenuOption> UserMenuTitle.size());
        if (integerOfMenuOption == UserMenuTitle.size())
            exit(0);
        userAccount.setMenuOption(integerOfMenuOption);
    }

    static boolean MapUserTable(User userAccount, Statement stmt) {
        try {
            ResultSet getAdmin=stmt.executeQuery("'select admin from user where userid = " + userAccount.getId()
                    +"' and password = " +  userAccount.getPassword() + "'");
            if (getAdmin.next()) {
                userAccount.setAdmin(getAdmin.getString(1));
                System.out.println("welcome!!");
                return false;
            } else {
                System.out.println("your account is not correct!! please try again");
                return true;
            }
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("something wrong..please restart!!");
        exit(0);
        return true;
    }
    public static void login(User userAccount, Statement stmt) {
        System.out.println("Please sign in!!");
        Scanner sc = new Scanner(System.in);
        while(userAccount.getId() == null || MapUserTable(userAccount, stmt)) {//break after map to user table
            System.out.println("type in your username : ");
            userAccount.setId(sc.nextLine());
            System.out.println("type in your password : ");
            userAccount.setPassword(sc.nextLine());

            if (userAccount.getId().contains("'") || userAccount.getId().contains("'")) {
                System.out.println("username contains quotation marks, please try again");
                userAccount.setId(null);
            }
            else if (userAccount.getPassword().contains("\"") || userAccount.getPassword().contains("'")) {
                System.out.println("password contains quotation marks, please try again");
                userAccount.setPassword(null);
            }
        }
    }


}

