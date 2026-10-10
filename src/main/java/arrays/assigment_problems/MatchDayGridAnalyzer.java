package arrays.assigment_problems;

import java.util.Locale;

public class MatchDayGridAnalyzer {
    public static double rowAverage(int[] row) {
        if (row.length == 0) return 0.0;
        long total = 0;
        for (int runs : row) total += runs;
        return (double) total / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int match = 0; match < runsPerOver.length; match++) {
            double average = rowAverage(runsPerOver[match]);
            String classification = average >= threshold ? "Power Surge" : "Normal";
            if (match > 0) result.append(System.lineSeparator());
            result.append(String.format(Locale.US, "Match %d: %.2f - %s", match + 1, average, classification));
        }
        return result.toString();
    }
}
