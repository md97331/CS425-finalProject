create DATABASE AIRLINE_DATABASE;
use AIRLINE_DATABASE;

create table classFlight(
    classType VARCHAR(20), 
    upgradeCost INT,
    PRIMARY KEY (classType)
    );

create table flight (
    flightID INT, 
    distance INT,
    origin VARCHAR(32),
    destination VARCHAR(32), 
    hours DOUBLE,
    refundable BOOLEAN, 
    oneWay BOOLEAN,
    arrivalTime TIME, 
    departureTime TIME, 
    flexibleDate BOOLEAN, 
    milesDiscount INT,
    psgLimitECON INT,
    psgLimitCOMF INT,
    psgLimitPREM INT,
    psgLimitBUSS INT,
    psgLimitFIRST INT,
    PRIMARY KEY (flightID)
    );

create table passenger (
    PsgID INT, 
    flightID INT , 
    firstName VARCHAR(25) NOT NULL, 
    lastName VARCHAR(25) NOT NULL, 
    pwd VARCHAR (25) NOT NULL, 
    gender VARCHAR(18) NOT NULL, 
    DOB DATE NOT NULL, 
    passport VARCHAR(10) NOT NULL, 
    age TINYINT, 
    creditCardInfo INT, 
    cellPhone VARCHAR(10),
    PRIMARY KEY (PsgID),
    FOREIGN KEY (flightID) REFERENCES Flight(flightID)
    );

create table ticket (
    ticketNumber INT,
    classType VARCHAR(20),
    PsgID INT,
    dateOfFlight DATE,
    standardPrice DECIMAL(10,2),
    cancelled BOOLEAN,
    PRIMARY KEY (ticketNumber), 
    FOREIGN KEY (PsgID) REFERENCES Passenger(PsgID),
    FOREIGN KEY (classType) REFERENCES ClassFlight(classType)
    );

create table payment(
    ticketNumber INT, 
    confirmationID INT,
    paymentInfo VARCHAR(20) NOT NULL, 
    eCredits INT, 
    deltaGiftCard INT,
    PRIMARY KEY (confirmationID),
    FOREIGN KEY (ticketNumber) REFERENCES Ticket(ticketNumber)
);

create table connection (
    ConnectionID INT,
    flightID INT,
    cArrivalTime TIME,
    cDepartureTime TIME,
    airportConection varchar (32),
    PRIMARY KEY (ConnectionID), 
    FOREIGN KEY (flightID) REFERENCES Flight(flightID)
    );

Create Table `Admin`(
    UserID varchar(45),
    password varchar(45),
    primary key (UserID)
);

insert into Admin values
    ("Mvilcapaza", "mvilca5210"),
    ("Jvelazquez", "abc123"),
    ("JustJerry", "jerry123");
