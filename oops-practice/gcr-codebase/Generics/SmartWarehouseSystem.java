import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String id;
    private String name;

    public WarehouseItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [ID=" + id + ", Name=" + name + "]";
    }
}

class Electronics extends WarehouseItem {
    public Electronics(String id, String name) {
        super(id, name);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String id, String name) {
        super(id, name);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String id, String name) {
        super(id, name);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public List<T> getAllItems() {
        return items;
    }
}

public class SmartWarehouseSystem {
    public static void displayInventory(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Storage<Electronics> techStorage = new Storage<>();
        techStorage.addItem(new Electronics("E101", "Laptop"));
        techStorage.addItem(new Electronics("E102", "Smartphone"));

        Storage<Groceries> foodStorage = new Storage<>();
        foodStorage.addItem(new Groceries("G201", "Organic Apples"));

        System.out.println("--- Electronics Storage ---");
        displayInventory(techStorage.getAllItems());

        System.out.println("\n--- Groceries Storage ---");
        displayInventory(foodStorage.getAllItems());
    }
}