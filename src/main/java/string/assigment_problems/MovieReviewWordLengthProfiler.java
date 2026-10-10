package string.assigment_problems;

import java.util.Scanner;

public class MovieReviewWordLengthProfiler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a movie review: ");
        String review = input.nextLine().trim();
        int shortWords = 0, mediumWords = 0, longWords = 0;
        if (!review.isEmpty()) {
            for (String word : review.split("\\s+")) {
                int length = word.length();
                if (length <= 4) shortWords++;
                else if (length <= 8) mediumWords++;
                else longWords++;
            }
        }
        System.out.println("Short words (1-4 characters): " + shortWords);
        System.out.println("Medium words (5-8 characters): " + mediumWords);
        System.out.println("Long words (9+ characters): " + longWords);
    }
}
