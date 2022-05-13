package com.d2java.ood.parkinglot;


public abstract class Vehicle {

    String vehicleNo;

    VehicleType vehicleType;

    Ticket ticket;

    //public abstract ParkingSpot findFreeParkingSpot(Set<ParkingSpot> spots);

}

enum VehicleType {
    Motorbike, Car, Van
}

class Car extends Vehicle {
}

class Motorbike extends Vehicle {
}

class Van extends Vehicle {

}
