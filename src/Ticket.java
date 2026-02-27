import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ticket {

    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime time;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot){
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.time = LocalDateTime.now();
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
