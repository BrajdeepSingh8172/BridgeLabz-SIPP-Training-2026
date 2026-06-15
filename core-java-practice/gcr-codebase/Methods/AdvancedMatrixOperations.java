public class AdvancedMatrixOperations {

    public static void print(double[][] matrix) {

        for (double[] row : matrix) {

            for (double value : row) {

                System.out.printf("%.2f\t", value);
            }

            System.out.println();
        }
    }

    public static double[][] transpose(double[][] matrix) {

        double[][] trans =
                new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                trans[j][i] = matrix[i][j];
            }
        }

        return trans;
    }

    public static double determinant2x2(double[][] m) {

        return (m[0][0] * m[1][1])
                - (m[0][1] * m[1][0]);
    }

    public static double[][] inverse2x2(double[][] m) {

        double det = determinant2x2(m);

        double[][] inv = {
                {m[1][1] / det, -m[0][1] / det},
                {-m[1][0] / det, m[0][0] / det}
        };

        return inv;
    }

    public static void main(String[] args) {

        double[][] matrix = {
                {4,7},
                {2,6}
        };

        System.out.println("Original Matrix");
        print(matrix);

        System.out.println("\nTranspose");
        print(transpose(matrix));

        System.out.println(
                "\nDeterminant = "
                        + determinant2x2(matrix));

        System.out.println("\nInverse");
        print(inverse2x2(matrix));
    }
}