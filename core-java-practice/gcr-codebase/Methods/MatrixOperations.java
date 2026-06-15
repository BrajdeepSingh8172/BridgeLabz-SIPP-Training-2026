public class MatrixOperations {

    public static int[][] createMatrix(int rows, int cols) {

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                matrix[i][j] =
                        1 + (int)(Math.random() * 10);
            }
        }

        return matrix;
    }

    public static int[][] add(int[][] a, int[][] b) {

        int[][] result =
                new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a[0].length; j++) {

                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }

    public static int[][] subtract(int[][] a, int[][] b) {

        int[][] result =
                new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a[0].length; j++) {

                result[i][j] = a[i][j] - b[i][j];
            }
        }

        return result;
    }

    public static int[][] multiply(int[][] a, int[][] b) {

        int[][] result =
                new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < b[0].length; j++) {

                for (int k = 0; k < b.length; k++) {

                    result[i][j] +=
                            a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    public static void print(int[][] matrix) {

        for (int[] row : matrix) {

            for (int value : row) {

                System.out.print(value + "\t");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] A = createMatrix(3,3);
        int[][] B = createMatrix(3,3);

        System.out.println("Matrix A");
        print(A);

        System.out.println("\nMatrix B");
        print(B);

        System.out.println("\nAddition");
        print(add(A,B));

        System.out.println("\nSubtraction");
        print(subtract(A,B));

        System.out.println("\nMultiplication");
        print(multiply(A,B));
    }
}