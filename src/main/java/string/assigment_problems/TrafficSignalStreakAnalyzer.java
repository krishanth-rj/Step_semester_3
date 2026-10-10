package string.assigment_problems;

import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number of recorded signals: ");
        int count = input.nextInt();
        if (count <= 0) {
            System.out.println("Please enter at least one signal.");
            return;
        }
        String[] signals = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Signal " + (i + 1) + " (red/yellow/green): ");
            signals[i] = input.next().toLowerCase();
        }
        String bestColor = signals[0], currentColor = signals[0];
        int bestLength = 1, currentLength = 1, bestStart = 0;
        for (int i = 1; i < count; i++) {
            if (signals[i].equals(currentColor)) currentLength++;
            else { currentColor = signals[i]; currentLength = 1; }
            if (currentLength > bestLength) {
                bestLength = currentLength;
                bestColor = currentColor;
                bestStart = i - currentLength + 1;
            }
        }
        System.out.println("Longest streak: " + bestColor + " for " + bestLength + " consecutive signals.");
        System.out.println("Positions " + (bestStart + 1) + " to " + (bestStart + bestLength) + ".");
    }
}
