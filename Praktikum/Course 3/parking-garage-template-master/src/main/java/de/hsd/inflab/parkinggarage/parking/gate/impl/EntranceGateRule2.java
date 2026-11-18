package de.hsd.inflab.parkinggarage.parking.gate.impl;

import de.hsd.inflab.parkinggarage.models.ticket.Ticket;
import de.hsd.inflab.parkinggarage.models.vehicles.VehicleTypes;
import de.hsd.inflab.parkinggarage.parking.gate.iface.Entrance;

import java.time.LocalDateTime;

public class EntranceGateRule2 implements Entrance {

    public Ticket processIncoming(boolean isFull, double occupancy, VehicleTypes vehicleType){
        if(isFull == true || (occupancy >= 0.8 && vehicleType == VehicleTypes.SEMI)) {
            return Ticket.denyEntry("Parkhaus voll");
        }
        else {
            return Ticket.issue(LocalDateTime.of(2026, 10, 6, 12, 0));
        }
    }


}
