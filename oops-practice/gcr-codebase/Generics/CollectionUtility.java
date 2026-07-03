import java.util.List;

public class CollectionUtility {

    public static <T> void readData(List<? extends T> list) {
        System.out.println("Reading elements from bounded wildcard (? extends T):");
        for (T element : list) {
            System.out.println("Element: " + element);
        }
    }

    public static <T> void writeData(List<? super T> list, T element) {
        System.out.println("Writing element using lower bounded wildcard (? super T)...");
        list.add(element);
    }
}
