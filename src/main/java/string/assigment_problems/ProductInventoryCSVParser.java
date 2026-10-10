package string.assigment_problems;

import java.util.Scanner;

public class ProductInventoryCSVParser {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ProductName,SKU,Quantity: ");
        String[] fields = input.nextLine().split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Product Record");
        System.out.println("Product Name: " + fields[0].trim());
        System.out.println("SKU: " + fields[1].trim());
        System.out.println("Quantity: " + fields[2].trim());
    }
}
