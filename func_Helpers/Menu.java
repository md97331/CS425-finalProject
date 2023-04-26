package func_Helpers;

import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;
import classes_SQL.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.exit;

public class Menu {
    public static String SQLPASSWORD = "First5210";
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
        //sc.close();
        return chkAccount(username, password);
    }
    
        static User chkAccount(String username,String password) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
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
    
        public static void runQueryBySelectedOptions(int admin, int selectedOptionFromFirstMenu, int selectedOptionFromSubMenu) throws ClassNotFoundException, SQLException {
            Scanner sc = new Scanner(System.in); int selectedFlightOptions;
            int psgID; String firstName; String lastName; String password; String gender;
            String DOB; String passport; int age; String creditCardInfo; String cellphone;
            int flightID; int distance; String origin; String destination; double hours;
            boolean refundable; boolean oneWay; String arrivalTime; String departureTime;
            boolean flexibleDate; int milesDiscount; int psgLimitECON; int psgLimitCOMF;
            int psgLimitPREM; int psgLimitBUSS; int psgLimitFIRST; int ConnectionID;
            int ticketNumber; int PsgID; String classType; String dateOfFlight;
            Double standardPrice; Boolean cancelled; TicketPayment ticketPay;
            Passenger uPsge; Flight flght; FlightConnection flightConn;
            

            if(admin == 1){//admin
                switch(selectedOptionFromFirstMenu){
                    case 1://passenger    
                        switch(selectedOptionFromSubMenu){
                            case 1://insert             
                                System.out.println("Type in your psgID:");
                                psgID = retrieveData.verifyInteger();//not nullable, primary key
                                System.out.println("Type in your firstName:");
                                firstName = sc.nextLine();
                                System.out.println("Type in your lastName:");
                                lastName = sc.nextLine();
                                System.out.println("Type in your password:");
                                password = sc.nextLine();
                                System.out.println("Type in your gender:");
                                gender = sc.nextLine();
                                System.out.println("Type in your DOB:");
                                DOB = sc.nextLine();
                                System.out.println("Type in your passport:");
                                passport = sc.nextLine();
                                System.out.println("Type in your age:");
                                age = retrieveData.verifyInteger();
                                System.out.println("Type in your creditCardInfo:");
                                creditCardInfo = sc.nextLine();
                                System.out.println("Type in your cellphone:");
                                cellphone = sc.nextLine();
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
                                uPsge = retrieveData.getPassengerData(psgID);
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
                                flightID = retrieveData.verifyInteger();//not nullable, primary key
                                System.out.println("Type in your distance:");
                                distance = retrieveData.verifyInteger();
                                System.out.println("Type in your origin:");
                                origin = sc.nextLine();
                                System.out.println("Type in your destination:");
                                destination = sc.nextLine();
                                System.out.println("Type in your hours:");
                                hours = sc.nextDouble();
                                System.out.println("Type in your refundable:");
                                refundable = retrieveData.verifyBoolean();
                                System.out.println("Type in your oneWay:");
                                oneWay = retrieveData.verifyBoolean();
                                System.out.println("Type in your arrivalTime:");
                                arrivalTime = sc.nextLine();
                                System.out.println("Type in your departureTime:");
                                departureTime = sc.nextLine();
                                System.out.println("Type in your flexibleDate:");
                                flexibleDate = retrieveData.verifyBoolean();
                                System.out.println("Type in your milesDiscount:");
                                milesDiscount = retrieveData.verifyInteger();
                                System.out.println("Type in your psgLimitECON:");
                                psgLimitECON = retrieveData.verifyInteger();
                                System.out.println("Type in your psgLimitCOMF:");
                                psgLimitCOMF = retrieveData.verifyInteger();
                                System.out.println("Type in your psgLimitPREM:");
                                psgLimitPREM = retrieveData.verifyInteger();
                                System.out.println("Type in your psgLimitBUSS:");
                                psgLimitBUSS = retrieveData.verifyInteger();
                                System.out.println("Type in your psgLimitFIRST:");
                                psgLimitFIRST = retrieveData.verifyInteger();
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
                                flght = retrieveData.getFlightData(flightID);
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
                                ConnectionID = retrieveData.verifyInteger();
                                retrieveData.dropRowInConnection(ConnectionID);
                                break;
                            case 4://select
                                System.out.println("Type in your flightID:");
                                flightID = retrieveData.verifyInteger();
                                flightConn = retrieveData.getFlightConnection(flightID);
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
                                ticketNumber = retrieveData.verifyInteger();//not nullable, primary key
                                System.out.println("Type in your classType:");
                                classType = sc.nextLine();
                                System.out.println("Type in your PsgID:");
                                PsgID = retrieveData.verifyInteger();
                                System.out.println("Type in your dateOfFlight:");
                                dateOfFlight = sc.nextLine();
                                System.out.println("Type in your standardPrice:");
                                standardPrice = sc.nextDouble();
                                System.out.println("Type in your cancelled:");
                                cancelled = retrieveData.verifyBoolean();
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
                                ticketPay = retrieveData.getTicketPaymentData(ticketNumber);
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
                                ticketNumber = retrieveData.verifyInteger();
                                ticketPay = retrieveData.getTicketPaymentData(ticketNumber);
                                ticketPay.printData();
                                break;
                            default://back to main menu
                                break;
                        }
                        break;
                    default:
                           
                }
            }
            else if(admin ==2){
                switch(selectedOptionFromFirstMenu){
                    case 1://search flight
                        System.out.println("Start to searching all the flight");
                        System.out.println("================== Options ==================");
                        System.out.println("1. Search by origin and destination ");
                        System.out.println("2. Search by flightID");
                        System.out.println("\n Please choose one of the options:");
                        do{
                            selectedFlightOptions = retrieveData.verifyInteger();
                            if(selectedFlightOptions < 1 || selectedFlightOptions > 2)
                                System.out.println("Please type number between 1-2");
                        }while(selectedFlightOptions < 1 || selectedFlightOptions > 2);     
                        if(selectedFlightOptions==1){
                            System.out.println("Type in your origin:");
                            origin = sc.nextLine();
                            System.out.println("Type in your destination:"); 
                            destination = sc.nextLine();
                            flght = retrieveData.getFlightData(destination, origin);
                        }else{
                            System.out.println("Type in your flightID:");
                            flightID = retrieveData.verifyInteger();
                            flght = retrieveData.getFlightData(flightID);
                        }
                        flght.printData();
                        break;   
                    case 2://Book Ticket
                        System.out.println("Type in your ticketNumber:");
                        ticketNumber = retrieveData.verifyInteger();//not nullable, primary key
                        System.out.println("Type in your classType:");
                        classType = sc.nextLine();
                        System.out.println("Type in your PsgID:");
                        PsgID = retrieveData.verifyInteger();
                        System.out.println("Type in your dateOfFlight:");
                        dateOfFlight = sc.nextLine();
                        System.out.println("Type in your standardPrice:");
                        standardPrice = sc.nextDouble();
                        System.out.println("Type in your cancelled:");
                        cancelled = retrieveData.verifyBoolean();
                        retrieveData.insertIntoTicket(ticketNumber, classType, PsgID, dateOfFlight, standardPrice, cancelled);
                        break;
                    case 3://Search User Info
                        System.out.println("Type in your psgID:");
                        psgID = retrieveData.verifyInteger();
                        uPsge = retrieveData.getPassengerData(psgID);
                        uPsge.printData();
                        break;
                    default:
                    
                }
            }
            sc.close();
        }
    
        public static int displaySubMenu(int selectedOptionFromFirstMenu) {
            Map<Integer, String> tableNamesFromFirstMenu = new Maps().initTablesFromFirstAdminMenu();
            String tableNameFromFirstMenu = tableNamesFromFirstMenu.get(selectedOptionFromFirstMenu);
            int selectedOptionFromSubMenu = 0;
            System.out.println("\n================== " + tableNameFromFirstMenu + "==================");
            System.out.println("1. Add " + tableNameFromFirstMenu);
            System.out.println("2. Update " + tableNameFromFirstMenu);
            System.out.println("3. Delete " + tableNameFromFirstMenu);
            System.out.println("4. View " + tableNameFromFirstMenu);
            System.out.println("5. Create Columns");
            System.out.println("6. Quit");
            System.out.println("\nPlease choose an option : ");
            
            
            do{  
                selectedOptionFromSubMenu = retrieveData.verifyInteger();
                if(selectedOptionFromSubMenu>6 || selectedOptionFromSubMenu<1) 
                        System.out.println("Please type number between 1-6");  
            }while( selectedOptionFromSubMenu>6 || selectedOptionFromSubMenu<1); 
           return selectedOptionFromSubMenu;
        }
    
        public static int displayMenu(User userAccount) {
            int selectedOptionFromFirstMenu= 0;
            if(userAccount.getAdmin() == 1){// admin
                    System.out.println("\n================== Menu ==================");
                    System.out.println("1. Edit Passenger");
                    System.out.println("2. Edit Flight");
                    System.out.println("3. Edit Connection");
                    System.out.println("4. Edit Ticket");
                    System.out.println("5. Edit Payment");
                    System.out.println("6. Quit");
                    System.out.println("\nPlease choose an option : ");
                    do{
                    selectedOptionFromFirstMenu = retrieveData.verifyInteger();
                    if(selectedOptionFromFirstMenu>6 || selectedOptionFromFirstMenu<1) 
                        System.out.println("Please type number between 1-6");    
                    }while( selectedOptionFromFirstMenu>6 || selectedOptionFromFirstMenu<1);
                    if (selectedOptionFromFirstMenu == 6) exit(0);
            }else if (userAccount.getAdmin() == 2) { //user
                System.out.println("\n================== Menu ==================");
                System.out.println("1. Search Flight");
                System.out.println("2. Book Ticket");
                System.out.println("3. Search User Info");
                System.out.println("4. Quit");
                System.out.println("\nPlease choose an option : ");
                do{
                    selectedOptionFromFirstMenu = retrieveData.verifyInteger();
                    if(selectedOptionFromFirstMenu>4 || selectedOptionFromFirstMenu<1) 
                    System.out.println("Please type number between 1-4");   
                }while( selectedOptionFromFirstMenu>4 || selectedOptionFromFirstMenu<1);
                if (selectedOptionFromFirstMenu == 4) exit(0);
            }else{
                System.out.println("illegal status");
                exit(0);
            }
            return selectedOptionFromFirstMenu;
        }
}
