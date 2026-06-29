import java.util.HashSet;

public class EventVerificationSystem {
    private HashSet<String> registeredEmails = new HashSet<>();

    public void registerParticipant(String emailId) {
        if (registeredEmails.add(emailId)) {
            System.out.println("Registration successful for: " + emailId);
        } else {
            System.out.println("Registration REJECTED: Duplicate entry for " + emailId);
        }
    }

    public void displayParticipants() {
        System.out.println("--- Registered Unique Participants ---");
        for (String email : registeredEmails) {
            System.out.println(email);
        }
        System.out.println("Total Eligible Attendees: " + registeredEmails.size());
    }

    public static void main(String[] args) {
        EventVerificationSystem system = new EventVerificationSystem();
        system.registerParticipant("john.doe@example.com");
        system.registerParticipant("jane.smith@example.com");
        system.registerParticipant("john.doe@example.com");
        system.registerParticipant("alex.jones@example.com");

        System.out.println();
        system.displayParticipants();
    }
}