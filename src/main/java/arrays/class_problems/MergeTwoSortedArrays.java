package arrays.class_problems;

public class MergeTwoSortedArrays {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int first = 0, second = 0, result = 0;
        while (first < arr1.length && second < arr2.length) {
            if (arr1[first] <= arr2[second]) merged[result++] = arr1[first++];
            else merged[result++] = arr2[second++];
        }
        while (first < arr1.length) merged[result++] = arr1[first++];
        while (second < arr2.length) merged[result++] = arr2[second++];
        return merged;
    }
}
