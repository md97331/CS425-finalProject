package classes_SQL;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * passenger class
 */
public class Passenger {
  
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

    public Passenger(int psgID, String firstName, String lastName, String password, String gender, String DOB, String passport, int age, String creditCardInfo, String cellphone) {
        this.PsgID = psgID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.gender = gender;
        this.DOB = DOB;
        while (passport.length() >= 11) {
            System.out.println("Attention!: The passport must be 9 numbers in the format \"XXXXXXXXX\"");
            Scanner scanner = new Scanner(System.in);
            passport = scanner.nextLine();
        }
        this.passport = passport;
        this.age = age;
        this.creditCardInfo = creditCardInfo;
        this.cellphone = cellphone;
    }

    public Passenger() {
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
    }

    public int getPsgID() {
        return PsgID;
    }

    public void setPsgID(int psgID) {
        PsgID = psgID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(String creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void printData(){
        if (PsgID == -1 || passport.equals("error")) {
            System.out.println("Passenger not found!\n");
            return;
        }
        System.out.println("\n==============PASSENGER INFORMATION==============");
        System.out.printf("%26s %s%n", "-Passenger ID: ", getPsgID());
        System.out.printf("%26s %s%n", "-First Name: ", getFirstName());
        System.out.printf("%26s %s%n", "-Last Name: ", getLastName());
        System.out.printf("%26s %s%n", "-Gender: ", getGender());
        System.out.printf("%26s %s%n", "-Age: ", getAge());
        System.out.printf("%26s %s%n", "-Passport: ", "****" + (getPassport().substring(4)));
        System.out.printf("%26s %s%n", "-Cellphone: ", "(***)***-" + (getCellphone().substring(6)));
        System.out.printf("%26s %s%n", "-Credit Card Information: ", "************" + getCreditCardInfo());
        System.out.println("======================END=======================");

    }
}