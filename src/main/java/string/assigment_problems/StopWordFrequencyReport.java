package string.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StopWordFrequencyReport {
    private static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine().toLowerCase().replaceAll("[^\\p{L}\\p{N}\\s]", " ");
        Map<String, Integer> frequencies = new HashMap<>();
        for (String word : text.trim().split("\\s+")) {
            if (!word.isEmpty() && !STOP_WORDS.contains(word)) {
                frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequencies.entrySet());
        entries.sort(Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                .reversed().thenComparing(Map.Entry::getKey));
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
