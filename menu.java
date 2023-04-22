package cs.mysqlproject.menu;

import java.util.HashMap;
import java.util.Map;

public class menu {

    public Map<Integer, String> initAdminMenu() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Passenger");
        map.put(2, "Flight");
        map.put(3, "Connection");
        map.put(4, "FlightClass");
        map.put(5, "Ticket");
        map.put(6, "Payment");
        map.put(7, "Quit");
        return map;
    }

    public Map<Integer, String> initAdminSubMenu() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "View");
        map.put(2, "Add");
        map.put(3, "Update");
        map.put(4, "Delete");
        map.put(5, "Quit");
        return map;
    }

    public Map<Integer, String> initUserMenu() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Search Flight");
        map.put(2, "Search Passenger");
        map.put(3, "Book Ticket");
        map.put(4, "Quit");
        return map;
    }

//            map.put("A11", "Add Passenger");
//        map.put("A21", "Add Flight");
//        map.put("A31", "Add Connection");
//        map.put("A41", "Add FlightClass");
//        map.put("A51", "Add Ticket");
//        map.put("A61", "Add Payment");
//        map.put("A12", "Edit Passenger");
//        map.put("A22", "Edit Flight");
//        map.put("A32", "Edit Connection");
//        map.put("A42", "Edit FlightClass");
//        map.put("A52", "Edit Ticket");
//        map.put("A62", "Edit Payment");
//        map.put("A13", "Delete Passenger");
//        map.put("A23", "Delete Flight");
//        map.put("A33", "Delete Connection");
//        map.put("A43", "Delete FlightClass");
//        map.put("A53", "Delete Ticket");
//        map.put("A63", "Delete Payment");
//        map.put("A14", "Search Passenger");
//        map.put("A24", "Search Flight");
//        map.put("A34", "Search Connection");
//        map.put("A44", "Search FlightClass");
//        map.put("A54", "Search Ticket");
//        map.put("A64", "Search Payment");
//        map.put("A15", "Quit Passenger");
//        map.put("A25", "Quit Flight");
//        map.put("A35", "Quit Connection");
//        map.put("A45", "Quit FlightClass");
//        map.put("A55", "Quit Ticket");
//        map.put("A65", "Quit Payment");
//        map.put("U1", "Search Flight");
//        map.put("U2", "Search Passenger");
//        map.put("U3", "Book Ticket");
//        map.put("U4", "Quit");
}