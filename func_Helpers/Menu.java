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
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root","Jerry89232382");
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
        public static Map<String, Object> updateValueMapTable(String tableNameFromFirstMenu) throws SQLException, ClassNotFoundException {
            Map<String, Object> valueMapTable = new Maps().initMapTable(tableNameFromFirstMenu);
            Scanner sc = new Scanner(System.in);
            String yesNoAnswer = "n";
            for (Map.Entry<String, Object> entry : valueMapTable.entrySet()) {
                String colName = entry.getKey();
                System.out.println("Do you want to edit " + colName + "?(y/n)");
                yesNoAnswer = sc.nextLine();
                if(yesNoAnswer.contains("y")||yesNoAnswer.contains("Y")){
                    System.out.println("Please type your value:");
                    valueMapTable.put(colName,sc.nextLine());
                }
            }
            return valueMapTable;
        }
        public static Map<String, Object> updateConditionMapTable(String tableNameFromFirstMenu) throws SQLException, ClassNotFoundException {
            Map<String, Object> conditionMapTable = new Maps().initMapTable(tableNameFromFirstMenu);
            Scanner sc = new Scanner(System.in);
            String yesNoAnswer = "n";
            for (Map.Entry<String, Object> entry : conditionMapTable.entrySet()) {
                String colName = entry.getKey();
                System.out.println("Do you want to set " + colName + " as condition?(y/n)");
                yesNoAnswer = sc.nextLine();
                if(yesNoAnswer.contains("y")||yesNoAnswer.contains("Y")){
                    System.out.println("Please type your condition value:");
                    conditionMapTable.put(colName,sc.nextLine());
                }
            }
            return conditionMapTable;
        }
    
        public static void runQueryBySelectedOptions(int selectedOptionFromFirstMenu, int selectedOptionFromSubMenu) throws SQLException, ClassNotFoundException {
            Map<Integer, String> tableNamesFromFirstMenu = new Maps().initTablesFromFirstAdminMenu();
            String tableNameFromFirstMenu = tableNamesFromFirstMenu.get(selectedOptionFromFirstMenu);
            Map<String, Object> conditionMapTable;
            Map<String, Object> valueMapTable;
            boolean firstCondition = true;
            if(selectedOptionFromSubMenu == 1){//insert
                valueMapTable = updateValueMapTable(tableNameFromFirstMenu);
                //String setQuery = "insert into table1 (col1,col2,col3..) values (?,?,...)";
                StringBuilder sql = new StringBuilder("INSERT INTO  " + tableNameFromFirstMenu + " ( ");
                for (Map.Entry<String, Object> entry : valueMapTable.entrySet()) {
                    if (entry.getValue() != null) {
                        if (!firstCondition) {
                            sql.append(" , ");
                        } else {
                            firstCondition = false;
                        }
                        sql.append(entry.getKey());
                    }
                }
                sql.append(" ) VALUES ( ");
                firstCondition = true;
                for (Map.Entry<String, Object> entry : valueMapTable.entrySet()) {
                    if (entry.getValue() != null) {
                        if (!firstCondition) {
                            sql.append(" , ");
                        } else {
                            firstCondition = false;
                        }
                        sql.append("?");
                    }
                }
                sql.append(" ) ");
                //System.out.println("Generated SQL: " + sql.toString());
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root","Jerry89232382");
                PreparedStatement pstmt = con.prepareStatement(sql.toString());
                int parameterIndex = 1;
                for (Map.Entry<String, Object> entry : valueMapTable.entrySet()) {
                    if (entry.getValue() != null) {
                        pstmt.setObject(parameterIndex++, entry.getValue());
                    }
                }
                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected);
                pstmt.close();
                con.close();
            }else if(selectedOptionFromSubMenu == 2){//update
                conditionMapTable = updateConditionMapTable(tableNameFromFirstMenu);
                valueMapTable = updateValueMapTable(tableNameFromFirstMenu);
            }else if(selectedOptionFromSubMenu == 3){//delete
                conditionMapTable = updateConditionMapTable(tableNameFromFirstMenu);
            }else if(selectedOptionFromSubMenu == 4){//select
                conditionMapTable = updateConditionMapTable(tableNameFromFirstMenu);
            }
        }
    
        public static int displaySubMenu(int selectedOptionFromFirstMenu) {
            Map<Integer, String> tableNamesFromFirstMenu = new Maps().initTablesFromFirstAdminMenu();
            String tableNameFromFirstMenu = tableNamesFromFirstMenu.get(selectedOptionFromFirstMenu);
            int selectedOptionFromSubMenu = 0;
            System.out.println("\n----------- " + tableNameFromFirstMenu + "----------");
            System.out.println("1. Add " + tableNameFromFirstMenu);
            System.out.println("2. Revise " + tableNameFromFirstMenu + " data");
            System.out.println("3. Delete " + tableNameFromFirstMenu + " data");
            System.out.println("4. View " + tableNameFromFirstMenu);
            System.out.println("5. Quit");
            Scanner sc = new Scanner(System.in);
            do {
                try {
                    System.out.println("Please choose an option : ");
                    selectedOptionFromSubMenu = Integer.parseInt(sc.nextLine());
                    if (1 > selectedOptionFromSubMenu || selectedOptionFromSubMenu > 5) {
                        System.out.println("Please type between number 1-5 .Please try again");
                    }
                } catch (Exception e) {
                    System.out.println("This is not a valid number.Please try again");
                }
            } while (1 > selectedOptionFromSubMenu || selectedOptionFromSubMenu > 5);
           return selectedOptionFromSubMenu;
        }
    
    
        public static int displayMenu(User userAccount) {
            int selectedOptionFromFirstMenu= 0;
            if(userAccount.getAdmin() == 1){// admin
                    System.out.println("\n----------- Menu----------");
                    System.out.println("1. Edit Passenger");
                    System.out.println("2. Edit Flight");
                    System.out.println("3. Edit Connection");
                    System.out.println("4. Edit FlightClass");
                    System.out.println("5. Edit Ticket");
                    System.out.println("6. Edit Payment");
                    System.out.println("7. Quit");
                    Scanner sc = new Scanner(System.in);
                    do {
                        try {
                            System.out.println("Please choose an option : ");
                            selectedOptionFromFirstMenu = Integer.parseInt(sc.nextLine());
                            if (1 > selectedOptionFromFirstMenu || selectedOptionFromFirstMenu > 7) {
                                System.out.println("Please type between number 1-7 .Please try again");
                            }
                        } catch (Exception e) {
                            System.out.println("This is not a valid number.Please try again");
                        }
                    } while (1 > selectedOptionFromFirstMenu || selectedOptionFromFirstMenu > 7);
                    if (selectedOptionFromFirstMenu == 7) exit(0);
            }else if (userAccount.getAdmin() == 2) { //user
                System.out.println("\n----------- Menu----------");
                System.out.println("1. Check Flight");
                System.out.println("2. Book Ticket");
                System.out.println("3. Search ");
                System.out.println("4. Quit");
                Scanner sc = new Scanner(System.in);
                do
                {
                    try
                    {
                        System.out.println("Please choose an option : ");
                        selectedOptionFromFirstMenu = Integer.parseInt(sc.nextLine());
                        if(1> selectedOptionFromFirstMenu || selectedOptionFromFirstMenu> 3){
                            System.out.println("Please type between 1-3 .Please try again");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("This is not a valid number.Please try again");
                    }
                }while(1> selectedOptionFromFirstMenu || selectedOptionFromFirstMenu> 3);
                if (selectedOptionFromFirstMenu == 7) exit(0);
            }else{
                System.out.println("illegal status");
                exit(0);
            }
            return selectedOptionFromFirstMenu;
        }
}
