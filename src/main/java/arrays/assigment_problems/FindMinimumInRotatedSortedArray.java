package arrays.assigment_problems;

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        if (nums.length == 0) throw new IllegalArgumentException("Array must not be empty.");
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > nums[right]) left = middle + 1;
            else right = middle;
        }
        return nums[left];
    }
}
