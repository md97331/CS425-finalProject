package classes_SQL;

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

    public Flight(int flightID, int distance, String origin,
                  String destination, double hours, boolean refundable, boolean oneWay, String arrivalTime,
                  String departureTime, boolean flexibleDate, int milesDiscount, int psgLimitECON,
                  int psgLimitCOMF, int psgLimitPREM, int psgLimitBUSS, int psgLimitFIRST) {
        FlightID = flightID;
        Distance = distance;
        Origin = origin;
        Destination = destination;
        Hours = hours;
        Refundable = refundable;
        OneWay = oneWay;
        ArrivalTime = arrivalTime;
        DepartureTime = departureTime;
        FlexibleDate = flexibleDate;
        MilesDiscount = milesDiscount;
        PsgLimitECON = psgLimitECON;
        PsgLimitCOMF = psgLimitCOMF;
        PsgLimitPREM = psgLimitPREM;
        PsgLimitBUSS = psgLimitBUSS;
        PsgLimitFIRST = psgLimitFIRST;
    }
}
