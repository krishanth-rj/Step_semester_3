package string.assigment_problems;

import java.util.Scanner;

public class TypingSpeedTestAccuracyChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Reference text: ");
        String reference = input.nextLine();
        System.out.print("Typed text: ");
        String typed = input.nextLine();
        int matches = 0;
        int firstMismatch = -1;
        for (int i = 0; i < Math.max(reference.length(), typed.length()); i++) {
            boolean match = i < reference.length() && i < typed.length()
                    && reference.charAt(i) == typed.charAt(i);
            if (match) matches++;
            else if (firstMismatch == -1) firstMismatch = i;
        }
        double accuracy = reference.isEmpty() ? (typed.isEmpty() ? 100.0 : 0.0)
                : matches * 100.0 / reference.length();
        System.out.println("Matching characters: " + matches);
        System.out.printf("Accuracy: %.2f%%%n", accuracy);
        if (firstMismatch == -1) System.out.println("No mismatch found.");
        else System.out.println("First mismatch at position " + (firstMismatch + 1));
    }
}
