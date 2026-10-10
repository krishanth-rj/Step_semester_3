package string.assigment_problems;

import java.util.Scanner;

public class ExamHallSeatDuplicationChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number of assigned seats: ");
        int count = input.nextInt();
        if (count < 0) {
            System.out.println("Count cannot be negative.");
            return;
        }
        String[] seats = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Seat " + (i + 1) + ": ");
            seats[i] = input.next();
        }
        boolean found = false;
        for (int i = 0; i < seats.length; i++) {
            for (int j = i + 1; j < seats.length; j++) {
                if (seats[i].equalsIgnoreCase(seats[j])) {
                    System.out.println("Duplicate seat: " + seats[i] + " at positions " + (i + 1) + " and " + (j + 1));
                    found = true;
                }
            }
        }
        if (!found) System.out.println("No duplicate seats found.");
    }
}
