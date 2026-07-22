import java.util.PriorityQueue;

class Patient {
    int severity;
    String name;

    public Patient(int severity, String name) {
        this.severity = severity;
        this.name = name;
    }
}

public class EmergencyRoomTriageQueue {
    private PriorityQueue<Patient> triageQueue;

    public EmergencyRoomTriageQueue() {
        this.triageQueue = new PriorityQueue<>((a, b) -> b.severity - a.severity);
    }

    public void addPatient(Patient p) {
        triageQueue.offer(p);
    }

    public Patient treatNext() {
        return triageQueue.poll();
    }
}