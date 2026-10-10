package arrays.class_problems;

import java.util.Arrays;

public class HackathonScoreCurveBooster {
    public static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) scores[i] += bonus;
        System.out.println(Arrays.toString(scores));
    }
}
