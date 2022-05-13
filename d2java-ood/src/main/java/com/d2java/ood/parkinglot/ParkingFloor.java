package com.d2java.ood.parkinglot;

import lombok.Data;

import java.util.Set;

@Data
public class ParkingFloor {

    private Integer floorId;

    private String floorName;

    private Set<ParkingSpot> spots;

    private Set<DisplayBoard> displayBoards;

    void assignSpot(Vehicle vehicle) {
        ParkingSpot spot = this.findFreeSpot(vehicle);
        spot.assign(vehicle);
        this.updateDisplayBoard(spot);
    }

    ParkingSpot findFreeSpot(Vehicle vehicle) {
        return findFreeSpot(vehicle.vehicleType);
    }

    ParkingSpot findFreeSpot(VehicleType vehicleType) {
        return this.spots.stream()
                .filter(spot -> spot.getIsFree() && spot.getVehicleType() == vehicleType)
                .findFirst().orElse(null);
    }

    void updateDisplayBoard(ParkingSpot spot) {
        for (DisplayBoard b : displayBoards) {
            b.checkAndUpdateDisplay(spot);
        }
    }
}
