package string.assigment_problems;

import java.util.Scanner;

public class WarehouseInventoryBalancer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number of warehouse sections: ");
        int sections = input.nextInt();
        if (sections <= 0) {
            System.out.println("Please enter at least one section.");
            return;
        }
        long[] totals = new long[sections];
        long highest = Long.MIN_VALUE;
        int highestSection = 0, highestIndex = 0;
        for (int section = 0; section < sections; section++) {
            System.out.print("Number of items in section " + (section + 1) + ": ");
            int count = input.nextInt();
            if (count < 0) {
                System.out.println("Item count cannot be negative.");
                return;
            }
            for (int index = 0; index < count; index++) {
                System.out.print("Quantity at position " + (index + 1) + ": ");
                int quantity = input.nextInt();
                if (quantity < 0) {
                    System.out.println("Quantity cannot be negative.");
                    return;
                }
                totals[section] += quantity;
                if (quantity > highest) {
                    highest = quantity;
                    highestSection = section;
                    highestIndex = index;
                }
            }
        }
        for (int i = 0; i < sections; i++) System.out.println("Section " + (i + 1) + " total: " + totals[i]);
        long minimum = totals[0], maximum = totals[0];
        for (long total : totals) { minimum = Math.min(minimum, total); maximum = Math.max(maximum, total); }
        System.out.println(minimum == maximum ? "Section totals are balanced." : "Section totals are not balanced.");
        if (highest == Long.MIN_VALUE) System.out.println("No inventory quantities were entered.");
        else System.out.println("Highest quantity: " + highest + " in section " + (highestSection + 1)
                + " at position " + (highestIndex + 1));
    }
}
