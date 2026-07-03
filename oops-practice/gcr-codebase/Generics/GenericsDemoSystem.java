import java.util.Arrays;
import java.util.List;

public class GenericsDemoSystem {

    public static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Age", 25);
        System.out.println("Pair Demo: " + pair);

        GenericStack<String> stack = new GenericStack<>();
        stack.push("First");
        stack.push("Second");
        System.out.println("Stack Pop: " + stack.pop());

        Integer[] intArray = {3, 9, 2, 8, 5};
        String[] strArray = {"Apple", "Orange", "Banana"};
        System.out.println("Max Integer: " + findMax(intArray));
        System.out.println("Max String: " + findMax(strArray));

        Repository<String> stringRepo = new Repository<>();
        stringRepo.add("Entity1");
        stringRepo.add("Entity2");
        System.out.println("Repository Entities: " + stringRepo.getAll());

        System.out.print("Wildcard List Printing: ");
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        printList(doubleList);
    }
}