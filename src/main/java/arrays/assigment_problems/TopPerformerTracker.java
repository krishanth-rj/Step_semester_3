package arrays.assigment_problems;

public class TopPerformerTracker {
    public static String findMinMaxSpread(int[] scores) {
        if (scores.length == 0) throw new IllegalArgumentException("Scores must not be empty.");
        int minimum = scores[0];
        int maximum = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < minimum) minimum = scores[i];
            if (scores[i] > maximum) maximum = scores[i];
        }
        long spread = (long) maximum - minimum;
        return "Min: " + minimum + " | Max: " + maximum + " | Spread: " + spread;
    }
}
