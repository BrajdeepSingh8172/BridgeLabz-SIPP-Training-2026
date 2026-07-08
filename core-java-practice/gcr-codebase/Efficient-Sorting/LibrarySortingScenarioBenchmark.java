import java.util.Arrays;
import java.util.Random;

public class LibrarySortingScenarioBenchmark {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void quickSort3WayLomuto(int[] arr, int low, int high) {
        if (low < high) {
            int[] pivots = partition3WayLomuto(arr, low, high);
            quickSort3WayLomuto(arr, low, pivots[0] - 1);
            quickSort3WayLomuto(arr, pivots[1] + 1, high);
        }
    }

    private static int[] partition3WayLomuto(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        int curr = low;
        int n = high;

        while (curr <= n) {
            if (arr[curr] < pivot) {
                swap(arr, i, curr);
                i++;
                curr++;
            } else if (arr[curr] > pivot) {
                swap(arr, curr, n);
                n--;
            } else {
                curr++;
            }
        }
        return new int[]{i, n};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;
        int[] count = new int[21];
        for (int val : arr) {
            count[val]++;
        }
        int idx = 0;
        for (int i = 1; i <= 20; i++) {
            while (count[i] > 0) {
                arr[idx++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};
        Random rand = new Random();

        System.out.println("Empirical Runtime Comparison (Nanoseconds):");
        System.out.println("Size\tMerge Sort\tQuick Sort (3-Way)\tCounting Sort");

        for (int size : sizes) {
            int[] baseArr = new int[size];
            for (int i = 0; i < size; i++) {
                baseArr[i] = rand.nextInt(20) + 1;
            }

            int[] arr1 = Arrays.copyOf(baseArr, size);
            long start = System.nanoTime();
            mergeSort(arr1, 0, size - 1);
            long timeMerge = System.nanoTime() - start;

            int[] arr2 = Arrays.copyOf(baseArr, size);
            start = System.nanoTime();
            quickSort3WayLomuto(arr2, 0, size - 1);
            long timeQuick = System.nanoTime() - start;

            int[] arr3 = Arrays.copyOf(baseArr, size);
            start = System.nanoTime();
            countingSort(arr3);
            long timeCounting = System.nanoTime() - start;

            System.out.println(size + "\t" + timeMerge + "\t\t" + timeQuick + "\t\t\t" + timeCounting);
        }
    }
}