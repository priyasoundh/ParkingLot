import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ParkingLot {

    private Map<String, Ticket> activeTickets = new HashMap<>();
    Map<VehicleType, Queue<ParkingSpot>> availableSpots;
    List<ParkingFloor> floors;

    public ParkingLot(Map<VehicleType, Queue<ParkingSpot>> availableSpots, List<ParkingFloor> floors){
        this.availableSpots = availableSpots;
        this.floors = floors;
    }

    public Ticket parkVehicle(Vehicle vehicle){
        Queue<ParkingSpot> parkingSpots = availableSpots.get(vehicle.getVehicleType());
        if(!parkingSpots.isEmpty()) {
            ParkingSpot spot = parkingSpots.poll();
            spot.park(vehicle);
            Ticket ticket = new Ticket(vehicle, spot);
            activeTickets.put(ticket.getTicketId(), ticket);
            return ticket;
        }
        return null;
    }

    public boolean unpark(String  ticketId){
        if(activeTickets.containsKey(ticketId)) {
            Ticket ticket = activeTickets.get(ticketId);
            ParkingSpot spot = ticket.getParkingSpot();

            spot.unpark();
            LocalDateTime leavingTime = LocalDateTime.now();
            LocalDateTime arrivedAt = ticket.getTime();

            Duration duration = Duration.between(arrivedAt, leavingTime);

            long parkingfee = duration.toHours() * 40;

            activeTickets.remove(ticket.getTicketId());

            Queue<ParkingSpot> parkingspots = availableSpots.get(spot.getVehicleType());
            parkingspots.offer(spot);
            return true;

        }else{
            System.out.println("not an active ticket");
        }
        return false;
    }
}
