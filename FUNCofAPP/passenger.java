public class passenger {
    private int PsgID;
    private String FirstName;
    private String LastName;
    private String Password;
    private String Gender;
    private String DOB;
    private String Passport;
    private int Age;
    private String CreditCardInfo;
    private String Cellphone;
   
    public passenger(int psgID, String firstName, String lastName,
     String password, String gender, String dob, String passport,
      int age, String creditCardInfo, String cellphone) {
        PsgID = psgID;
        FirstName = firstName;
        LastName = lastName;
        Password = password;
        Gender = gender;
        DOB = dob;
        Passport = passport;
        Age = age;
        CreditCardInfo = creditCardInfo;
        Cellphone = cellphone;
    }

    public void printData() {
        System.out.print("Passenger: " + FirstName + " " + LastName + 
                         "ID: " + PsgID + 
                         "Genger: " + Gender +
                         "Date of Birth: " + DOB +
                         "Age: " + Age + 
                         "Cellphone number: " + Cellphone);
    }
    
    // The following is for Administrators only

    public void printDataAdmin() {
        System.out.print("Passenger: " + FirstName + " " + LastName + 
                         "ID: " + PsgID + 
                         "Genger: " + Gender +
                         "Date of Birth: " + DOB +
                         "Age: " + Age + 
                         "Cellphone number: " + Cellphone +
                         "Password: " + Password +
                         "Credit Card Info: " + CreditCardInfo +
                         "Passport: " + Passport);
    }

    public void setDetails() {

        int selection = 0;

        while(true) {

            System.out.print("Please Select one of the following\n" +
                                "1. First Name\n" +
                                "2. Last Name\n" +
                                "3. Password\n" +
                                "4. Gender\n" +
                                "5. Cell Phone\n" +
                                "6. Back\n");
            selection = input.nextInt();
            input.nextLine();

            if (input.hasNextInt()) {
            
                if (selection == 6) {
                    break;
                }

                if (selection == 1 || selection == 2 || selection == 3 || selection == 4
                ||selection == 5 || selection == 6)
                {
                    switch(selection) {
                        case 1: 
                            System.out.print("Enter First Name: ");
                            FirstName = input.nextLine();
                            System.out.print("First Name Updated!");
                            break;
                        case 2: 
                            System.out.print("Enter Last Name: ");
                            LastName = input.nextLine();
                            System.out.print("Last Name Updated!");
                            break;
                        case 3: 
                            System.out.print("Enter New Password: ");
                            Password = input.nextLine();
                            System.out.print("Password Updated!");
                            break;
                        case 4: 
                            System.out.print("Enter Gender: ");
                            Gender = input.nextLine();
                            System.out.print("Gender Updated!");
                            break;
                        case 5: 
                            System.out.print("Enter Cell Phone: ");
                            Cellphone = input.nextLine();
                            System.out.print("Cell Phone Updated!");
                            break;

                    }   // End of case switch
                }

                else {
                    System.out.print("Selection outside of range, please try again");
                }
            } // End of If Has Next Integer

            else {
                System.out.print("Invalid Entry, please try again");
            }

        } // End of While Loop

    } // End of setDetails()

} // End of Class