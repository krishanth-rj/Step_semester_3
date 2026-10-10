package arrays.class_problems;

public class TopThreePodiumFinder {
    public static int[] findTopThreeScores(int[] scores) {
        int[] top = new int[3];
        int count = 0;
        for (int score : scores) {
            int position = 0;
            while (position < count && score <= top[position]) position++;
            if (position < 3) {
                for (int i = Math.min(count, 2); i > position; i--) top[i] = top[i - 1];
                top[position] = score;
                if (count < 3) count++;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) result[i] = top[i];
        return result;
    }
}
