package data_structures.class_problems;

import java.util.Scanner;

public class VowelAndConsonantCounter {
    public static int[] countLetters(String word) {
        int vowels = 0, consonants = 0;
        for (char value : word.toCharArray()) {
            char letter = Character.toLowerCase(value);
            if ("aeiou".indexOf(letter) >= 0) vowels++;
            else consonants++;
        }
        return new int[] {vowels, consonants};
    }

    public static void main(String[] args) {
        String word = new Scanner(System.in).next();
        int[] counts = countLetters(word);
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
    }
}
