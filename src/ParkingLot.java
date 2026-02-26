import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class ParkingLot {

    private List<ParkingFloor> floors;


    public Ticket parkVehicle(Vehicle vehicle){
        for(ParkingFloor floor: floors){
            ParkingSpot spot= floor.getFreeSpot(vehicle.getVehicleType());
            if(spot!=null){
                spot.setOccupied();
                Ticket ticket = new Ticket(vehicle, spot);
                return ticket;
            }
        }
        return null;
    }

    public Boolean unPark(Ticket ticket){
        ParkingSpot spot = ticket.getParkingSpot();
        if(!spot.isFree()){
            spot.setFree();
            LocalDateTime leavingTime = LocalDateTime.now();
            LocalDateTime arrivedAt = ticket.getTime();

            Duration duration = Duration.between(arrivedAt, leavingTime);

            long parkingfee = duration.toHours() * 40;
            return true;
        }
        return false;
    }
}
