package arrays.class_problems;

public class RotateArray {
    /** Rotates right by k positions and returns a new array; the input is not changed. */
    public static int[] rotateArray(int[] nums, int k) {
        int[] rotated = new int[nums.length];
        if (nums.length == 0) return rotated;
        int shift = k % nums.length;
        if (shift < 0) shift += nums.length;
        for (int i = 0; i < nums.length; i++) {
            int destination = (i + shift) % nums.length;
            rotated[destination] = nums[i];
        }
        return rotated;
    }
}
