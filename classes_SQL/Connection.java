package classes_SQL;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Connection {

    private int connectionID;
    private int flightID;
    private String arrivalTime;
    private String departureTime;
    private String airportConncetion;

    public Connection(int connectionID, int flightID, String arrivalTime,
        String departureTime, String airportConncetion) {
            
            this.connectionID = connectionID;
            this.flightID = flightID;
            this.arrivalTime = arrivalTime;
            this.departureTime = departureTime;
            this.airportConncetion = airportConncetion;

        }

    public Connection() {
        connectionID = 0;
        flightID = 0;
        arrivalTime = "";
        departureTime = "";
        airportConncetion = "";
    }

    public void printData() {

        System.out.println("==============CONNECTION INFORMATION==============");
        System.out.printf("%26s %s%n", "-Connection ID: ", getConnectionID());
        System.out.printf("%26s %s%n", "-Flight ID: ", getFlightID());
        System.out.printf("%26s %s%n", "-Arrival Time: ", getArrivalTime());
        System.out.printf("%26s %s%n", "-Departure Time: ", getDepartureTime());
        System.out.printf("%26s %s%n", "-Airport Connection: ", getAirportConncetion());
        System.out.println("======================END=======================");
    }

    public int getConnectionID() {
        return this.connectionID;
    }

    public void setConnectionID(int connectionID) {
        this.connectionID = connectionID;
    }

    public int getFlightID() {
        return this.flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getAirportConncetion() {
        return this.airportConncetion;
    }

    public void setAirportConncetion(String airportConncetion) {
        this.airportConncetion = airportConncetion;
    }

}
