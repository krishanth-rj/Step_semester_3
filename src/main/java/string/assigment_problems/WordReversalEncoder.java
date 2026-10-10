package string.assigment_problems;

import java.util.Scanner;

public class WordReversalEncoder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine().trim();
        String[] words = sentence.isEmpty() ? new String[0] : sentence.split("\\s+");
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            StringBuilder reversed = new StringBuilder();
            for (int j = words[i].length() - 1; j >= 0; j--) reversed.append(words[i].charAt(j));
            if (i > 0) encoded.append(' ');
            encoded.append(reversed);
        }
        System.out.println("Encoded sentence: " + encoded);
    }
}
