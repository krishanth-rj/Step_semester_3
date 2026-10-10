package arrays.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFrequencies = new HashMap<>();
        prefixFrequencies.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for (int value : nums) {
            prefixSum += value;
            count += prefixFrequencies.getOrDefault(prefixSum - k, 0);
            prefixFrequencies.put(prefixSum, prefixFrequencies.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
