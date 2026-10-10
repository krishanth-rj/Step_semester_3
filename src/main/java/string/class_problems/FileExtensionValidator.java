package string.class_problems;

import java.util.Scanner;

public class FileExtensionValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = input.nextLine().trim();
        int dot = filename.lastIndexOf('.');
        String extension = dot >= 0 ? filename.substring(dot + 1) : "";
        if (extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {
            System.out.println("Accepted file extension: " + extension);
        } else {
            System.out.println("Unsupported file extension.");
        }
    }
}
