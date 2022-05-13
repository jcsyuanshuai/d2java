package com.d2java.ood.parkinglot;

import lombok.Data;

@Data
public class ParkingSpot {

    private String spotNo;

    private Boolean isFree;

    private Vehicle vehicle;

    private VehicleType vehicleType;


    public void assign(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isFree = false;
    }

    public void remove(Vehicle vehicle) {
        this.vehicle = null;
        this.isFree = true;
    }

}

enum ParkingSpotType {

}
