import java.util.Scanner;

public class BankFraudDetection {
    private static long mergeAndCount(long[] arr, int left, int mid, int right) {
        long count = 0;
        int j = mid + 1;
        
        for (int i = left; i <= mid; i++) {
            while (j <= right && arr[i] > 3 * arr[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        long[] temp = new long[right - left + 1];
        int i = left;
        j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
        return count;
    }

    private static long mergeSortAndCount(long[] arr, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSortAndCount(arr, left, mid);
            count += mergeSortAndCount(arr, mid + 1, right);
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        long[] amounts = new long[n];
        for (int i = 0; i < n; i++) {
            amounts[i] = sc.nextLong();
        }

        long suspiciousPairs = mergeSortAndCount(amounts, 0, n - 1);
        System.out.println(suspiciousPairs);
        sc.close();
    }
}