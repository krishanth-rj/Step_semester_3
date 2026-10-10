package string.class_problems;

import java.util.Scanner;

public class BMICalculator {
    private static String category(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25.0) return "Normal weight";
        if (bmi < 30.0) return "Overweight";
        return "Obese";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number of team members: ");
        int count = input.nextInt();
        if (count <= 0) {
            System.out.println("Please enter a positive number of people.");
            return;
        }
        for (int i = 1; i <= count; i++) {
            System.out.print("Person " + i + " name: ");
            String name = input.next();
            System.out.print("Weight in kg: ");
            double weight = input.nextDouble();
            System.out.print("Height in metres: ");
            double height = input.nextDouble();
            if (weight <= 0 || height <= 0) {
                System.out.println("Weight and height must be positive.");
                i--;
                continue;
            }
            double bmi = weight / (height * height);
            System.out.printf("%s: BMI %.2f (%s)%n", name, bmi, category(bmi));
        }
    }
}
