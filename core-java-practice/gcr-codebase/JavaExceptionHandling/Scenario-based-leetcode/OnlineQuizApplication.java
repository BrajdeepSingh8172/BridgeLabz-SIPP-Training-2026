public class OnlineQuizApplication {
    public static void main(String[] args) {
        String answers[] = {"A", "B", "C", "D"};
        String correctKeys[] = {"A", "B", "B", "D", "A", "C"}; // Simulating a multi-question check loop

        for (int i = 0; i <= 5; i++) {
            try {
                System.out.print("Checking Question " + (i + 1) + ": ");
                // Simulating the scenario where loop goes out of bounds or checks structural data
                if (answers[i].equals(correctKeys[i])) {
                    System.out.println("Correct");
                } else {
                    System.out.println("Incorrect");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("System Error: No answer submitted/found at index " + i + ". Processing skipped.");
                // Loop continues seamlessly due to internal block exception handling
            } catch (NullPointerException e) {
                System.err.println("System Error: Encounted an unreadable blank answer sheet block.");
            }
        }
        System.out.println("Quiz evaluation run complete.");
    }
}