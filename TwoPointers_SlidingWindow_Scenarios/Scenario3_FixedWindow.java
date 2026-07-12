public class Scenario3_FixedWindow {

    static int maxSubarrayOfSizeK(int[] a, int k) {
        int sum = 0, max = Integer.MIN_VALUE, start = 0;

        for (int end = 0; end < a.length; end++) {
            sum += a[end];

            if (end >= k - 1) {
                max = Math.max(max, sum);
                sum -= a[start++];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int result = maxSubarrayOfSizeK(arr, k);
        System.out.println("Maximum Sum = " + result);
    }
}