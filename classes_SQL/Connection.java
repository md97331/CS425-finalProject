package classes_SQL;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Connection {

    private int connectionID;
    private int flightID;
    private String cArrivalTime;
    private String cDepartureTime;
    private String airportConnection;

    public Connection(int connectionID, int flightID, String cArrivalTime,
        String cDepartureTime, String airportConnection) {
            
            this.connectionID = connectionID;
            this.flightID = flightID;
            this.cArrivalTime = cArrivalTime;
            this.cDepartureTime = cDepartureTime;
            this.airportConnection = airportConnection;

        }

    public Connection() {
        this.connectionID = 0;
        this.flightID = 0;
        this.cArrivalTime = "";
        this.cDepartureTime = "";
        this.airportConnection = "";
    }

    public void printData() {

        System.out.println("==============CONNECTION INFORMATION==============");
        System.out.printf("%26s %s%n", "-Connection ID: ", getConnectionID());
        System.out.printf("%26s %s%n", "-Flight ID: ", getFlightID());
        System.out.printf("%26s %s%n", "-Arrival Time: ", getcArrivalTime());
        System.out.printf("%26s %s%n", "-Departure Time: ", getcDepartureTime());
        System.out.printf("%26s %s%n", "-Airport Connection: ", getAirportConnection());
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

    public String getcArrivalTime() {
        return this.cArrivalTime;
    }

    public void setArrivalTime(String cArrivalTime) {
        this.cArrivalTime = cArrivalTime;
    }

    public String getcDepartureTime() {
        return this.cDepartureTime;
    }

    public void setcDepartureTime(String cDepartureTime) {
        this.cDepartureTime = cDepartureTime;
    }

    public String getAirportConnection() {
        return this.airportConnection;
    }

    public void setAirportConnection(String airportConnection) {
        this.airportConnection = airportConnection;
    }

}
