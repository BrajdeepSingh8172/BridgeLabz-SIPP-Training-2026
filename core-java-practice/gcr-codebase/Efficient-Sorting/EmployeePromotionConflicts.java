import java.util.Scanner;

public class EmployeePromotionConflicts {
    private static long mergeAndCount(long[] arr, long[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                count += (right - j + 1);
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

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return count;
    }

    private static long mergeSortAndCount(long[] arr, long[] temp, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSortAndCount(arr, temp, left, mid);
            count += mergeSortAndCount(arr, temp, mid + 1, right);
            count += mergeAndCount(arr, temp, left, mid, right);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        long[] scores = new long[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextLong();
        }

        long[] temp = new long[n];
        long totalConflicts = mergeSortAndCount(scores, temp, 0, n - 1);
        System.out.println(totalConflicts);
        sc.close();
    }
}