import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private Map<String, Ticket> activeTickets = new HashMap<>();

    private List<ParkingFloor> floors;

    public ParkingLot(List<ParkingFloor> floors){
        this.floors = floors;
    }

    public Ticket parkVehicle(Vehicle vehicle){
        for(ParkingFloor floor: floors){
            ParkingSpot spot= floor.getFreeSpot(vehicle.getVehicleType());
            if(spot!=null){
                spot.park(vehicle);
                Ticket ticket = new Ticket(vehicle, spot);
                activeTickets.put(ticket.getTicketId(), ticket);
                return ticket;
            }
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
            return true;

        }else{
            System.out.println("not an active ticket");
        }
        return false;
    }
}
