package encapsulation.class_problems;

public class Scorecard {
    private final boolean[] results;
    private int recordedAnswers;

    public Scorecard(int questionCount) {
        if (questionCount < 0) throw new IllegalArgumentException("Question count cannot be negative.");
        results = new boolean[questionCount];
    }

    public void recordAnswer(boolean correct) {
        if (recordedAnswers == results.length) {
            System.out.println("Answer ignored: all questions are recorded");
            return;
        }
        results[recordedAnswers++] = correct;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedAnswers; i++) {
            if (results[i]) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard card = new Scorecard(4);
        card.recordAnswer(true);
        card.recordAnswer(true);
        card.recordAnswer(false);
        card.recordAnswer(true);
        System.out.println("Score: " + card.getScore());
    }
}
