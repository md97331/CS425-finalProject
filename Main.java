import classesSQL.*;
import funcHelpers.*;


public class Main {
    public static void main(String[] args) {
        Passenger testPassenger = new Passenger(1023,"Carlos","Dominguez","PASSWORD","Masculine","10-08-2003","192382726",21,"9021","9015521726");
        testPassenger.printData();
        Menu options = new Menu();

        options.initAdminMenu();
        Menu.displayAdminSubMenu();

    }
}
