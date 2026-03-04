import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {

    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime time;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot){
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.time = LocalDateTime.now();
    }

    public String getTicketId(){
        return ticketId;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }
    public ParkingSpot getParkingSpot(){
        return parkingSpot;
    }

    public LocalDateTime getTime(){
        return time;
    }
}
