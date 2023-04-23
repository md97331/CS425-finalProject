package func_Helpers;

import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;
import classes_SQL.*;

public class Menu {

    public static User initMenu() {
        System.out.println("=================== SKY LINK AIRLINES ===================");
        Scanner sc = new Scanner(System.in);

        String username, password;
        do {
            System.out.print("Username: ");
            username = sc.nextLine();
            System.out.print("Password: ");
            password = sc.nextLine();

            if (username.contains("\"") || username.contains("\'")) {
                System.out.println("Attention: Username/Password contains unrecognized characters. Please try again!");
                username = "";
            }
            else if (password.contains("\"") || password.contains("\'")) {
                System.out.println("Attention: Username/Password contains unrecognized characters. Please try again!");
                password = "";
            }
        } while(username.equals("") || password.equals(""));

        return chkAccount(username, password);
    }

    static User chkAccount(String username,String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root","First5210");
            PreparedStatement pstmt=con.prepareStatement("select * from admin where userid = ? and password = ?");
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
                    System.out.println("========== WELCOME " + rs.getString("firstName") + rs.getString("lastName") + " ===========");
                    rs.close();
                    pstmt.close();
                    con.close();
                    return returnedUser;
                }
                else {
                    User returnedUser = new User(username, password, -1);
                    System.out.println("The username/password is incorrect! Please try again...");
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
