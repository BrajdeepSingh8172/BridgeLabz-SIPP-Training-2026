import java.util.Scanner;

public class SortedMatrixSearcher {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int rows = matrix.length;
        int numColumns = matrix[0].length;
        int left = 0;
        int right = rows * numColumns - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / numColumns;
            int col = mid % numColumns;
            int currentElement = matrix[row][col];

            if (currentElement == target) {
                return true;
            } else if (currentElement > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int target = sc.nextInt();

        boolean found = searchMatrix(matrix, target);
        System.out.println(found);
        sc.close();
    }
}