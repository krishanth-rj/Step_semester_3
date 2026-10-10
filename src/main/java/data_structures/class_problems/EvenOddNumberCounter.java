package data_structures.class_problems;

import java.util.Scanner;

public class EvenOddNumberCounter {
    public static int[] countEvenOdd(int[] numbers) {
        int even = 0, odd = 0;
        for (int number : numbers) {
            if (number % 2 == 0) even++;
            else odd++;
        }
        return new int[] {even, odd};
    }

    public static void main(String[] args) {
        String line = new Scanner(System.in).nextLine().replace("[", "").replace("]", "").trim();
        if (line.isEmpty()) {
            System.out.println("Even: 0");
            System.out.println("Odd: 0");
            return;
        }
        String[] tokens = line.replace(",", " ").trim().split("\\s+");
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) numbers[i] = Integer.parseInt(tokens[i]);
        int[] result = countEvenOdd(numbers);
        System.out.println("Even: " + result[0]);
        System.out.println("Odd: " + result[1]);
    }
}
