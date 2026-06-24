interface Refuelable {
    void refuel();
}

class Vehicle {
    protected int maxSpeed;
    protected String model;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
}

class ElectricVehicle extends Vehicle {
    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void charge() {
        System.out.println(model + " is charging.");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void refuel() {
        System.out.println(model + " is refueling.");
    }

    public static void main(String[] args) {
        PetrolVehicle p = new PetrolVehicle("Honda City", 180);
        p.refuel();

        ElectricVehicle e = new ElectricVehicle("Tesla", 250);
        e.charge();
    }
}
