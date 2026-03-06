import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<ParkingSpot> spots = new ArrayList<>();

        ParkingSpot spot1 = new ParkingSpot(1, VehicleType.CAR);
        ParkingSpot spot2 = new ParkingSpot(2, VehicleType.CAR);
        ParkingSpot spot3 = new ParkingSpot(3, VehicleType.CAR);
        ParkingSpot spot4 = new ParkingSpot(4, VehicleType.BIKE);
        ParkingSpot spot5 = new ParkingSpot(5, VehicleType.BIKE);

        spots.add(spot1);
        spots.add(spot2);
        spots.add(spot4);

        ParkingFloor floor1 = new ParkingFloor(1, spots);

        List<ParkingSpot> spots1 = new ArrayList<>();

        spots1.add(spot3);
        spots1.add(spot5);
        ParkingFloor floor2 = new ParkingFloor(2, spots1);

        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(floor1);
        floors.add(floor2);

        Map<VehicleType, Queue<ParkingSpot>> availableSpots = new HashMap<>();
        Queue<ParkingSpot> parkingSpots = new LinkedList<>();
        parkingSpots.offer(spot1);
        parkingSpots.offer(spot2);
        parkingSpots.offer(spot3);

        availableSpots.put(VehicleType.CAR, parkingSpots);

        Queue<ParkingSpot> parkingSpots2 = new LinkedList<>();
        parkingSpots2.offer(spot4);
        parkingSpots2.offer(spot5);

        availableSpots.put(VehicleType.BIKE, parkingSpots2);

        ParkingLot parkingLot = new ParkingLot(availableSpots, floors);

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