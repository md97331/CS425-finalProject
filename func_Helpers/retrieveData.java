package func_Helpers;
import classes_SQL.*;

import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;


public class retrieveData {
    private static Connection connection;
    static String url = "jdbc:mysql://localhost:3306/airline";
    static String username = "root";
    static String password = "First5210";


    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Error closing database connection: " + e.getMessage());
            }
        }
    }

    public static void openConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established.");
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }

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

    public static Passenger getPassengerData(int currPsgID) throws SQLException {
        openConnection();
        String sql = "SELECT * FROM Passenger WHERE PsgID = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, currPsgID);

        ResultSet rs = stmt.executeQuery();
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
        closeConnection();
        return returnedPassenger;
    }

    public static Flight getFlightData(int currFlightID) throws SQLException {
        openConnection();
        String sql = "SELECT * FROM Flight WHERE flightID = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, currFlightID);

        ResultSet rs = stmt.executeQuery();
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
        closeConnection();
        return returnedFlight;
    }

    public static TicketPayment getTicketPaymentData(int currTicketNum) throws SQLException {
        openConnection();
        String sql = "select * from payment natural join ticket where ticketNumber = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, currTicketNum);

        ResultSet rs = stmt.executeQuery();
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
        closeConnection();
        return returnedTicketPayment;
    }

    public static FlightConnection getFlightConnection(int currFlightID) throws SQLException {
        openConnection();
        String sql = "select * from connection join flight on (connection.flightID = flight.flightID) where flight.flightID = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, currFlightID);

        ResultSet rs = stmt.executeQuery();
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
        closeConnection();
        return returnedFlightConnection;
    }

    public static Flight getFlightData(String dest, String ori) throws SQLException {
        openConnection();
        String sql = "SELECT * FROM flight WHERE destination = '?' AND origin = '?' ORDER BY distance ASC;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, dest);
        stmt.setString(2, ori);

        ResultSet rs = stmt.executeQuery();
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
        closeConnection();
        return returnedFlight;
    }

    public static PassengerTicket searchTicketByName(String first, String last) throws SQLException {
        openConnection();
        String sql = "FROM ticket JOIN passenger ON (ticket.PsgId = passenger.PsgID) where firstName = '?' and lastName = '?';";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, first);
        stmt.setString(2, last);

        ResultSet rs = stmt.executeQuery();
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
        closeConnection();
        return returnedPassengerTicket;
    }

    public static void dropTable(String table) throws SQLException {
        openConnection();
        String sql = "Drop Table ?;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, table);
        stmt.executeQuery();
        closeConnection();
    }

    public static void dropRowInTicket(int ticketNumber) throws SQLException {
        openConnection();
        String sql = "DELETE FROM Ticket WHERE ticketNumber=?;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, ticketNumber);
        stmt.executeQuery();
        closeConnection();
    }    

    public static void dropRowInPassenger(int PsgID) throws SQLException {
        openConnection();
        String sql = "DELETE FROM Passenger WHERE PsgID=?;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, PsgID);
        stmt.executeQuery();
        closeConnection();
    }

    public static void dropRowInFlight(int flightID) throws SQLException {
        openConnection();
        String sql = "DELETE FROM Flight WHERE flightID=?;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, flightID);
        stmt.executeQuery();
        closeConnection();
    }

    public static void dropRowInConnection(int ConnectionID) throws SQLException {
        openConnection();
        String sql = "DELETE FROM Connection WHERE ConnectionID=?;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, ConnectionID);
        stmt.executeQuery();
        closeConnection();
    }

    public static void insertIntoPassengers(int psgID, String firstName, String lastName,
     String password, String gender, String DOB, String passport,
      int age, String creditCardInfo, String cellphone) throws SQLException {
        openConnection();
        String sql = "insert into Passanger values (?, '?', '?', '?', '?', '?', '?',?,'?','?');";
        PreparedStatement stmt = connection.prepareStatement(sql);
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
        closeConnection();
    }

    public static void insertIntoTicket(int ticketNumber, String classType, int PsgID,
    String dateOfFlight, double standardPrice, boolean cancelled) throws SQLException {
        openConnection();
        String sql = "insert into Ticket values (?, '?', ?, '?', ?, ?);";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, ticketNumber);
        stmt.setString(2, classType);
        stmt.setInt(3, PsgID);
        stmt.setString(4, dateOfFlight);
        stmt.setDouble(5, standardPrice);
        stmt.setBoolean(6, cancelled);
        stmt.executeQuery();
        closeConnection();
    }

    public static void insertIntoFlight(int flightID, int distance, String origin,
    String destination, double hours, boolean refundable, boolean oneWay, String arrivalTime,
    String departureTime, boolean flexibleDate, int milesDiscount, int psgLimitECON,
    int psgLimitCOMF, int psgLimitPREM, int psgLimitBUSS, int psgLimitFIRST) throws SQLException {
        openConnection();
        String sql = "insert into Ticket values (?, ?, '?', '?', ?, ?, ?, '?', '?', ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, flightID);
        stmt.setInt(2, distance);
        stmt.setString(3, origin);
        stmt.setString(4, destination);
        stmt.setDouble(5, hours);
        stmt.setBoolean(6, refundable);
        stmt.setBoolean(7, oneWay);
        stmt.setString(8, arrivalTime);
        stmt.setString(9, departureTime);
        stmt.setBoolean(8, flexibleDate);
        stmt.setInt(1, milesDiscount);
        stmt.setInt(1, psgLimitECON);
        stmt.setInt(1, psgLimitCOMF);
        stmt.setInt(1, psgLimitPREM);
        stmt.setInt(1, psgLimitBUSS);
        stmt.setInt(1, psgLimitFIRST);
        stmt.executeQuery();
        closeConnection();

        // Implement a function that displays all the data PER TABLE

    }

}
