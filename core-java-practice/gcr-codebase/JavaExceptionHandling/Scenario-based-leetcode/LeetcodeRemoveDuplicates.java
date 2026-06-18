public class LeetcodeRemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3};
        int uniqueCount = removeDuplicates(array);
        System.out.print("Modified array up to k elements: ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nUnique elements size: " + uniqueCount);
    }
}