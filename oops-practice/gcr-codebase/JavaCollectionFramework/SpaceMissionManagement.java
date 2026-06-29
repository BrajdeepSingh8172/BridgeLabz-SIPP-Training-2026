import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Astronaut {
    String astronautId;
    String name;
    String specialization;

    Astronaut(String astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return name + " (ID: " + astronautId + ", Spec: " + specialization + ")";
    }
}

public class SpaceMissionManagement {
    private HashMap<String, List<Astronaut>> missionCrewMap = new HashMap<>();
    private HashMap<String, HashSet<String>> missionTrackingSet = new HashMap<>();

    public void addMission(String missionName) {
        if (!missionCrewMap.containsKey(missionName)) {
            missionCrewMap.put(missionName, new ArrayList<>());
            missionTrackingSet.put(missionName, new HashSet<>());
            System.out.println("Mission '" + missionName + "' added successfully.");
        } else {
            System.out.println("Mission '" + missionName + "' already exists.");
        }
    }

    public void assignAstronaut(String missionName, Astronaut astronaut) {
        if (!missionCrewMap.containsKey(missionName)) {
            System.out.println("Failed to assign: Mission '" + missionName + "' does not exist.");
            return;
        }

        HashSet<String> assignedIds = missionTrackingSet.get(missionName);
        if (assignedIds.contains(astronaut.astronautId)) {
            System.out.println("Duplicate Assignment Rejected: " + astronaut.name + " is already assigned to " + missionName);
        } else {
            missionCrewMap.get(missionName).add(astronaut);
            assignedIds.add(astronaut.astronautId);
            System.out.println("Assigned " + astronaut.name + " to " + missionName);
        }
    }

    public void displayMissionDetails() {
        System.out.println("\n--- Space Mission Crew Allocation Overview ---");
        for (Map.Entry<String, List<Astronaut>> entry : missionCrewMap.entrySet()) {
            String missionName = entry.getKey();
            List<Astronaut> crew = entry.getValue();
            System.out.println("Mission: " + missionName);
            System.out.println("Crew Members: " + crew);
            System.out.println("Total Astronauts Assigned: " + crew.size());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SpaceMissionManagement system = new SpaceMissionManagement();
        
        system.addMission("Artemis III");
        system.addMission("Mars One");

        Astronaut astro1 = new Astronaut("AST001", "Neil Armstrong", "Commander");
        Astronaut astro2 = new Astronaut("AST002", "Buzz Aldrin", "Pilot");
        Astronaut astro3 = new Astronaut("AST003", "Peggy Whitson", "Biochemist");

        System.out.println();
        system.assignAstronaut("Artemis III", astro1);
        system.assignAstronaut("Artemis III", astro2);
        system.assignAstronaut("Artemis III", astro1);
        system.assignAstronaut("Mars One", astro3);
        system.assignAstronaut("Mars One", astro1);

        system.displayMissionDetails();
    }
}