public class ParkingSpot {
    int spotId;
    VehicleType vehicleType;
    Boolean isFree;

    public Boolean isFree(){
        return isFree;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public int getSpotId(){
        return spotId;
    }

    public void setOccupied(){
        this.isFree = false;
    }

    public void setFree(){
        this.isFree = true;
    }
}
