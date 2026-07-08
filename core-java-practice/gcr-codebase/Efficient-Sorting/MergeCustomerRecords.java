import java.util.Scanner;

public class MergeCustomerRecords {
    public static int[] mergeLists(int[] branchA, int[] branchB) {
        int n = branchA.length;
        int m = branchB.length;
        int[] result = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (branchA[i] <= branchB[j]) {
                result[k++] = branchA[i++];
            } else {
                result[k++] = branchB[j++];
            }
        }

        while (i < n) {
            result[k++] = branchA[i++];
        }
        while (j < m) {
            result[k++] = branchB[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        int[] branchA = new int[n];
        for (int i = 0; i < n; i++) {
            branchA[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] branchB = new int[m];
        for (int i = 0; i < m; i++) {
            branchB[i] = sc.nextInt();
        }

        int[] merged = mergeLists(branchA, branchB);
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i] + (i == merged.length - 1 ? "" : " "));
        }
        System.out.println();
        sc.close();
    }
}