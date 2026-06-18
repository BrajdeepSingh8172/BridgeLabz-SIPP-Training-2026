public class MovieSeatReservation {

    public static int getSeat(int index) {
        int seats[] = {101, 102, 103, 104, 105};
        try {
            return seats[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Seat Allocation Error: Position " + index + " is invalid for this theater layout.");
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("Requesting Seat at position 2: " + getSeat(2));
        System.out.println("Requesting Seat at position 8: " + getSeat(8));
    }
}