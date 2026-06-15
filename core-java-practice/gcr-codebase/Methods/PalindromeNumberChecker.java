import java.util.Arrays;
import java.util.Scanner;

public class PalindromeNumberChecker {

    public static int[] storeDigits(int num) {

        int count = String.valueOf(num).length();
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }

        return digits;
    }

    public static int[] reverseArray(int[] arr) {

        int[] rev = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }

        return rev;
    }

    public static boolean compareArrays(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean isPalindrome(int[] digits) {
        return compareArrays(digits, reverseArray(digits));
    }

    public static boolean isDuck(int[] digits) {

        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] digits = storeDigits(num);

        System.out.println("Palindrome = " + isPalindrome(digits));
        System.out.println("Duck Number = " + isDuck(digits));

        sc.close();
    }
}