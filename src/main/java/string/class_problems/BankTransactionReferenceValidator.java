package string.class_problems;

import java.util.Scanner;

public class BankTransactionReferenceValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter transaction reference (bank code followed by 11 digits): ");
        String reference = input.nextLine().trim().toUpperCase();
        if (reference.length() != 14) {
            System.out.println("Invalid reference: must contain exactly 14 characters.");
            return;
        }
        for (int i = 0; i < 3; i++) {
            char c = reference.charAt(i);
            if (c < 'A' || c > 'Z') {
                System.out.println("Invalid reference: first 3 characters must be letters.");
                return;
            }
        }
        for (int i = 3; i < 14; i++) {
            char c = reference.charAt(i);
            if (c < '0' || c > '9') {
                System.out.println("Invalid reference: last 11 characters must be digits.");
                return;
            }
        }
        String digits = reference.substring(3);
        String date = digits.substring(0, 6);
        String formattedDate = date.substring(0, 2) + "-" + date.substring(2, 4) + "-" + date.substring(4);
        String sequence = digits.substring(6);
        System.out.println("Bank code: " + reference.substring(0, 3));
        System.out.println("Date: " + formattedDate);
        System.out.println("Sequence number: " + sequence);
    }
}
