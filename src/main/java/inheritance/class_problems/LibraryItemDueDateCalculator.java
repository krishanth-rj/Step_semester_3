package inheritance.class_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    final String title;
    LibraryItem(String title) { this.title = title; }
    abstract int borrowingDays();
    LocalDate dueDate(LocalDate borrowedOn) { return borrowedOn.plusDays(borrowingDays()); }
}

class BookItem extends LibraryItem {
    BookItem(String title) { super(title); }
    @Override int borrowingDays() { return 14; }
}

class DVDItem extends LibraryItem {
    DVDItem(String title) { super(title); }
    @Override int borrowingDays() { return 7; }
}

class MagazineItem extends LibraryItem {
    MagazineItem(String title) { super(title); }
    @Override int borrowingDays() { return 3; }
}

public class LibraryItemDueDateCalculator {
    private static LibraryItem createItem(String type, String title) {
        switch (type) {
            case "BOOK": return new BookItem(title);
            case "DVD": return new DVDItem(title);
            case "MAGAZINE": return new MagazineItem(title);
            default: throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = Integer.parseInt(input.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] fields = inheritance.common.QuotedFields.parse(input.nextLine());
            items.add(createItem(fields[0], fields[1]));
        }
        LocalDate referenceDate = LocalDate.of(2023, 10, 26);
        for (LibraryItem item : items) System.out.println(item.title + ": " + item.dueDate(referenceDate));
    }
}
