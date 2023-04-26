package classes_SQL;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Flight {
    private int FlightID;
    private int Distance;
    private String Origin;
    private String Destination;
    private double Hours;
    private boolean Refundable;
    private boolean OneWay;
    private String ArrivalTime;
    private String DepartureTime;
    private boolean FlexibleDate;
    private int MilesDiscount;
    private int PsgLimitECON;
    private int PsgLimitCOMF;
    private int PsgLimitPREM;
    private int PsgLimitBUSS;
    private int PsgLimitFIRST;

    public Flight(int FlightID, int Distance, String Origin,
                  String Destination, double Hours, boolean Refundable, boolean OneWay, String ArrivalTime,
                  String DepartureTime, boolean FlexibleDate, int MilesDiscount, int PsgLimitECON,
                  int PsgLimitCOMF, int PsgLimitPREM, int PsgLimitBUSS, int PsgLimitFIRST) {
        this.FlightID = FlightID;
        this.Distance = Distance;
        this.Origin = Origin;
        this.Destination = Destination;
        this.Hours = Hours;
        this.Refundable = Refundable;
        this.OneWay = OneWay;
        this.ArrivalTime = ArrivalTime;
        this.DepartureTime = DepartureTime;
        this.FlexibleDate = FlexibleDate;
        this.MilesDiscount = MilesDiscount;
        this.PsgLimitECON = PsgLimitECON;
        this.PsgLimitCOMF = PsgLimitCOMF;
        this.PsgLimitPREM = PsgLimitPREM;
        this.PsgLimitBUSS = PsgLimitBUSS;
        this.PsgLimitFIRST = PsgLimitFIRST;
    }
    public Flight(int flightID){
        this.FlightID = flightID;
    }

    public Flight() {
        this.FlightID = 0;
        this.Distance = 0;
        this.Origin = "";
        this.Destination = "";
        this.Hours = 0;
        this.Refundable = false;
        this.OneWay = false;
        this.ArrivalTime = "";
        this.DepartureTime = "";
        this.FlexibleDate = false;
        this.MilesDiscount = 0;
        this.PsgLimitECON = 0;
        this.PsgLimitCOMF = 0;
        this.PsgLimitPREM = 0;
        this.PsgLimitBUSS = 0;
        this.PsgLimitFIRST = 0;
    }

    public void printData() {
        if (FlightID==-1){
            System.out.println("Flight not found!\n");
            return;
        }
        System.out.println("\n==============FLIGHT INFORMATION==============");
        System.out.printf("%26s %s%n", "-Flight ID: ", getFlightID());
        System.out.printf("%26s %s%n", "-Distance (in miles): ", getDistance());
        System.out.printf("%26s %s%n", "-Origin: ", getOrigin());
        System.out.printf("%26s %s%n", "-Destination: ", getDestination());
        System.out.printf("%26s %s%n", "-Hours: ", getHours());
        System.out.printf("%26s %s%n", "-Refundable? ", Refundable?"Yes":"No");
        System.out.printf("%26s %s%n", "-One Way? ", OneWay?"Yes":"No");
        System.out.printf("%26s %s%n", "-Arrival Time: ", getArrivalTime());
        System.out.printf("%26s %s%n", "-Departure Time: ", getDepartureTime());
        System.out.printf("%26s %s%n", "-Flexible Date? ", FlexibleDate?"Yes":"No");
        System.out.printf("%26s %s%n", "-Miles Discounted: ", getMilesDiscount());
        System.out.printf("%26s %s%n", "-Economy Seat Limit: ", getPsgLimitECON());
        System.out.printf("%26s %s%n", "-Comfort Seat Limit: ", getPsgLimitCOMF());
        System.out.printf("%26s %s%n", "-Premium Seat Limit: ", getPsgLimitPREM());
        System.out.printf("%26s %s%n", "-Bussiness SeatLimit: ", getPsgLimitBUSS());
        System.out.printf("%26s %s%n", "-First Class Seat Limit: ", getPsgLimitFIRST());
        System.out.println("======================END=======================");
    }

    public int getFlightID() {
        return this.FlightID;
    }

    public void setFlightID(int FlightID) {
        this.FlightID = FlightID;
    }

    public int getDistance() {
        return this.Distance;
    }

    public void setDistance(int Distance) {
        this.Distance = Distance;
    }

    public String getOrigin() {
        return this.Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public String getDestination() {
        return this.Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public double getHours() {
        return this.Hours;
    }

    public void setHours(double Hours) {
        this.Hours = Hours;
    }

    public boolean isRefundable() {
        return this.Refundable;
    }

    public void setRefundable(boolean Refundable) {
        this.Refundable = Refundable;
    }

    public boolean isOneWay() {
        return this.OneWay;
    }

    public void setOneWay(boolean OneWay) {
        this.OneWay = OneWay;
    }

    public String getArrivalTime() {
        return this.ArrivalTime;
    }

    public void setArrivalTime(String ArrivalTime) {
        this.ArrivalTime = ArrivalTime;
    }

    public String getDepartureTime() {
        return this.DepartureTime;
    }

    public void setDepartureTime(String DepartureTime) {
        this.DepartureTime = DepartureTime;
    }

    public boolean isFlexibleDate() {
        return this.FlexibleDate;
    }

    public void setFlexibleDate(boolean FlexibleDate) {
        this.FlexibleDate = FlexibleDate;
    }

    public int getMilesDiscount() {
        return this.MilesDiscount;
    }

    public void setMilesDiscount(int MilesDiscount) {
        this.MilesDiscount = MilesDiscount;
    }

    public int getPsgLimitECON() {
        return this.PsgLimitECON;
    }

    public void setPsgLimitECON(int PsgLimitECON) {
        this.PsgLimitECON = PsgLimitECON;
    }

    public int getPsgLimitCOMF() {
        return this.PsgLimitCOMF;
    }

    public void setPsgLimitCOMF(int PsgLimitCOMF) {
        this.PsgLimitCOMF = PsgLimitCOMF;
    }

    public int getPsgLimitPREM() {
        return this.PsgLimitPREM;
    }

    public void setPsgLimitPREM(int PsgLimitPREM) {
        this.PsgLimitPREM = PsgLimitPREM;
    }

    public int getPsgLimitBUSS() {
        return this.PsgLimitBUSS;
    }

    public void setPsgLimitBUSS(int PsgLimitBUSS) {
        this.PsgLimitBUSS = PsgLimitBUSS;
    }

    public int getPsgLimitFIRST() {
        return this.PsgLimitFIRST;
    }

    public void setPsgLimitFIRST(int PsgLimitFIRST) {
        this.PsgLimitFIRST = PsgLimitFIRST;
    }


}
