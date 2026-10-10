package string.class_problems;

import java.util.Scanner;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();
        int vowels = 0, consonants = 0;
        for (char value : text.toCharArray()) {
            char letter = Character.toLowerCase(value);
            if (letter >= 'a' && letter <= 'z') {
                if ("aeiou".indexOf(letter) >= 0) vowels++;
                else consonants++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
