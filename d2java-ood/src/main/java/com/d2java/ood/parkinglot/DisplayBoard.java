package com.d2java.ood.parkinglot;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

public interface DisplayBoard {
    void display();

    void checkAndUpdateDisplay(ParkingSpot spot);
}


@Data
@Slf4j
class LotDisplayBoard implements DisplayBoard {

    private Integer availableSpotCountOfLarge;
    private Integer availableSpotCountOfCompact;
    private Integer availableSpotCountOfMotorbike;

    private Integer SpotCountOfLarge;
    private Integer SpotCountOfCompact;
    private Integer SpotCountOfMotorbike;

    @Override
    public void display() {

    }

    @Override
    public void checkAndUpdateDisplay(ParkingSpot spot) {

    }

}

@Data
@Slf4j
class FreeSpotOfLargeDisplayBoard implements DisplayBoard {

    private ParkingSpot spot;

    private VehicleType vehicleType;

    @Override
    public void display() {

    }

    @Override
    public void checkAndUpdateDisplay(ParkingSpot spot) {
        if (this.spot.getSpotNo().equals(spot.getSpotNo())) {
            this.spot = spot;
        }
    }
}



