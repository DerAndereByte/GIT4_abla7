package de.hsd.inflab.parkinggarage.parking.gate.iface;

import de.hsd.inflab.parkinggarage.models.Receipt;
import de.hsd.inflab.parkinggarage.models.ticket.Ticket;
import de.hsd.inflab.parkinggarage.models.vehicles.Vehicle;
import de.hsd.inflab.parkinggarage.models.vehicles.VehicleTypes;

import java.time.Duration;
import java.time.LocalDateTime;

public interface Exit {
    public Receipt processOutgoing(); //Duration parkDuration, VehicleTypes vehicleType
}
