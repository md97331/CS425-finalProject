package cs.mysqlproject.menu;

import java.sql.*;
import java.util.Scanner;

import static java.lang.System.exit;

public class Login {

    static void login(User userAccount) {
        System.out.println("Welcome !! Please sign in your account");
        Scanner sc = new Scanner(System.in);
        while(userAccount.getUsername() == null || chkAccount(userAccount)) {
            System.out.println("Type in your username : ");
            userAccount.setUsername(sc.nextLine());
            System.out.println("Type in your password : ");
            userAccount.setPassword(sc.nextLine());

            if (userAccount.getUsername().contains("\"") || userAccount.getUsername().contains("\'")) {
                System.out.println("username contains quotation marks, please try again");
                userAccount.setUsername(null);
            }
            else if (userAccount.getPassword().contains("\"") || userAccount.getPassword().contains("\'")) {
                System.out.println("password contains quotation marks, please try again");
                userAccount.setPassword(null);
            }
        }
    }

    static Boolean chkAccount(User userAccount) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root","Jerry89232382");
            PreparedStatement pstmt=con.prepareStatement("select * from Admin where userid = ? and password = ?");
            pstmt.setString(1, userAccount.getUsername());
            pstmt.setString(2, userAccount.getPassword());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                userAccount.setAdmin(1);
                System.out.println("Welcome admin!! ");
                rs.close();
                pstmt.close();
                con.close();
                return false;
            }
            else{
                rs.close();
                pstmt.close();
                pstmt=con.prepareStatement("select * from passenger where PsgID = ? and pwd = ?");
                pstmt.setString(1, userAccount.getUsername());
                pstmt.setString(2, userAccount.getPassword());
                rs = pstmt.executeQuery();
                if(rs.next()) {
                    userAccount.setAdmin(0);
                    System.out.println("Welcome user!! ");
                    rs.close();
                    pstmt.close();
                    con.close();
                    return false;
                }
                else {
                    userAccount.setAdmin(-1);
                    System.out.println("Sorry, we cannot find your account. Please try again!! ");
                    rs.close();
                    pstmt.close();
                    con.close();
                    return true;
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return true;

    }



}
