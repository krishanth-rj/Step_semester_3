package data_structures.assigment_problems;

import java.util.Arrays;

public class Assignment3DutyRosterRotation {
    public static String[] rotateRoster(String[] names, int k) {
        if (names.length == 0) return new String[0];
        int shift = k % names.length;
        String[] rotated = new String[names.length];
        for (int i = 0; i < names.length; i++) rotated[(i + shift) % names.length] = names[i];
        return rotated;
    }

    // Time: O(n). Extra space: O(n). Rotating one place k times costs O(n*k).
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateRoster(new String[] {"A", "B", "C", "D", "E"}, 2)));
    }
}
