package de.hsd.inflab.parkinggarage.parking.gate.impl;

import de.hsd.inflab.parkinggarage.models.ticket.Ticket;
import de.hsd.inflab.parkinggarage.models.vehicles.VehicleTypes;
import de.hsd.inflab.parkinggarage.parking.gate.iface.Entrance;

import java.time.LocalDateTime;

public class EntranceGate implements Entrance {

    public Ticket processIncoming(boolean isFull, double occupancy, VehicleTypes vehicleType){
        return Ticket.issue(LocalDateTime.of(2026, 10, 6, 12, 0));
    }


}
