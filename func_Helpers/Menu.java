package func_Helpers;

import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;
import classes_SQL.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.exit;

public class Menu {

    public static User initMenu() {
        System.out.println("================== SKY LINK AIRLINES ==================");
        Scanner sc = new Scanner(System.in);

        String username, password;
        do {
            System.out.print("-Username:");
            username = sc.nextLine();
            System.out.print("-Lastname: ");
            password = sc.nextLine();

            if (username.contains("\"") || username.contains("\'")) {
                System.out.println("Username/Password contains forbidden characters. Please try again!");
                username = "";
            }
            else if (password.contains("\"") || password.contains("\'")) {
                System.out.println("Username/Password contains forbidden characters. Please try again!");
                password = "";
            }
        } while(username.equals("") || password.equals(""));

        return chkAccount(username, password);
    }

    static User chkAccount(String username,String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root","First5210");
            PreparedStatement pstmt=con.prepareStatement("select * from Admin where userid = ? and password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                User returnedUser = new User(username, password, 1);
                System.out.println("========== WELCOME " + username + " ===========");
                rs.close();
                pstmt.close();
                con.close();
                return returnedUser;
            }
            else{
                rs.close();
                pstmt.close();
                pstmt=con.prepareStatement("select * from passenger where PsgID = ? and pwd = ?");
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                rs = pstmt.executeQuery();
                if(rs.next()) {
                    User returnedUser = new User(username, password, 2);
                    System.out.println("========== WELCOME " + rs.getString("firstName") + " " + rs.getString("lastName") + " ===========");
                    rs.close();
                    pstmt.close();
                    con.close();
                    return returnedUser;
                }
                else {
                    User returnedUser = new User(username, password, -1);
                    System.out.println("Username/password are incorrect. Please try again!");
                    rs.close();
                    pstmt.close();
                    con.close();
                    return returnedUser;
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
        User returnedUser = new User(username, password, -1);
    return returnedUser;
    }

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
        map.put(2, "Edit");
        map.put(3, "Add");
        map.put(4, "Delete");
        map.put(5, "Quit");
        return map;
    }

    public Map<Integer, String> initSql() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Select * from ");//CONDITION ONLY
        map.put(2, "Update set");//CONDITION & VALUE
        map.put(3, "Inset into");//VALUE ONLY
        map.put(4, "Delete from");//CONDITION ONLY
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

    public static void displayMenu(User userAccount) {
        System.out.println("\n----------- Menu----------");
        if(userAccount.getAdmin() == 1){// admin
            Map<Integer, String> adminMenuTitle = new Menu().initAdminMenu();
            for(int i = 1; i<= adminMenuTitle.size(); i++)
                System.out.println("(" + i + ") " + adminMenuTitle.get(i));
        }else if (userAccount.getAdmin() == 2) { //user
            Map<Integer, String> userMenuTitle = new Menu().initUserMenu();
            for(int i = 1; i<= userMenuTitle.size(); i++)
                System.out.println("(" + i + ") " + userMenuTitle.get(i));
        }else{
            System.out.println("illegal status");
            exit(0);
        }

    }
}
