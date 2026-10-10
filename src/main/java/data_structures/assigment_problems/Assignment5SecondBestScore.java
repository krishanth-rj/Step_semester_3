package data_structures.assigment_problems;

public class Assignment5SecondBestScore {
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int secondHighest = -1;
        for (int score : scores) {
            if (score > highest) {
                secondHighest = highest;
                highest = score;
            } else if (score < highest && score > secondHighest) {
                secondHighest = score;
            }
        }
        return secondHighest;
    }

    // One pass: O(n) time/O(1) space. Sorting first would take O(n log n) time.
    public static void main(String[] args) {
        System.out.println(secondHighest(new int[] {45, 78, 92, 78, 60}));
    }
}
