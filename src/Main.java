import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<ParkingSpot> spots = new ArrayList<>();

        spots.add(new ParkingSpot(1, VehicleType.CAR));
        spots.add(new ParkingSpot(2, VehicleType.CAR));
        spots.add(new ParkingSpot(3, VehicleType.BIKE));

        ParkingFloor floor1 = new ParkingFloor(1, spots);

        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(floor1);

        ParkingLot parkingLot = new ParkingLot(floors);

        Vehicle car1 = new Vehicle("TN01AB1234", VehicleType.CAR);

        Ticket ticket1 = parkingLot.parkVehicle(car1);

        if(ticket1 != null) {
            System.out.println("Vehicle parked. Ticket ID: " + ticket1.getTicketId());
        }

        Vehicle car2 = new Vehicle("TN01AB1238", VehicleType.CAR);

        Ticket ticket2 = parkingLot.parkVehicle(car2);

        if(ticket2 != null) {
            System.out.println("Vehicle parked. Ticket ID: " + ticket2.getTicketId());
        }

        Vehicle car3 = new Vehicle("TN01AB1248", VehicleType.CAR);

        Ticket ticket3 = parkingLot.parkVehicle(car3);

        if(ticket3 != null) {
            System.out.println("Vehicle parked. Ticket ID: " + ticket3.getTicketId());
        } else{
            System.out.println("not able to park: "+ car3.getVehicleNo());
        }

        boolean result = parkingLot.unpark(ticket1.getTicketId());
        System.out.println("Unpark successful: " + result);

        boolean result2 = parkingLot.unpark(ticket1.getTicketId());
        System.out.println("Unpark successful: " + result2);

        Ticket ticket4 = parkingLot.parkVehicle(car3);

        if(ticket4 != null) {
            System.out.println("Vehicle parked. Ticket ID: " + ticket4.getTicketId());
        } else{
            System.out.println("not able to park: "+ car3.getVehicleNo());
        }



    }
}