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
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established.");
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        } finally {
            closeConnection();
        }
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


}
