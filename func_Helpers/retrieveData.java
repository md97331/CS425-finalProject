package func_Helpers;
import classes_SQL.*;

import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;


public class retrieveData {
    public static String SQLPASSWORD = "First5210";
    public static int verifyInteger() {
        int pnum = 0; boolean flag = true;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");

        do {
            try{
                pnum = Integer.parseInt(input.nextLine());
                flag = false;
                return pnum;
            }
            catch(Exception e ){
                System.out.print("Invalid Entry, Enter Integer: ");        
                }
        }
        while(flag == true); 
        input.close();
        return pnum;
    }

    public static boolean verifyBoolean() {
        boolean value = true; String str = ""; boolean flag = true;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 'true' or 'false': ");
        do {
            str = input.nextLine();
            if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false")) {
                    value = Boolean.parseBoolean(str);
                    flag = false;
                    return value;
            } else {
                    System.out.println("Error: Invalid boolean value");
            }
        }
        while(flag);
        input.close();
        return value;
    }




    public static Passenger getPassengerData(int currPsgID) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
        PreparedStatement pstmt=con.prepareStatement("SELECT * FROM passenger WHERE PsgID = ?");
        pstmt.setInt(1, currPsgID);
        ResultSet rs = pstmt.executeQuery();
        rs.next();

        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        String password = rs.getString("pwd");
        String gender = rs.getString("gender");
        String DOB = rs.getString("DOB");
        String passport = rs.getString("passport");
        int age = rs.getInt("age");
        String creditCardInfo = rs.getString("creditCardInfo");
        String cellphone = rs.getString("cellphone");

        Passenger returnedPassenger = new Passenger(currPsgID,firstName,lastName,password,gender,DOB, passport, age, creditCardInfo,cellphone);

        rs.close();
        pstmt.close();
        con.close();
        return returnedPassenger;
    }

    public static Passenger getPassengerDataByPassport(int passportNum) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
        PreparedStatement pstmt=con.prepareStatement("SELECT * FROM Passenger WHERE passport = ?");
        pstmt.setInt(1, passportNum);
        ResultSet rs = pstmt.executeQuery();
        rs.next();

        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        String password = rs.getString("pwd");
        String gender = rs.getString("gender");
        String DOB = rs.getString("DOB");
        String passport = rs.getString("passport");
        int age = rs.getInt("age");
        String creditCardInfo = rs.getString("creditCardInfo");
        String cellphone = rs.getString("cellphone");

        Passenger returnedPassenger = new Passenger(passportNum,firstName,lastName,password,gender,DOB, passport, age, creditCardInfo,cellphone);

        rs.close();
        pstmt.close();
        con.close();
        return returnedPassenger;
    }

    public static Flight getFlightData(int currFlightID) throws SQLException, ClassNotFoundException {
        Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AIRLINE_DATABASE?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root","First5210");
        PreparedStatement Get = Con.prepareStatement("select * from flight where flightID = ?");
        Get.setInt(1, currFlightID);
        ResultSet rs = Get.executeQuery();
        rs.next();

        int distance = rs.getInt("distance");
        String origin = rs.getString("origin");
        String destination = rs.getString("destination");
        double hours = rs.getDouble("hours");
        boolean refundable = rs.getBoolean("refundable");
        boolean oneWay = rs.getBoolean("oneWay");
        String arrivalTime = rs.getString("arrivalTime");
        String departureTime = rs.getString("departureTime");
        boolean flexibleDate = rs.getBoolean("flexibleDate");
        int milesDiscount = rs.getInt("milesDiscount");
        int psgLimitECON = rs.getInt("psgLimitECON");
        int psgLimitCOMF = rs.getInt("psgLimitCOMF");
        int psgLimitPREM = rs.getInt("psgLimitPREM");
        int psgLimitBUSS = rs.getInt("psgLimitBUSS");
        int psgLimitFIRST = rs.getInt("psgLimitFIRST");

        Flight returnedFlight = new Flight(currFlightID,distance,origin,destination,hours,refundable, oneWay, arrivalTime, departureTime,flexibleDate,milesDiscount,psgLimitECON,psgLimitCOMF,psgLimitPREM, psgLimitBUSS,psgLimitFIRST);

        rs.close();
        Get.close();
        Con.close();
        return returnedFlight;
    }

    public static TicketPayment getTicketPaymentData(int currTicketNum) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
        PreparedStatement pstmt=con.prepareStatement("select * from payment natural join ticket where ticketNumber = ?");
        pstmt.setInt(1, currTicketNum);
        ResultSet rs = pstmt.executeQuery();
        rs.next();

        String classType = rs.getString("classType");
        int PsgID = rs.getInt("PsgID");
        String dateOfFlight = rs.getString("dateOfFlight");
        double standardPrice = rs.getDouble("standardPrice");
        boolean cancelled = rs.getBoolean("cancelled");
        int confirmationID = rs.getInt("confirmationID");
        String paymentInfo = rs.getString("paymentInfo");
        int eCredits = rs.getInt("eCredits");
        int deltaGIftCard = rs.getInt("deltaGIftCard");

        TicketPayment returnedTicketPayment = new TicketPayment(currTicketNum,classType,PsgID,dateOfFlight,standardPrice,cancelled, confirmationID, paymentInfo, eCredits,deltaGIftCard);

        rs.close();
        pstmt.close();
        con.close();
        return returnedTicketPayment;
    }

    public static FlightConnection getFlightConnection(int currFlightID) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
        PreparedStatement pstmt=con.prepareStatement("select * from connection join flight on (connection.flightID = flight.flightID) where flight.flightID = ?");
        pstmt.setInt(1, currFlightID);
        ResultSet rs = pstmt.executeQuery();
        rs.next();

        int distance = rs.getInt("distance");
        String origin = rs.getString("origin");
        String destination = rs.getString("destination");
        double hours = rs.getDouble("hours");
        boolean refundable = rs.getBoolean("refundable");
        boolean oneWay = rs.getBoolean("oneWay");
        String arrivalTime = rs.getString("arrivalTime");
        String departureTime = rs.getString("departureTime");
        boolean flexibleDate = rs.getBoolean("flexibleDate");
        int milesDiscount = rs.getInt("milesDiscount");
        int psgLimitECON = rs.getInt("psgLimitECON");
        int psgLimitCOMF = rs.getInt("psgLimitCOMF");
        int psgLimitPREM = rs.getInt("psgLimitPREM");
        int psgLimitBUSS = rs.getInt("psgLimitBUSS");
        int psgLimitFIRST = rs.getInt("psgLimitFIRST");
        int connectionID = rs.getInt("ConnectionID");
        String cArrivalTime = rs.getString("cArrivalTime");
        String cDepartureTime = rs.getString("cDepartureTime");
        String airportConnection = rs.getString("airportConnection");


        FlightConnection returnedFlightConnection = new FlightConnection(currFlightID,distance,
        origin,destination,hours,refundable, oneWay, arrivalTime, departureTime,flexibleDate,
        milesDiscount,psgLimitECON,psgLimitCOMF,psgLimitPREM, psgLimitBUSS,psgLimitFIRST,
        connectionID, cArrivalTime, cDepartureTime, airportConnection);

        rs.close();
        pstmt.close();
        con.close();
        return returnedFlightConnection;
    }

    public static Flight getFlightData(String dest, String ori) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
        PreparedStatement pstmt=con.prepareStatement("SELECT * FROM flight WHERE destination = ? AND origin = ? ORDER BY distance ASC");
        pstmt.setString(1, dest);
        pstmt.setString(2, ori);
        ResultSet rs = pstmt.executeQuery();
        rs.next();

        int flightID = rs.getInt("flightID");
        int distance = rs.getInt("distance");
        String origin = rs.getString("origin");
        String destination = rs.getString("destination");
        double hours = rs.getDouble("hours");
        boolean refundable = rs.getBoolean("refundable");
        boolean oneWay = rs.getBoolean("oneWay");
        String arrivalTime = rs.getString("arrivalTime");
        String departureTime = rs.getString("departureTime");
        boolean flexibleDate = rs.getBoolean("flexibleDate");
        int milesDiscount = rs.getInt("milesDiscount");
        int psgLimitECON = rs.getInt("psgLimitECON");
        int psgLimitCOMF = rs.getInt("psgLimitCOMF");
        int psgLimitPREM = rs.getInt("psgLimitPREM");
        int psgLimitBUSS = rs.getInt("psgLimitBUSS");
        int psgLimitFIRST = rs.getInt("psgLimitFIRST");

        Flight returnedFlight = new Flight(flightID,distance,
        origin,destination,hours,refundable, oneWay, arrivalTime, departureTime,flexibleDate,
        milesDiscount,psgLimitECON,psgLimitCOMF,psgLimitPREM, psgLimitBUSS,psgLimitFIRST);

        rs.close();
        pstmt.close();
        con.close();
        return returnedFlight;
    }

    public static PassengerTicket searchTicketByName(String first, String last) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
        PreparedStatement pstmt=con.prepareStatement("SELECT * FROM ticket JOIN passenger ON (ticket.PsgId = passenger.PsgID) where firstName = ? and lastName = ?");
        pstmt.setString(1, first);
        pstmt.setString(2, last);
        ResultSet rs = pstmt.executeQuery();
        rs.next();

        int PsgID = rs.getInt("PsgID");
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        String password = rs.getString("pwd");
        String gender = rs.getString("gender");
        String DOB = rs.getString("DOB");
        String passport = rs.getString("passport");
        int age = rs.getInt("age");
        String creditCardInfo = rs.getString("creditCardInfo");
        String cellphone = rs.getString("cellphone");
        int ticketNumber = rs.getInt("ticketNumber");
        String classType = rs.getString("classType");
        String dateOfFlight = rs.getString("dateOfFlight");
        double standardPrice = rs.getDouble("standardPrice");
        boolean cancelled = rs.getBoolean("cancelled");

        PassengerTicket returnedPassengerTicket = new PassengerTicket(PsgID,firstName,lastName,
        password,gender,DOB, passport, age, creditCardInfo,cellphone, ticketNumber, classType, dateOfFlight,
        standardPrice, cancelled);

        rs.close();
        pstmt.close();
        con.close();
        return returnedPassengerTicket;
    }

    public static void dropTable(String table) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
        PreparedStatement pstmt=con.prepareStatement("Drop Table ?");
        pstmt.setString(1, table);
        pstmt.executeQuery();
        pstmt.close();
        con.close();
    }

    public static void dropRowInTicket(int ticketNumber) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
        PreparedStatement pstmt=con.prepareStatement("DELETE FROM ticket WHERE ticketNumber=?");
        pstmt.setInt(1, ticketNumber);
        pstmt.executeQuery();
        pstmt.close();
        con.close();
    }    

    public static void dropRowInPassenger(int PsgID) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
        PreparedStatement pstmt=con.prepareStatement("DELETE FROM passenger WHERE PsgID=?");
        pstmt.setInt(1, PsgID);
        pstmt.executeQuery();
        pstmt.close();
        con.close();
    }

    public static void dropRowInFlight(int flightID) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
        PreparedStatement pstmt=con.prepareStatement("DELETE FROM flight WHERE flightID=?");
        pstmt.setInt(1, flightID);
        pstmt.executeQuery();
        pstmt.close();
        con.close();
    }

    public static void dropRowInConnection(int ConnectionID) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
        PreparedStatement pstmt=con.prepareStatement("DELETE FROM connection WHERE ConnectionID=?");
        pstmt.setInt(1, ConnectionID);
        pstmt.executeQuery();
        pstmt.close();
        con.close();
    }

    public static void insertIntoPassengers(int psgID, String firstName, String lastName,
     String password, String gender, String DOB, String passport,
      int age, String creditCardInfo, String cellphone) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);

        String sql = "insert into passanger values (?, ?, ?, ?, ?, ?, ?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, psgID);
        stmt.setString(2, firstName);
        stmt.setString(3, lastName);
        stmt.setString(4, password);
        stmt.setString(5, gender);
        stmt.setString(6, DOB);
        stmt.setString(7, passport);
        stmt.setInt(8, age);
        stmt.setString(9, creditCardInfo);
        stmt.setString(10, cellphone);
        stmt.executeQuery();
        
        stmt.close();
        con.close();
    }


    public static void insertIntoTicket(int ticketNumber, String classType, int PsgID,
    String dateOfFlight, double standardPrice, boolean cancelled) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
        PreparedStatement pstmt=con.prepareStatement("insert into ticket values (?, ?, ?, ?, ?, ?)");
        pstmt.setInt(1, ticketNumber);
        pstmt.setString(2, classType);
        pstmt.setInt(3, PsgID);
        pstmt.setString(4, dateOfFlight);
        pstmt.setDouble(5, standardPrice);
        pstmt.setBoolean(6, cancelled);
        pstmt.executeQuery();
        pstmt.close();
        con.close();
    }

    public static void insertIntoFlight(int flightID, int distance, String origin,
    String destination, double hours, boolean refundable, boolean oneWay, String arrivalTime,
    String departureTime, boolean flexibleDate, int milesDiscount, int psgLimitECON,
    int psgLimitCOMF, int psgLimitPREM, int psgLimitBUSS, int psgLimitFIRST) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
        PreparedStatement pstmt=con.prepareStatement("insert into flight values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pstmt.setInt(1, flightID);
        pstmt.setInt(2, distance);
        pstmt.setString(3, origin);
        pstmt.setString(4, destination);
        pstmt.setDouble(5, hours);
        pstmt.setBoolean(6, refundable);
        pstmt.setBoolean(7, oneWay);
        pstmt.setString(8, arrivalTime);
        pstmt.setString(9, departureTime);
        pstmt.setBoolean(10, flexibleDate);
        pstmt.setInt(11, milesDiscount);
        pstmt.setInt(12, psgLimitECON);
        pstmt.setInt(13, psgLimitCOMF);
        pstmt.setInt(14, psgLimitPREM);
        pstmt.setInt(15, psgLimitBUSS);
        pstmt.setInt(16, psgLimitFIRST);
        pstmt.executeQuery();
        pstmt.close();
        con.close();

        // Implement a function that displays all the data PER TABLE

    }
    public static void passengerUpdate(int currPsgID) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("========= UPDATING PASSENGER ===========");
        System.out.print("PsgID: "); int PsgID = sc.nextInt();
        System.out.print("flightID: "); int flightID = sc.nextInt();
        System.out.print("firstName: "); String firstName = sc.nextLine();
        System.out.print("lastName: "); String lastName = sc.nextLine();
        System.out.print("pwd: "); String pwd = sc.nextLine();
        System.out.print("gender: "); String gender = sc.nextLine();
        System.out.print("DOB: "); String DOB = sc.nextLine();
        System.out.print("passport: "); String passport = sc.nextLine();
        System.out.print("age: "); int age = sc.nextInt();
        System.out.print("creditCardInfo: "); String creditCardInfo = sc.nextLine();
        System.out.print("cellPhone: "); String cellPhone = sc.nextLine();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_database?allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8&useSSL=false","root",SQLPASSWORD);
        PreparedStatement pstmt=con.prepareStatement("UPDATE passenger SET PsgID = ?, flightID = ?, firstName = ?, lastName = ?, pwd = ?, gender = ?, DOB = ?, ");
        pstmt.setInt(1, currPsgID);
        ResultSet rs = pstmt.executeQuery();




//        rs.close();
//        pstmt.close();
//        con.close();
    }
}
