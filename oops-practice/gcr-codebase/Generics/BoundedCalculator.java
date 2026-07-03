public class BoundedCalculator {

    public static <T extends Number> double addValues(T num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Number> double multiplyValues(T num1, T num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static void main(String[] args) {
        int a = 15;
        double b = 4.5;

        System.out.println("Addition Result: " + addValues(a, b));
        System.out.println("Multiplication Result: " + multiplyValues(a, b));
    }
}