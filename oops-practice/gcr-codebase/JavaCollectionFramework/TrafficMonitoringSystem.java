import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TrafficMonitoringSystem {
    private HashMap<String, Integer> rawTrafficData = new HashMap<>();

    public void updateVehicleCount(String roadName, int vehicleCount) {
        rawTrafficData.put(roadName, rawTrafficData.getOrDefault(roadName, 0) + vehicleCount);
        System.out.println("Updated " + roadName + " with +" + vehicleCount + " vehicles.");
    }

    public void displaySortedTraffic() {
        TreeMap<String, Integer> sortedTrafficData = new TreeMap<>(rawTrafficData);
        System.out.println("\n--- Road Traffic Statistics (Sorted Alphabetically) ---");
        for (Map.Entry<String, Integer> entry : sortedTrafficData.entrySet()) {
            System.out.println("Road: " + entry.getKey() + " | Vehicles: " + entry.getValue());
        }
    }

    public String getBusiestRoad() {
        String busiest = null;
        int maxVehicles = -1;

        for (Map.Entry<String, Integer> entry : rawTrafficData.entrySet()) {
            if (entry.getValue() > maxVehicles) {
                maxVehicles = entry.getValue();
                busiest = entry.getKey();
            }
        }
        return busiest != null ? busiest + " (" + maxVehicles + " vehicles)" : "No data available";
    }

    public void generateTrafficReport() {
        System.out.println("\n--- City Traffic Analysis Report ---");
        System.out.println("Total Roads Monitored: " + rawTrafficData.size());
        System.out.println("Busiest Road in City: " + getBusiestRoad());
        System.out.println("\nDetailed Status Breakdown:");
        
        for (Map.Entry<String, Integer> entry : rawTrafficData.entrySet()) {
            String road = entry.getKey();
            int count = entry.getValue();
            String status;
            
            if (count > 500) {
                status = "HEAVY CONGESTION";
            } else if (count > 200) {
                status = "MODERATE TRAFFIC";
            } else {
                status = "CLEAR/LIGHT TRAFFIC";
            }
            System.out.println("- " + road + ": " + count + " vehicles [" + status + "]");
        }
    }

    public static void main(String[] args) {
        TrafficMonitoringSystem system = new TrafficMonitoringSystem();
        
        system.updateVehicleCount("Main Boulevard", 350);
        system.updateVehicleCount("Broadway Avenue", 600);
        system.updateVehicleCount("Airport Road", 150);
        system.updateVehicleCount("Main Boulevard", 200);

        system.displaySortedTraffic();
        system.generateTrafficReport();
    }
}