import java.util.ArrayList;
import java.util.List;

public class AdvancedGenericsOrchestrator {

    public static void processElements(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }

    public static <T extends Number & Comparable<T>> void verifyRange(T value, T min, T max) {
        if (value.compareTo(min) >= 0 && value.compareTo(max) <= 0) {
            System.out.println(value + " falls within the specified numeric range.");
        } else {
            System.out.println(value + " falls outside the specified numeric range.");
        }
    }

    public static void main(String[] args) {
        List<Number> numList = new ArrayList<>();
        processElements(numList);
        System.out.println("Populated Number List via Lower Bound: " + numList);

        Integer checkValue = 25;
        Integer lowerLimit = 10;
        Integer upperLimit = 50;
        verifyRange(checkValue, lowerLimit, upperLimit);
    }
}