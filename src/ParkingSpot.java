public class ParkingSpot {
    private int spotId;
    private VehicleType vehicleType;
    private boolean isFree;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotId, VehicleType vehicleType){
        this.spotId = spotId;
        this.vehicleType = vehicleType;
        this.isFree =true;
    }

    public boolean isFree(){
        return isFree;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public int getSpotId(){
        return spotId;
    }

    public void park(Vehicle vehicle){
        this.parkedVehicle = vehicle;
        this.isFree = true;
    }

    public void unPark(){
        this.parkedVehicle = null;
        this.isFree = false;
    }
}
