package inheritance.class_problems;

import inheritance.common.QuotedFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class ExamQuestion {
    final String type;
    final String correctAnswer;
    final String studentAnswer;
    final double points;
    ExamQuestion(String type, String correctAnswer, String studentAnswer, double points) {
        this.type = type; this.correctAnswer = correctAnswer; this.studentAnswer = studentAnswer; this.points = points;
    }
    abstract double score();
}

class MultipleChoiceQuestion extends ExamQuestion {
    MultipleChoiceQuestion(String correct, String answer, double points) { super("MCQ", correct, answer, points); }
    @Override double score() { return correctAnswer.equals(studentAnswer) ? points : 0; }
}

class TrueFalseQuestion extends ExamQuestion {
    TrueFalseQuestion(String correct, String answer, double points) { super("TF", correct, answer, points); }
    @Override double score() { return correctAnswer.equals(studentAnswer) ? points : 0; }
}

class EssayQuestion extends ExamQuestion {
    EssayQuestion(String correct, String answer, double points) { super("ESSAY", correct, answer, points); }
    @Override double score() {
        int matchedKeywords = 0;
        String lowerAnswer = studentAnswer.toLowerCase(Locale.ROOT);
        for (String keyword : correctAnswer.split(",")) {
            if (lowerAnswer.contains(keyword.trim().toLowerCase(Locale.ROOT))) matchedKeywords++;
        }
        if (matchedKeywords >= 2) return points * 0.75;
        if (matchedKeywords == 1) return points * 0.50;
        return 0;
    }
}

public class ExaminationQuestionGrader {
    private static ExamQuestion create(String[] fields) {
        String type = fields[0];
        String correct = fields[2];
        String answer = fields[3];
        double points = Double.parseDouble(fields[4]);
        switch (type) {
            case "MCQ": return new MultipleChoiceQuestion(correct, answer, points);
            case "TF": return new TrueFalseQuestion(correct, answer, points);
            case "ESSAY": return new EssayQuestion(correct, answer, points);
            default: throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = Integer.parseInt(input.nextLine().trim());
        List<ExamQuestion> questions = new ArrayList<>();
        for (int i = 0; i < count; i++) questions.add(create(QuotedFields.parse(input.nextLine())));
        double total = 0;
        for (ExamQuestion question : questions) {
            double score = question.score();
            System.out.printf(Locale.US, "%s: %.2f%n", question.type, score);
            total += score;
        }
        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
    }
}
