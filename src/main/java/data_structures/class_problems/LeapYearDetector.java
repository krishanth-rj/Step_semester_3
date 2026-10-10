package data_structures.class_problems;

import java.util.Scanner;

public class LeapYearDetector {
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int year = input.nextInt();
            System.out.println(isLeapYear(year) ? "Leap year" : "Not a leap year");
        }
    }
}
