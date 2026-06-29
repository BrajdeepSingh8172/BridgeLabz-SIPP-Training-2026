import java.util.ArrayList;

public class SmartParkingManager {
    private ArrayList<String> parkedVehicles = new ArrayList<>();

    public void enterParking(String registrationNumber) {
        if (parkedVehicles.contains(registrationNumber)) {
            System.out.println("Vehicle " + registrationNumber + " is already inside the parking area.");
        } else {
            parkedVehicles.add(registrationNumber);
            System.out.println("Vehicle " + registrationNumber + " entered successfully.");
        }
    }

    public void exitParking(String registrationNumber) {
        if (parkedVehicles.remove(registrationNumber)) {
            System.out.println("Vehicle " + registrationNumber + " exited successfully.");
        } else {
            System.out.println("Vehicle " + registrationNumber + " was not found in the parking area.");
        }
    }

    public boolean isVehicleParked(String registrationNumber) {
        return parkedVehicles.contains(registrationNumber);
    }

    public void displayParkedVehicles() {
        System.out.println("--- Parked Vehicles ---");
        for (String vehicle : parkedVehicles) {
            System.out.println(vehicle);
        }
        System.out.println("Total Occupied Slots: " + parkedVehicles.size());
    }

    public static void main(String[] args) {
        SmartParkingManager manager = new SmartParkingManager();
        manager.enterParking("KA-01-AB-1234");
        manager.enterParking("DL-03-CD-5678");
        manager.enterParking("MH-12-EF-9012");

        System.out.println();
        manager.displayParkedVehicles();

        System.out.println("\nSearching for DL-03-CD-5678: " + manager.isVehicleParked("DL-03-CD-5678"));

        System.out.println();
        manager.exitParking("DL-03-CD-5678");

        System.out.println();
        manager.displayParkedVehicles();
    }
}