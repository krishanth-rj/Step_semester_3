package string.class_problems;

import java.util.Scanner;

public class MaskedPhoneNumberFormatter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a 10-digit phone number: ");
        String phone = input.nextLine();
        boolean valid = phone.length() == 10;
        for (int i = 0; valid && i < phone.length(); i++) {
            if (phone.charAt(i) < '0' || phone.charAt(i) > '9') valid = false;
        }
        if (!valid) {
            System.out.println("Invalid phone number.");
            return;
        }
        StringBuilder formatted = new StringBuilder("XXXXXX-");
        formatted.append(phone.substring(6));
        System.out.println("Masked phone number: " + formatted);
    }
}
