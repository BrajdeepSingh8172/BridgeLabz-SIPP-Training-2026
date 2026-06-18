public class LeetcodeSearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6};
        System.out.println("Insert index for target 5: " + searchInsert(array, 5)); // Expected: 2
        System.out.println("Insert index for target 2: " + searchInsert(array, 2)); // Expected: 1
    }
}