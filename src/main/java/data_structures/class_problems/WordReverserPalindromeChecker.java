package data_structures.class_problems;

import java.util.Scanner;

public class WordReverserPalindromeChecker {
    public static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    public static boolean isPalindrome(String word) {
        return word.equals(reverse(word));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String word = input.next();
            String reversed = reverse(word);
            System.out.println(reversed + (word.equals(reversed) ? " - palindrome" : " - not a palindrome"));
        }
    }
}
