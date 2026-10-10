package data_structures.class_problems;

import java.util.Arrays;

public class InPlaceArrayReversal {
    public static void reverse(int[] values) {
        int left = 0, right = values.length - 1;
        while (left < right) {
            int temp = values[left];
            values[left] = values[right];
            values[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] values = {11, 22, 33, 44};
        reverse(values);
        System.out.println(Arrays.toString(values));
    }
}
