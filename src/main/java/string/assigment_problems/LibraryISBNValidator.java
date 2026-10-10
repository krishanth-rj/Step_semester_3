package string.assigment_problems;

import java.util.Scanner;

public class LibraryISBNValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ISBN (3 letters and 10 digits): ");
        String isbn = input.nextLine().trim().toUpperCase();
        if (isbn.length() != 13) {
            System.out.println("Invalid ISBN: must contain exactly 13 characters.");
            return;
        }
        for (int i = 0; i < 3; i++) {
            char c = isbn.charAt(i);
            if (c < 'A' || c > 'Z') {
                System.out.println("Invalid ISBN: first 3 characters must be letters.");
                return;
            }
        }
        for (int i = 3; i < 13; i++) {
            char c = isbn.charAt(i);
            if (c < '0' || c > '9') {
                System.out.println("Invalid ISBN: last 10 characters must be digits.");
                return;
            }
        }
        System.out.println("Publisher code: " + isbn.substring(0, 3));
        System.out.println("Year: " + isbn.substring(3, 7));
        System.out.println("Catalog number: " + isbn.substring(7));
    }
}
