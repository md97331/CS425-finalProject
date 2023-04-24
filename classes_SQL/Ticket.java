package classes_SQL;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ticket {

    private int ticketNumber;
    private String classType;
    private int PsgID;
    private String dateOfFlight;
    private double standardPrice;
    private boolean cancelled;

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
    
    public Ticket(int ticketNumber, String classType, int PsgID,
    String dateOfFlight, double standardPrice, boolean cancelled) {
        
        this.ticketNumber = ticketNumber;
        this.classType = classType;
        this.PsgID = PsgID;
        this.dateOfFlight = dateOfFlight;
        this.standardPrice = standardPrice;
        this.cancelled = cancelled;

    }

    public Ticket() {
        this.ticketNumber = 0;
        this.classType = "";
        this.PsgID = 0;
        this.dateOfFlight = "";
        this.standardPrice = 0;
        this.cancelled = false;
    }

    public int getTicketNumber() {
        return this.ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getClassType() {
        return this.classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getPsgID() {
        return this.PsgID;
    }

    public void setPsgID(int PsgID) {
        this.PsgID = PsgID;
    }

    public String getDateOfFlight() {
        return this.dateOfFlight;
    }

    public void setDateOfFlight(String dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public double getStandardPrice() {
        return this.standardPrice;
    }

    public void setStandardPrice(double standardPrice) {
        this.standardPrice = standardPrice;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void printData() {
        System.out.println("==============TICKET INFORMATION==============");
        System.out.printf("%26s %s%n", "-Ticket Number: ", getTicketNumber());
        System.out.printf("%26s %s%n", "-Class Type: ", getClassType());
        System.out.printf("%26s %s%n", "-Passenger ID: ", getPsgID());
        System.out.printf("%26s %s%n", "-Date of Flight: ", getDateOfFlight());
        System.out.printf("%26s %.2f%n", "-Standard Price: $", getStandardPrice());
        System.out.printf("%26s %s%n", "-Cancelled? ", cancelled?"Yes":"No");
        System.out.println("======================END=======================");
    }

}
