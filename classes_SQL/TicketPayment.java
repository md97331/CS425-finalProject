package classes_SQL;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TicketPayment {

    private int ticketNumber;
    private String classType;
    private int PsgID;
    private String dateOfFlight;
    private double standardPrice;
    private boolean cancelled;
    private int confirmationID;
    private String paymentInfo;
    private int eCredits;
    private int deltaGIftCard;

    public TicketPayment(int ticketNumber, String classType, int PsgID,
        String dateOfFlight, double standardPrice, boolean cancelled, int confirmationID, String paymentInfo,
        int eCredits, int deltaGIftCard) {
        
            this.ticketNumber = ticketNumber;
            this.classType = classType;
            this.PsgID = PsgID;
            this.dateOfFlight = dateOfFlight;
            this.standardPrice = standardPrice;
            this.cancelled = cancelled;
            this.confirmationID = confirmationID;
            this.paymentInfo = paymentInfo;
            this.eCredits = eCredits;
            this.deltaGIftCard = deltaGIftCard;

        }
    
    public TicketPayment() {
        this.ticketNumber = 0;
        this.classType = "";
        this.PsgID = 0;
        this.dateOfFlight = "";
        this.standardPrice = 0;
        this.cancelled = false;
        this.confirmationID = 0;
        this.paymentInfo = "";
        this.eCredits = 0;
        this.deltaGIftCard = 0;
    }

    public void printData() {
        if (ticketNumber==-1){
            System.out.println("Ticket not found!\n");
            return;
        }
        System.out.println("\n==============TICKET INFORMATION==============");
        System.out.printf("%26s %s%n", "-Ticket Number: ", getTicketNumber());
        System.out.printf("%26s %s%n", "-Class Type: ", getClassType());
        System.out.printf("%26s %s%n", "-Passenger ID: ", getPsgID());
        System.out.printf("%26s %s%n", "-Date of Flight: ", getDateOfFlight());
        System.out.printf("%26s %.2f%n", "-Standard Price: $", getStandardPrice());
        System.out.printf("%26s %s%n", "-Cancelled? ", cancelled?"Yes":"No");
        System.out.printf("%26s %s%n", "-Confirmation ID: ", getConfirmationID());
        System.out.printf("%26s %s%n", "-Payment Information: ", getPaymentInfo());
        System.out.printf("%26s %s%n", "-eCredits: ", getECredits());
        System.out.printf("%26s %s%n", "-Delta Gift Card: ", getDeltaGIftCard());
        System.out.println("======================END=======================");
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

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public int getConfirmationID() {
        return this.confirmationID;
    }

    public void setConfirmationID(int confirmationID) {
        this.confirmationID = confirmationID;
    }

    public String getPaymentInfo() {
        return this.paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public int getECredits() {
        return this.eCredits;
    }

    public void setECredits(int eCredits) {
        this.eCredits = eCredits;
    }

    public int getDeltaGIftCard() {
        return this.deltaGIftCard;
    }

    public void setDeltaGIftCard(int deltaGIftCard) {
        this.deltaGIftCard = deltaGIftCard;
    }
    
}
