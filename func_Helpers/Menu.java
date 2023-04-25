package func_Helpers;

import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;
import classes_SQL.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.exit;

public class Menu {
    public static String SQLPASSWORD = "Jerry89232382";
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
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
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
     
    
        public static void runQueryBySelectedOptions(int selectedOptionFromFirstMenu, int selectedOptionFromSubMenu) throws ClassNotFoundException, SQLException {
            Scanner sc = new Scanner(System.in);
            switch(selectedOptionFromFirstMenu){
                case 1://passenger    
                    switch(selectedOptionFromSubMenu){
                        case 1://insert             
                            System.out.println("Type in your psgID:");
                            int psgID = retrieveData.verifyInteger();//not nullable, primary key
                            System.out.println("Type in your firstName:");
                            String firstName = sc.nextLine();
                            System.out.println("Type in your lastName:");
                            String lastName = sc.nextLine();
                            System.out.println("Type in your password:");
                            String password = sc.nextLine();
                            System.out.println("Type in your gender:");
                            String gender = sc.nextLine();
                            System.out.println("Type in your DOB:");
                            String DOB = sc.nextLine();
                            System.out.println("Type in your passport:");
                            String passport = sc.nextLine();
                            System.out.println("Type in your age:");
                            int age = retrieveData.verifyInteger();
                            System.out.println("Type in your creditCardInfo:");
                            String creditCardInfo = sc.nextLine();
                            System.out.println("Type in your cellphone:");
                            String cellphone = sc.nextLine();
                            retrieveData.insertIntoPassengers(psgID, firstName, lastName, password, gender, DOB, passport, age, creditCardInfo, cellphone);
                            break;
                        case 2://update
                            break;
                        case 3://delete
                            System.out.println("Type in your psgID:");
                            psgID = retrieveData.verifyInteger();
                            retrieveData.dropRowInPassenger(psgID);
                            break;
                        case 4://select
                            System.out.println("Type in your psgID:");
                            psgID = retrieveData.verifyInteger();
                            Passenger uPsge = retrieveData.getPassengerData(psgID);
                            uPsge.printData();
                            break;
                        default://back to main menu
                            break;

                    }
                    break;
                case 2: //flight
                    switch(selectedOptionFromSubMenu){
                        case 1://insert             
                            System.out.println("Type in your flightID:");
                            int flightID = retrieveData.verifyInteger();//not nullable, primary key
                            System.out.println("Type in your distance:");
                            int distance = retrieveData.verifyInteger();
                            System.out.println("Type in your origin:");
                            String origin = sc.nextLine();
                            System.out.println("Type in your destination:");
                            String destination = sc.nextLine();
                            System.out.println("Type in your hours:");
                            double hours = retrieveData.verifyDouble();
                            System.out.println("Type in your refundable:");
                            boolean refundable = retrieveData.verifyBoolean();
                            System.out.println("Type in your oneWay:");
                            boolean oneWay = retrieveData.verifyBoolean();
                            System.out.println("Type in your arrivalTime:");
                            String arrivalTime = sc.nextLine();
                            System.out.println("Type in your departureTime:");
                            String departureTime = sc.nextLine();
                            System.out.println("Type in your flexibleDate:");
                            boolean flexibleDate = retrieveData.verifyBoolean();
                            System.out.println("Type in your milesDiscount:");
                            int milesDiscount = retrieveData.verifyInteger();
                            System.out.println("Type in your psgLimitECON:");
                            int psgLimitECON = retrieveData.verifyInteger();
                            System.out.println("Type in your psgLimitCOMF:");
                            int psgLimitCOMF = retrieveData.verifyInteger();
                            System.out.println("Type in your psgLimitPREM:");
                            int psgLimitPREM = retrieveData.verifyInteger();
                            System.out.println("Type in your psgLimitBUSS:");
                            int psgLimitBUSS = retrieveData.verifyInteger();
                            System.out.println("Type in your psgLimitFIRST:");
                            int psgLimitFIRST = retrieveData.verifyInteger();
                            retrieveData.insertIntoFlight(flightID, distance, origin, destination, hours, refundable, oneWay, arrivalTime, departureTime, flexibleDate, milesDiscount, psgLimitECON, psgLimitCOMF, psgLimitPREM, psgLimitBUSS, psgLimitFIRST);
                            break;
                        case 2://update
                            break;
                        case 3://delete
                            System.out.println("Type in your flightID:");
                            flightID = retrieveData.verifyInteger();
                            retrieveData.dropRowInFlight(flightID);
                            break;
                        case 4://select
                            System.out.println("Type in your flightID:");
                            flightID = retrieveData.verifyInteger();
                            Flight flght = retrieveData.getFlightData(flightID);
                            flght.printData();
                            break;
                        default://back to main menu
                            break;
                    }
                    break;
                case 3: //connection
                    switch(selectedOptionFromSubMenu){
                        case 1://insert             
                            break;
                        case 2://update
                            break;
                        case 3://delete
                            System.out.println("Type in your ConnectionID:");
                            int ConnectionID = retrieveData.verifyInteger();
                            retrieveData.dropRowInConnection(ConnectionID);
                            break;
                        case 4://select
                            System.out.println("Type in your flightID:");
                            int flightID = retrieveData.verifyInteger();
                            FlightConnection flightConn = retrieveData.getFlightConnection(flightID);
                            flightConn.printData();
                            break;
                        default://back to main menu
                            break;
                    }
                    break;
                case 4: //ticket
                    switch(selectedOptionFromSubMenu){
                        case 1://insert             
                            System.out.println("Type in your ticketNumber:");
                            int ticketNumber = retrieveData.verifyInteger();//not nullable, primary key
                            System.out.println("Type in your classType:");
                            String classType = sc.nextLine();
                            System.out.println("Type in your PsgID:");
                            int PsgID = retrieveData.verifyInteger();
                            System.out.println("Type in your dateOfFlight:");
                            String dateOfFlight = sc.nextLine();
                            System.out.println("Type in your standardPrice:");
                            Double standardPrice = retrieveData.verifyDouble();
                            System.out.println("Type in your cancelled:");
                            Boolean cancelled = retrieveData.verifyBoolean();
                            retrieveData.insertIntoTicket(ticketNumber, classType, PsgID, dateOfFlight, standardPrice, cancelled);
                            break;
                        case 2://update
                            break;
                        case 3://delete
                            System.out.println("Type in your ticketNumber:");
                            ticketNumber = retrieveData.verifyInteger();
                            retrieveData.dropRowInTicket(ticketNumber);
                            break;
                        case 4://select
                            System.out.println("Type in your ticketNumber:");
                            ticketNumber = retrieveData.verifyInteger();
                            TicketPayment ticketPay = retrieveData.getTicketPaymentData(ticketNumber);
                            ticketPay.printData();
                            break;
                        default://back to main menu
                            break;
                    }
                    break;
                case 5: //payment
                    switch(selectedOptionFromSubMenu){
                        case 1://insert             
                            break;
                        case 2://update
                            break;
                        case 3://delete
                            break;
                        case 4://select
                            System.out.println("Type in your ticketNumber:");
                            int ticketNumber = retrieveData.verifyInteger();
                            TicketPayment ticketPay = retrieveData.getTicketPaymentData(ticketNumber);
                            ticketPay.printData();
                            break;
                        default://back to main menu
                            break;
                    }
                    break;
            }
            sc.close();
        }
    
        public static int displaySubMenu(int selectedOptionFromFirstMenu) {
            Map<Integer, String> tableNamesFromFirstMenu = new Maps().initTablesFromFirstAdminMenu();
            String tableNameFromFirstMenu = tableNamesFromFirstMenu.get(selectedOptionFromFirstMenu);
            int selectedOptionFromSubMenu = 0;
            System.out.println("\n----------- " + tableNameFromFirstMenu + "----------");
            System.out.println("1. Add " + tableNameFromFirstMenu);
            System.out.println("2. Update " + tableNameFromFirstMenu);
            System.out.println("3. Delete " + tableNameFromFirstMenu);
            System.out.println("4. View " + tableNameFromFirstMenu);
            System.out.println("5. Create Columns");
            System.out.println("6. Quit");
            System.out.println("\nPlease choose an option : ");
            //do{  
                selectedOptionFromSubMenu = retrieveData.verifyInteger();
            //}while( selectedOptionFromSubMenu>7 || selectedOptionFromSubMenu<1);

        

            // do {
            //     try {
            //         System.out.println("Please choose an option : ");
            //         selectedOptionFromSubMenu = Integer.parseInt(sc.nextLine());
            //         if (1 > selectedOptionFromSubMenu || selectedOptionFromSubMenu > 5) {
            //             System.out.println("Please type between number 1-6 .Please try again");
            //         }
            //     } catch (Exception e) {
            //         System.out.println("This is not a valid number.Please try again");
            //     }
            // } while (1 > selectedOptionFromSubMenu || selectedOptionFromSubMenu > 6);
            //sc.close();
           return selectedOptionFromSubMenu;
        }
    
        public static int displayMenu(User userAccount) {
            int selectedOptionFromFirstMenu= 0;
            if(userAccount.getAdmin() == 1){// admin
                    System.out.println("\n----------- Menu----------");
                    System.out.println("1. Edit Passenger");
                    System.out.println("2. Edit Flight");
                    System.out.println("3. Edit Connection");
                    System.out.println("4. Edit Ticket");
                    System.out.println("5. Edit Payment");
                    System.out.println("6. Quit");
                    System.out.println("\nPlease choose an option : ");
                    //do{
                        
                    selectedOptionFromFirstMenu = retrieveData.verifyInteger();
                    //}while( selectedOptionFromFirstMenu>7 || selectedOptionFromFirstMenu<1);

                    // Scanner sc = new Scanner(System.in);
                    // do {
                    //     try {
                    //         System.out.println("Please choose an option : ");
                    //         selectedOptionFromFirstMenu = Integer.parseInt(sc.nextLine());
                    //         if (1 > selectedOptionFromFirstMenu || selectedOptionFromFirstMenu > 7) {
                    //             System.out.println("Please type between number 1-7 .Please try again");
                    //         }
                    //     } catch (Exception e) {
                    //         System.out.println("This is not a valid number.Please try again");
                    //     }
                    // } while (1 > selectedOptionFromFirstMenu || selectedOptionFromFirstMenu > 7);
                    if (selectedOptionFromFirstMenu == 7) exit(0);
                 
            }else if (userAccount.getAdmin() == 2) { //user
                System.out.println("\n----------- Menu----------");
                System.out.println("1. Search Flight");
                System.out.println("2. Book Ticket");
                System.out.println("3. Search User Info");
                System.out.println("4. Quit");
                System.out.println("\nPlease choose an option : ");
                //do{
                    
                    selectedOptionFromFirstMenu = retrieveData.verifyInteger();
                //}while( selectedOptionFromFirstMenu>4 || selectedOptionFromFirstMenu<1);


                // Scanner sc = new Scanner(System.in);
                // do
                // {
                //     try
                //     {
                //         System.out.println("Please choose an option : ");
                //         selectedOptionFromFirstMenu = Integer.parseInt(sc.nextLine());
                //         if(1> selectedOptionFromFirstMenu || selectedOptionFromFirstMenu> 3){
                //             System.out.println("Please type between 1-3 .Please try again");
                //         }
                //     }
                //     catch(Exception e)
                //     {
                //         System.out.println("This is not a valid number.Please try again");
                //     }
                // }while(1> selectedOptionFromFirstMenu || selectedOptionFromFirstMenu> 3);
                // sc.close();
                if (selectedOptionFromFirstMenu == 4) exit(0);
            }else{
                System.out.println("illegal status");
                exit(0);
            }
            return selectedOptionFromFirstMenu;
        }
}
