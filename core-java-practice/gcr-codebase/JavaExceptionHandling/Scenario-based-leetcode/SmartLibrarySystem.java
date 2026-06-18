public class SmartLibrarySystem {

    public static int getBookLength(int index) {
        String books[] = {"Java", "Python", null, "C++"};
        try {
            return books[index].length();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Library Error: Row/Index location " + index + " does not exist in our registry database.");
            return -1;
        } catch (NullPointerException e) {
            System.err.println("Library Error: Book catalog data at position " + index + " contains uninitialized or corrupted empty text values.");
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("Length of Book 0: " + getBookLength(0));
        System.out.println("Length of Book 2 (Null entry): " + getBookLength(2));
        System.out.println("Length of Book 7 (Invalid index): " + getBookLength(7));
    }
}