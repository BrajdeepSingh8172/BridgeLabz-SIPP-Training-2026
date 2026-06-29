import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class SmartClassroomTracker {
    private HashMap<String, ArrayList<String>> attendanceMap = new HashMap<>();

    public void markAttendance(String subject, String studentName) {
        attendanceMap.putIfAbsent(subject, new ArrayList<>());
        ArrayList<String> students = attendanceMap.get(subject);

        if (students.contains(studentName)) {
            System.out.println("Duplicate attendance rejected for " + studentName + " in " + subject);
        } else {
            students.add(studentName);
            System.out.println("Attendance marked for " + studentName + " in " + subject);
        }
    }

    public void displayAttendance() {
        System.out.println("--- Subject-wise Attendance Records ---");
        for (Map.Entry<String, ArrayList<String>> entry : attendanceMap.entrySet()) {
            System.out.println("Subject: " + entry.getKey());
            System.out.println("Students Present: " + entry.getValue());
            System.out.println("Total Count: " + entry.getValue().size());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SmartClassroomTracker tracker = new SmartClassroomTracker();
        tracker.markAttendance("Mathematics", "Alice");
        tracker.markAttendance("Mathematics", "Bob");
        tracker.markAttendance("Mathematics", "Alice");
        tracker.markAttendance("Physics", "Bob");
        tracker.markAttendance("Physics", "Charlie");

        System.out.println();
        tracker.displayAttendance();
    }
}