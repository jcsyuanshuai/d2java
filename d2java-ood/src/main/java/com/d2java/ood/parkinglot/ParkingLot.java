package com.d2java.ood.parkinglot;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
public class ParkingLot {

    private Set<ParkingFloor> parkingFloors;

    private Map<String, Integer> maxSpotCount = Maps.newConcurrentMap();

    private Map<String, Ticket> activeTickets = Maps.newConcurrentMap();


}
