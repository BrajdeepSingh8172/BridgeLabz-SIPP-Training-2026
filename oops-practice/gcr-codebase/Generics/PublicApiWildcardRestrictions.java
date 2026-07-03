import java.util.ArrayList;
import java.util.List;

public class PublicApiWildcardRestrictions {

    public static List<Integer> generateSequence(int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            list.add(i);
        }
        return list;
    }

    public static void processSequence(List<? extends Number> sequence) {
        for (Number num : sequence) {
            System.out.println("Processing value: " + num.doubleValue());
        }
    }

    public static void main(String[] args) {
        List<Integer> cleanReturnList = generateSequence(5);
        processSequence(cleanReturnList);
    }
}