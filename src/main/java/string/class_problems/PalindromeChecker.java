package string.class_problems;

import java.util.Scanner;

public class PalindromeChecker {
    private static String normalize(String text) {
        return text.replaceAll("[^\\p{Alnum}]", "").toLowerCase();
    }

    private static boolean iterative(String text) {
        for (int left = 0, right = text.length() - 1; left < right; left++, right--) {
            if (text.charAt(left) != text.charAt(right)) return false;
        }
        return true;
    }

    private static boolean recursive(String text, int left, int right) {
        if (left >= right) return true;
        return text.charAt(left) == text.charAt(right) && recursive(text, left + 1, right - 1);
    }

    private static boolean arrayReversal(String text) {
        char[] reversed = text.toCharArray();
        for (int left = 0, right = reversed.length - 1; left < right; left++, right--) {
            char temp = reversed[left]; reversed[left] = reversed[right]; reversed[right] = temp;
        }
        return text.equals(new String(reversed));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = normalize(input.nextLine());
        System.out.println("Iterative: " + iterative(text));
        System.out.println("Recursive: " + recursive(text, 0, text.length() - 1));
        System.out.println("Array reversal: " + arrayReversal(text));
    }
}
