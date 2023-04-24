package classes_SQL;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Payment {
    private int ticketNumber;
    private int confirmationID;
    private String paymentInfo;
    private int eCredits;
    private int deltaGIftCard;

    public Payment(int ticketNumber, int confirmationID, String paymentInfo,
    int eCredits, int deltaGIftCard) {
        this.ticketNumber = ticketNumber;
        this.confirmationID = confirmationID;
        this.paymentInfo = paymentInfo;
        this.eCredits = eCredits;
        this.deltaGIftCard = deltaGIftCard;
    }

    public Payment() {
        this.ticketNumber = 0;
        this.confirmationID = 0;
        this.paymentInfo = "";
        this.eCredits = 0;
        this.deltaGIftCard = 0;
    }

    public int getTicketNumber() {
        return this.ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
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

    public void printData() {
        System.out.println("==============PAYMENT INFORMATION==============");
        System.out.printf("%26s %s%n", "-Ticket Number: ", getTicketNumber());
        System.out.printf("%26s %s%n", "-Confirmation ID: ", getConfirmationID());
        System.out.printf("%26s %s%n", "-Payment Information: ", getPaymentInfo());
        System.out.printf("%26s %s%n", "-eCredits: ", getECredits());
        System.out.printf("%26s %s%n", "-Delta Gift Card: ", getDeltaGIftCard());
        System.out.println("======================END=======================");
    }

}
