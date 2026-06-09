import java.util.Scanner;

class SubtractProductAndSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int sum = 0;
        int product = 1;

        while (n > 0) {
            int digit = n % 10;

            sum += digit;
            product *= digit;

            n /= 10;
        }

        int result = product - sum;

        System.out.println("Product of digits = " + product);
        System.out.println("Sum of digits = " + sum);
        System.out.println("Result = " + result);

        sc.close();
    }
}