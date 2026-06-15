import java.util.Scanner;

public class MonthlyCalendar {

    public static boolean isLeapYear(int year) {

        return (year % 400 == 0)
                || (year % 4 == 0 && year % 100 != 0);
    }

    public static int getDaysInMonth(int month, int year) {

        int[] days = {
                31,28,31,30,31,30,
                31,31,30,31,30,31
        };

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return days[month - 1];
    }

    public static int firstDay(int month, int year) {

        int d = 1;

        if (month < 3) {
            month += 12;
            year--;
        }

        int k = year % 100;
        int j = year / 100;

        int h = (d + (13 * (month + 1)) / 5
                + k + k / 4 + j / 4 + 5 * j) % 7;

        return (h + 6) % 7;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Month: ");
        int month = sc.nextInt();

        System.out.print("Enter Year: ");
        int year = sc.nextInt();

        String[] months = {
                "January","February","March","April",
                "May","June","July","August",
                "September","October","November","December"
        };

        System.out.println("\n\t" + months[month - 1] + " " + year);

        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int firstDay = firstDay(month, year);

        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        int days = getDaysInMonth(month, year);

        for (int day = 1; day <= days; day++) {

            System.out.printf("%3d ", day);

            if ((firstDay + day) % 7 == 0) {
                System.out.println();
            }
        }

        sc.close();
    }
}