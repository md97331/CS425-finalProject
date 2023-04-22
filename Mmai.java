package cs.mysqlproject.menu;

import java.sql.*;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;



public class Mmai {

    static void displayAdminSubMenu(Map<Integer, String> AdminMenuTitle, user userAccount, Statement stmt) {
        Map<Integer, String> AdminSubMenuTitle = new menu().initAdminSubMenu();
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
                System.out.println("This is not a valid number.Please try again");
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
    static void displayAdminMenu(user userAccount,Statement stmt) {
        Map<Integer, String> AdminMenuTitle = new menu().initAdminMenu();
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
    static void displayUserMenu(user userAccount) {
        Map<Integer, String> UserMenuTitle = new menu().initUserMenu();
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

    static boolean MapUserTable(user userAccount, Statement stmt) {
        try {
            ResultSet getAdmin=stmt.executeQuery("select admin from user where userid = '" + userAccount.getId()
                    +"' and password = '" +  userAccount.getPassword() + "'");
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
    static void login(user userAccount, Statement stmt) {
        System.out.println("Please sign in!!");
        Scanner sc = new Scanner(System.in);
        while(userAccount.getId() == null || MapUserTable(userAccount, stmt)) {//break after map to user table
            System.out.println("type in your username : ");
            userAccount.setId(sc.nextLine());
            System.out.println("type in your password : ");
            userAccount.setPassword(sc.nextLine());

            if (userAccount.getId().contains("\"") || userAccount.getId().contains("\'")) {
                System.out.println("username contains quotation marks, please try again");
                userAccount.setId(null);
            }
            else if (userAccount.getPassword().contains("\"") || userAccount.getPassword().contains("\'")) {
                System.out.println("password contains quotation marks, please try again");
                userAccount.setPassword(null);
            }
        }
    }

    public static void main(String[] args) {
        //connect to database
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root","Jerry89232382");
            Statement stmt=con.createStatement();
            user userAccount = new user(null, null, null, 0, 0);
            login(userAccount,stmt);


            if (userAccount.getAdmin().contains("A")) {
                displayAdminMenu(userAccount, stmt);
            }
            else if(userAccount.getAdmin().contains("U")) {
                displayUserMenu(userAccount);
            }
            else{
                System.out.println("Admin error: " + userAccount.getAdmin() + ", please restart the app");
                exit(0);
            }
            //System.out.println(" main:" +userAccount.getMenuOption() + " sub:" + userAccount.getSubMenuOption());


        }catch(Exception e){ System.out.println(e);
        }


    }
}

