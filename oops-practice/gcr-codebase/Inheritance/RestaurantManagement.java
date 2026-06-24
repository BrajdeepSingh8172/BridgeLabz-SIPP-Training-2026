interface Worker {
    void performDuties();
}

class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " cooks food.");
    }
}

class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " serves customers.");
    }
}

public class RestaurantManagement {
    public static void main(String[] args) {
        Chef chef = new Chef("Rahul", 1);
        Waiter waiter = new Waiter("Aman", 2);

        chef.performDuties();
        waiter.performDuties();
    }
}
