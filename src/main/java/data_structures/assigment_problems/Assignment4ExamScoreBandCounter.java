package data_structures.assigment_problems;

public class Assignment4ExamScoreBandCounter {
    public static int countInBand(int[] scores, int low, int high) {
        return firstGreaterThan(scores, high) - firstAtLeast(scores, low);
    }

    private static int firstAtLeast(int[] values, int target) {
        int left = 0, right = values.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (values[middle] >= target) right = middle;
            else left = middle + 1;
        }
        return left;
    }

    private static int firstGreaterThan(int[] values, int target) {
        int left = 0, right = values.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (values[middle] > target) right = middle;
            else left = middle + 1;
        }
        return left;
    }

    // Linear scan: O(n) time/O(1) space. This two-boundary search: O(log n) time/O(1) space.
    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));
    }
}
