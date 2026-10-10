package arrays.class_problems;

import java.util.Locale;

public class HackathonSeatingGridOptimizer {
    public static double rowAverage(int[] row) {
        if (row.length == 0) return 0.0;
        long total = 0;
        for (int score : row) total += score;
        return (double) total / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < seatingScores.length; row++) {
            double average = rowAverage(seatingScores[row]);
            String zone = average < threshold ? "Quiet Zone" : "Buzzing Zone";
            if (row > 0) result.append(System.lineSeparator());
            result.append(String.format(Locale.US, "Row %d: %.2f - %s", row + 1, average, zone));
        }
        return result.toString();
    }
}
