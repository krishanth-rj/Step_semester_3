package string.class_problems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {
    public static Character firstNonRepeating(String text) {
        Map<Character, Integer> counts = new LinkedHashMap<>();
        for (char character : text.toCharArray()) counts.put(character, counts.getOrDefault(character, 0) + 1);
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        Character result = firstNonRepeating(input.nextLine());
        if (result == null) System.out.println("No non-repeating character found.");
        else System.out.println("First non-repeating character: " + result);
    }
}
