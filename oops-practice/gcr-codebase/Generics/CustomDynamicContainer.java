import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomDynamicContainer<T> {
    private List<T> internalList;

    public CustomDynamicContainer() {
        this.internalList = new ArrayList<>();
    }

    public CustomDynamicContainer(T initialItem) {
        this();
        this.internalList.add(initialItem);
    }

    public void addElement(T element) {
        this.internalList.add(element);
    }

    public List<T> filterElements(Predicate<T> filterPredicate) {
        return this.internalList.stream()
                                .filter(filterPredicate)
                                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        CustomDynamicContainer<Integer> container = new CustomDynamicContainer<>(100);
        container.addElement(150);
        container.addElement(200);
        container.addElement(250);

        List<Integer> highValues = container.filterElements(val -> val > 160);
        System.out.println("Filtered items higher than 160: " + highValues);
    }
}