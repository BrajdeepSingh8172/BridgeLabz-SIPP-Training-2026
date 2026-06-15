public class EmployeeBonusCalculator {

    public static double[][] generateEmployeeData() {

        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {

            double salary = 10000 + (int)(Math.random() * 90000);
            int years = 1 + (int)(Math.random() * 10);

            data[i][0] = salary;
            data[i][1] = years;
        }

        return data;
    }

    public static double[][] calculateBonus(double[][] data) {

        double[][] result = new double[10][4];

        for (int i = 0; i < data.length; i++) {

            double salary = data[i][0];
            int years = (int)data[i][1];

            double bonus;

            if (years > 5) {
                bonus = salary * 0.05;
            } else {
                bonus = salary * 0.02;
            }

            double newSalary = salary + bonus;

            result[i][0] = salary;
            result[i][1] = years;
            result[i][2] = bonus;
            result[i][3] = newSalary;
        }

        return result;
    }

    public static void display(double[][] result) {

        double totalOld = 0;
        double totalBonus = 0;
        double totalNew = 0;

        System.out.println("Emp\tOld Salary\tYears\tBonus\tNew Salary");

        for (int i = 0; i < result.length; i++) {

            System.out.printf("%d\t%.2f\t%d\t%.2f\t%.2f%n",
                    i + 1,
                    result[i][0],
                    (int)result[i][1],
                    result[i][2],
                    result[i][3]);

            totalOld += result[i][0];
            totalBonus += result[i][2];
            totalNew += result[i][3];
        }

        System.out.println("\nTotal Old Salary = " + totalOld);
        System.out.println("Total Bonus = " + totalBonus);
        System.out.println("Total New Salary = " + totalNew);
    }

    public static void main(String[] args) {

        double[][] data = generateEmployeeData();

        double[][] result = calculateBonus(data);

        display(result);
    }
}