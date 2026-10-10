package string.class_problems;

import java.util.Scanner;

public class ReverseCustomerName {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String name = input.nextLine();
        System.out.println("Original name: " + name);
        System.out.println("Reversed name: " + new StringBuilder(name).reverse());
    }
}
