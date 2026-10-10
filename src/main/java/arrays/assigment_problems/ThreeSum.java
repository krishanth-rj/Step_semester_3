package arrays.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static int[][] threeSum(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        List<int[]> triplets = new ArrayList<>();

        for (int first = 0; first < sorted.length - 2; first++) {
            if (first > 0 && sorted[first] == sorted[first - 1]) continue;
            int left = first + 1;
            int right = sorted.length - 1;
            while (left < right) {
                long sum = (long) sorted[first] + sorted[left] + sorted[right];
                if (sum == 0) {
                    triplets.add(new int[] {sorted[first], sorted[left], sorted[right]});
                    left++;
                    right--;
                    while (left < right && sorted[left] == sorted[left - 1]) left++;
                    while (left < right && sorted[right] == sorted[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets.toArray(new int[triplets.size()][]);
    }
}
