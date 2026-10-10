package arrays.assigment_problems;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) throw new IllegalArgumentException("Array must not be empty.");
        int currentSum = nums[0];
        int maximumSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maximumSum = Math.max(maximumSum, currentSum);
        }
        return maximumSum;
    }
}
