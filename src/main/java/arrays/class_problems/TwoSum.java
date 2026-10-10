package arrays.class_problems;

public class TwoSum {
    /** Returns the first pair of distinct indices that adds up to target, or an empty array. */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[] {i, j};
            }
        }
        return new int[0];
    }
}
