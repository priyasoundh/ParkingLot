import java.util.List;

public class ParkingFloor {

    private int floorNumber;
    private List<ParkingSpot> spots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpots){
        this.floorNumber = floorNumber;
        this.spots = parkingSpots;
    }

    public List<ParkingSpot> getSpots(){
        return spots;
    }

    public ParkingSpot getFreeSpot(VehicleType type){
        for(ParkingSpot spot: spots){
            if(spot.isFree() && spot.getVehicleType() == type){
                return spot;
            }
        }
        return null;
    }
}
