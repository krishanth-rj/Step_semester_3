package abstraction.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class LateLibraryItem {
    final String title;
    final int daysLate;
    LateLibraryItem(String title, int daysLate) { this.title = title; this.daysLate = daysLate; }
    abstract double fine();
}

class LateBook extends LateLibraryItem {
    LateBook(String title, int days) { super(title, days); }
    @Override double fine() { return 2.0 * daysLate; }
}

class LateDVD extends LateLibraryItem {
    LateDVD(String title, int days) { super(title, days); }
    @Override double fine() { return Math.min(50, 5.0 * daysLate); }
}

class LateMagazine extends LateLibraryItem {
    LateMagazine(String title, int days) { super(title, days); }
    @Override double fine() { return daysLate; }
}

public class LibraryLateFineCounter {
    private static LateLibraryItem create(Scanner input) {
        String type = input.next();
        String title = input.next();
        int days = input.nextInt();
        switch (type) {
            case "BOOK": return new LateBook(title, days);
            case "DVD": return new LateDVD(title, days);
            case "MAGAZINE": return new LateMagazine(title, days);
            default: throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<LateLibraryItem> items = new ArrayList<>();
        for (int i = 0; i < count; i++) items.add(create(input));
        double total = 0;
        for (LateLibraryItem item : items) {
            double fine = item.fine();
            System.out.printf(Locale.US, "%s: %.2f%n", item.title, fine);
            total += fine;
        }
        System.out.printf(Locale.US, "Total Fines: %.2f%n", total);
    }
}
