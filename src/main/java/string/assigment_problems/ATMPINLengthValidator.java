package string.assigment_problems;

import java.util.Scanner;

public class ATMPINLengthValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ATM PIN: ");
        String pin = input.nextLine();
        if (pin.length() == 4) System.out.println("Valid PIN length.");
        else System.out.println("Invalid PIN length.");
    }
}
