package classes_SQL;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Passenger Ticket class
 */
public class PassengerTicket {
    private int PsgID;
    private String firstName;
    private String lastName;
    private String password;
    private String gender;
    private String DOB;
    private String passport;
    private int age;
    private String creditCardInfo;
    private String cellphone;
    private int ticketNumber;
    private String classType;
    private String dateOfFlight;
    private double standardPrice;
    private boolean cancelled;

    public PassengerTicket (int psgID, String firstName, String lastName, String password,
    String gender, String DOB, String passport, int age, String creditCardInfo,
    String cellphone, int ticketNumber, String classType,
    String dateOfFlight, double standardPrice, boolean cancelled) {

        this.PsgID = psgID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.gender = gender;
        this.DOB = DOB;
        while (passport.length() < 9) {
            System.out.println("Attention!: The passport must be 9 numbers in the format \"XXXXXXXXX\"");
            Scanner scanner = new Scanner(System.in);
            passport = scanner.nextLine();
        }
        this.passport = passport;
        this.age = age;
        this.creditCardInfo = creditCardInfo;
        this.cellphone = cellphone;
        this.ticketNumber = ticketNumber;
        this.classType = classType;
        this.dateOfFlight = dateOfFlight;
        this.standardPrice = standardPrice;
        this.cancelled = cancelled;

    }

    public PassengerTicket() {
        this.PsgID = 0;
        this.firstName = "";
        this.lastName = "";
        this.password = "";
        this.gender = "";
        this.DOB = "";
        this.passport = "";
        this.age = 0;
        this.creditCardInfo = "";
        this.cellphone = "";
        this.ticketNumber = 0;
        this.classType = "";
        this.PsgID = 0;
        this.dateOfFlight = "";
        this.standardPrice = 0;
        this.cancelled = false;
    }
	public PassengerTicket(int PsgID){
		this.PsgID = PsgID;
	}

    public int getPsgID() {
        return PsgID;
    }

    public void setPsgID(int psgID) {
        PsgID = psgID;
    }

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDOB() {
		return this.DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCreditCardInfo() {
		return this.creditCardInfo;
	}

	public void setCreditCardInfo(String creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
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

	public void printData() {
		if (PsgID == -1) {
			System.out.println("Ticket not found!\n");
			return;
		}
    	System.out.println("\n============== TICKET PASSENGER INFORMATION ==============");
        System.out.printf("%26s %s%n", "-Passenger ID: ", getPsgID());
        System.out.printf("%26s %s%n", "-First Name: ", getFirstName());
        System.out.printf("%26s %s%n", "-Last Name: ", getLastName());
        System.out.printf("%26s %s%n", "-Gender: ", getGender());
        System.out.printf("%26s %s%n", "-Age: ", getAge());
        System.out.printf("%26s %s%n", "-Passport: ", "****" + (getPassport().substring(4)));
        System.out.printf("%26s %s%n", "-Cellphone: ", "(***)***-" + (getCellphone().substring(6)));
        System.out.printf("%26s %s%n", "-Credit Card Information: ", "************" + getCreditCardInfo());
        System.out.printf("%26s %s%n", "-Ticket Number: ", getTicketNumber());
        System.out.printf("%26s %s%n", "-Class Type: ", getClassType());
        System.out.printf("%26s %s%n", "-Date of Flight: ", getDateOfFlight());
        System.out.printf("%26s %.2f%n", "-Standard Price: $", getStandardPrice());
        System.out.printf("%26s %s%n", "-Cancelled? ", cancelled?"Yes":"No");
        System.out.println("======================END=======================");
	}
}