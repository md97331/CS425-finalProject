import classes_SQL.*;
import func_Helpers.*;

import java.sql.*;

import static java.lang.System.exit;


public class Main {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root","First5210");
            Statement stmt=con.createStatement();
            User userAccount = new User(null, null, null, 0, 0);
            Menu.login(userAccount,stmt);


            if (userAccount.getAdmin().contains("A")) {
                Menu.displayAdminMenu(userAccount, stmt);
            }
            else if(userAccount.getAdmin().contains("U")) {
                Menu.displayUserMenu(userAccount);
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