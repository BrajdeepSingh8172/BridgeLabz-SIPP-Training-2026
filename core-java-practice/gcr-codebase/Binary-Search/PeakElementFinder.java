import java.util.Scanner;

public class PeakElementFinder {
    public static int findPeakIndex(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            boolean greaterThanLeft = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean greaterThanRight = (mid == n - 1 || arr[mid] > arr[mid + 1]);

            if (greaterThanLeft && greaterThanRight) {
                return mid;
            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int peakIdx = findPeakIndex(arr);
        if (peakIdx != -1) {
            System.out.println(arr[peakIdx]);
        }
        sc.close();
    }
}