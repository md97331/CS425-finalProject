#pragma once 
#include <iostream>
#include <string>
#include <time.h>

class passenger {
    private:
        int PsgID;
        std::string firstName;
        std::string lastName;
        std::string password;
        std::string gender;
        std::string DOB;
        std::string passport;
        int age;
        std::string creditCardInfo;
        std::string cellphone;
    public:
        passenger(int PsgID, std::string firstName, std::string lastName, std::string password, std::string gender, std::string DOB,std::string passport,int age, std::string creditCardInfo, std::string cellphone) : PsgID(PsgID), firstName(firstName), lastName(lastName), password(password), gender(gender), DOB(DOB), passport(passport), age(age), creditCardInfo(creditCardInfo), cellphone(cellphone) { 
            std::cout << "Passenger " << firstName+" "+lastName << " was sucessfully created!";
        }

        void printData();

};



