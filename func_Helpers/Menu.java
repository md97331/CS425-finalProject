package func_Helpers;

import java.sql.*;
import java.util.Scanner;
import classes_SQL.*;

import static java.lang.System.exit;

public class Menu {

    static User initMenu() {
        System.out.println("Welcome !! Please sign in your account");
        Scanner sc = new Scanner(System.in);

        String username, password;
        do {
            System.out.println("Type in your username : ");
            username = sc.nextLine();
            System.out.println("Type in your password : ");
            password = sc.nextLine();

            if (username.contains("\"") || username.contains("\'")) {
                System.out.println("username contains quotation marks, please try again");
                username = "";
            }
            else if (password.contains("\"") || password.contains("\'")) {
                System.out.println("password contains quotation marks, please try again");
                password = "";
            }
        } while(username.equals("") || password.equals(""));

        return chkAccount(username, password);
    }

    static User chkAccount(String username,String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root","Jerry89232382");
            PreparedStatement pstmt=con.prepareStatement("select * from Admin where userid = ? and password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                User returnedUser = new User(username, password, 1);
                System.out.println("Welcome admin!! ");
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
                    User returnedUser = new User(username, password, 0);
                    System.out.println("Welcome user!! ");
                    rs.close();
                    pstmt.close();
                    con.close();
                    return returnedUser;
                }
                else {
                    User returnedUser = new User(username, password, -1);
                    System.out.println("Sorry, we cannot find your account. Please try again!! ");
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
}
