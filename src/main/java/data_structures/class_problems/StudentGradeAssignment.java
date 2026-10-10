package data_structures.class_problems;

import java.util.Scanner;

public class StudentGradeAssignment {
    public static char gradeFor(int marks) {
        if (marks >= 90) return 'A';
        if (marks >= 75) return 'B';
        if (marks >= 60) return 'C';
        if (marks >= 40) return 'D';
        return 'F';
    }

    public static void main(String[] args) {
        int marks = new Scanner(System.in).nextInt();
        System.out.println("Grade " + gradeFor(marks));
    }
}
