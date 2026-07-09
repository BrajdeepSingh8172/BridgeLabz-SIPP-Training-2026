import java.util.Scanner;

public class RotationPointFinder {
    public static int findRotationPointIndex(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int index = findRotationPointIndex(arr);
        System.out.println(index);
        sc.close();
    }
}