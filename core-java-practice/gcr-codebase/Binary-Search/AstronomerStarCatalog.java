import java.util.Scanner;

public class AstronomerStarCatalog {
    public static int binarySearch(double[] arr, double target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static int searchInRotated(double[] arr, double target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target < arr[mid]) high = mid - 1;
                else low = mid + 1;
            } else {
                if (target > arr[mid] && target <= arr[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }

    public static int findFirstOccurrence(double[] arr, double target) {
        int low = 0, high = arr.length - 1, res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                res = mid;
                high = mid - 1;
            } else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return res;
    }

    public static int findLastOccurrence(double[] arr, double target) {
        int low = 0, high = arr.length - 1, res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                res = mid;
                low = mid + 1;
            } else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return res;
    }

    public static double findMinInRotated(double[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high]) low = mid + 1;
            else high = mid;
        }
        return arr[low];
    }

    public static void main(String[] args) {
        double[] catalog = {4.5, 5.1, 1.2, 2.3, 3.4, 3.4, 3.4, 4.0};
        System.out.println("Minimum Element: " + findMinInRotated(catalog));
        System.out.println("Search 3.4 in Rotated: " + searchInRotated(catalog, 3.4));
        
        double[] sortedCatalog = {1.2, 2.3, 3.4, 3.4, 3.4, 4.0, 4.5, 5.1};
        System.out.println("First Occurrence of 3.4: " + findFirstOccurrence(sortedCatalog, 3.4));
        System.out.println("Last Occurrence of 3.4: " + findLastOccurrence(sortedCatalog, 3.4));
    }
}