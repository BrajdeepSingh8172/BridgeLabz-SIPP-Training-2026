import java.util.Scanner;

public class HospitalEmergency {
    public static int quickSelect(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int pivotIndex = partition(arr, low, high);
            if (pivotIndex == k) {
                return arr[pivotIndex];
            } else if (pivotIndex > k) {
                return quickSelect(arr, low, pivotIndex - 1, k);
            } else {
                return quickSelect(arr, pivotIndex + 1, high, k);
            }
        }
        return -1;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] priorities = new int[n];
        for (int i = 0; i < n; i++) {
            priorities[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int result = quickSelect(priorities, 0, n - 1, k - 1);
        System.out.println(result);
        sc.close();
    }
}