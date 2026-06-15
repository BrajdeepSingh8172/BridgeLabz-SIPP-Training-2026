public class StudentScorecard {

    public static int[][] generateMarks(int students) {

        int[][] marks = new int[students][3];

        for (int i = 0; i < students; i++) {

            marks[i][0] = 10 + (int)(Math.random() * 90);
            marks[i][1] = 10 + (int)(Math.random() * 90);
            marks[i][2] = 10 + (int)(Math.random() * 90);
        }

        return marks;
    }

    public static double[][] calculateResults(int[][] marks) {

        double[][] result = new double[marks.length][3];

        for (int i = 0; i < marks.length; i++) {

            int total =
                    marks[i][0]
                            + marks[i][1]
                            + marks[i][2];

            double average = total / 3.0;

            double percentage = (total / 300.0) * 100;

            result[i][0] = total;
            result[i][1] =
                    Math.round(average * 100.0) / 100.0;
            result[i][2] =
                    Math.round(percentage * 100.0) / 100.0;
        }

        return result;
    }

    public static void main(String[] args) {

        int students = 10;

        int[][] marks = generateMarks(students);

        double[][] result = calculateResults(marks);

        System.out.println(
                "Student\tPhysics\tChem\tMath\tTotal\tAverage\tPercentage");

        for (int i = 0; i < students; i++) {

            System.out.printf(
                    "%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f%n",
                    i + 1,
                    marks[i][0],
                    marks[i][1],
                    marks[i][2],
                    result[i][0],
                    result[i][1],
                    result[i][2]);
        }
    }
}