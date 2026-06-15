import java.util.Scanner;

public class PerfectAbundantDeficient {

    public static int sumOfProperDivisors(int n) {

        int sum = 0;

        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public static boolean isPerfect(int n) {
        return sumOfProperDivisors(n) == n;
    }

    public static boolean isAbundant(int n) {
        return sumOfProperDivisors(n) > n;
    }

    public static boolean isDeficient(int n) {
        return sumOfProperDivisors(n) < n;
    }

    public static int factorial(int n) {

        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    public static boolean isStrong(int n) {

        int temp = n;
        int sum = 0;

        while (temp > 0) {

            int digit = temp % 10;
            sum += factorial(digit);

            temp /= 10;
        }

        return sum == n;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number: ");
        int n = sc.nextInt();

        System.out.println("Perfect Number = " + isPerfect(n));
        System.out.println("Abundant Number = " + isAbundant(n));
        System.out.println("Deficient Number = " + isDeficient(n));
        System.out.println("Strong Number = " + isStrong(n));

        sc.close();
    }
}