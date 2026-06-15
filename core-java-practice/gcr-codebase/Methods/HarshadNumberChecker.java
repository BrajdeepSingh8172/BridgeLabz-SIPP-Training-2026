import java.util.Scanner;

public class HarshadNumberChecker {

    public static int[] storeDigits(int num) {

        int count = String.valueOf(num).length();
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }

        return digits;
    }

    public static int sumDigits(int[] digits) {

        int sum = 0;

        for (int digit : digits) {
            sum += digit;
        }

        return sum;
    }

    public static int sumSquares(int[] digits) {

        int sum = 0;

        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }

        return sum;
    }

    public static boolean isHarshad(int num, int[] digits) {
        return num % sumDigits(digits) == 0;
    }

    public static void frequency(int[] digits) {

        int[][] freq = new int[10][2];

        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
        }

        for (int digit : digits) {
            freq[digit][1]++;
        }

        System.out.println("Digit\tFrequency");

        for (int i = 0; i < 10; i++) {
            System.out.println(freq[i][0] + "\t" + freq[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] digits = storeDigits(num);

        System.out.println("Sum Digits = " + sumDigits(digits));
        System.out.println("Sum Squares = " + sumSquares(digits));
        System.out.println("Harshad = " + isHarshad(num, digits));

        frequency(digits);

        sc.close();
    }
}