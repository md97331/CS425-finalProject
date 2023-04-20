#include "passenger.h"

void passenger::printData() {
    std::cout << "\nPassenger Name: " << firstName << " " << lastName << "\nGender: " << gender << "\tAge: " << age << "\n";
    std::cout << "Cellphone: "<< cellphone << "\tPassport: " << passport;
}