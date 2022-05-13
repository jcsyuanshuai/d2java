package com.d2java.ood.parkinglot;

public abstract class Account {

    String Email;
    String Password;
    String Username;


    void login() {

    }

    void logout() {

    }

}

class Admin extends Account {
    void enableParkingFloor(ParkingFloor floor) {

    }

    void disableParkingFloor(ParkingFloor floor) {

    }

    void enableParkingSpot(ParkingFloor floor, ParkingSpot spot) {

    }

    void disableParkingSpot(ParkingFloor floor, ParkingSpot spot) {

    }
}
