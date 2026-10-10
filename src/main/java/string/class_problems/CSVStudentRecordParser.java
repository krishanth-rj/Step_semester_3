package string.class_problems;

import java.util.Scanner;

public class CSVStudentRecordParser {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Name,RollNumber,Department: ");
        String[] fields = input.nextLine().split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Student Record");
        System.out.println("Name: " + fields[0].trim());
        System.out.println("Roll Number: " + fields[1].trim());
        System.out.println("Department: " + fields[2].trim());
    }
}
