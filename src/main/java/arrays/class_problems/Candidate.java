package arrays.class_problems;

import java.util.Arrays;
import java.util.Locale;

public class Candidate implements Comparable<Candidate> {
    // Chosen course thresholds: minimum CGPA 7.0 and coding score 60.
    private static final double MINIMUM_CGPA = 7.0;
    private static final int MINIMUM_CODING_SCORE = 60;

    private final String name;
    private final double cgpa;
    private final int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public static boolean isEligible(double cgpa) {
        return cgpa >= MINIMUM_CGPA;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return isEligible(cgpa) && codingScore >= MINIMUM_CODING_SCORE;
    }

    private double compositeScore() {
        return cgpa * 10.0 + codingScore * 0.5;
    }

    @Override
    public int compareTo(Candidate other) {
        int byScore = Double.compare(other.compositeScore(), compositeScore());
        return byScore != 0 ? byScore : name.compareTo(other.name);
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] eligible = new Candidate[candidates.length];
        int count = 0;
        for (Candidate candidate : candidates) {
            if (isEligible(candidate.cgpa, candidate.codingScore)) eligible[count++] = candidate;
        }
        eligible = Arrays.copyOf(eligible, count);
        Arrays.sort(eligible);
        if (eligible.length == 0) return "No eligible candidates";

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < eligible.length; i++) {
            if (i > 0) result.append(" | ");
            result.append(i + 1).append(". ").append(eligible[i].name).append(" (")
                    .append(String.format(Locale.US, "%.1f", eligible[i].compositeScore())).append(')');
        }
        return result.toString();
    }
}
