import java.util.ArrayList;
import java.util.List;

interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    public String getCategoryName() {
        return "Books";
    }
}

class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadgets";
    }
}

class Product<T extends Category> {
    private String id;
    private String name;
    private double price;
    private T category;

    public Product(String id, String name, double price, T category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " (" + category.getCategoryName() + ") - Price: $" + price;
    }
}

public class OnlineMarketplace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double currentPrice = product.getPrice();
        double discountAmount = currentPrice * (percentage / 100.0);
        product.setPrice(currentPrice - discountAmount);
        System.out.println("Applied " + percentage + "% discount on: " + product.getName());
    }

    public static void main(String[] args) {
        Product<BookCategory> novel = new Product<>("B1", "Java Programming Guide", 50.0, new BookCategory());
        Product<GadgetCategory> phone = new Product<>("G1", "Wireless Earbuds", 100.0, new GadgetCategory());

        List<Product<?>> catalog = new ArrayList<>();
        catalog.add(novel);
        catalog.add(phone);

        System.out.println("--- Catalog Before Discounts ---");
        for (Product<?> p : catalog) {
            System.out.println(p);
        }

        System.out.println("\n--- Applying Reductions ---");
        applyDiscount(novel, 10);
        applyDiscount(phone, 20);

        System.out.println("\n--- Catalog After Discounts ---");
        for (Product<?> p : catalog) {
            System.out.println(p);
        }
    }
}