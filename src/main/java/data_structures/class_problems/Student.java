package data_structures.class_problems;

import java.util.Arrays;
import java.util.Locale;

public class Student {
    private final String name;
    private final int[] marks;

    public Student(String name, int[] marks) {
        if (marks.length != 3) throw new IllegalArgumentException("Exactly three marks are required.");
        this.name = name;
        this.marks = Arrays.copyOf(marks, marks.length);
    }

    public double average() {
        return (marks[0] + marks[1] + marks[2]) / 3.0;
    }

    // The PDF leaves A and C boundaries to the student; these match Problem 8's grade scale.
    public char grade() {
        double average = average();
        if (average >= 90) return 'A';
        if (average >= 75) return 'B';
        if (average >= 60) return 'C';
        if (average >= 40) return 'D';
        return 'F';
    }

    public String resultLine() {
        return String.format(Locale.US, "%s: Average %.1f, Grade %c", name.toUpperCase(Locale.ROOT), average(), grade());
    }

    public static void main(String[] args) {
        System.out.println(new Student("Asha", new int[] {80, 90, 70}).resultLine());
        System.out.println(new Student("Ravi", new int[] {60, 55, 50}).resultLine());
    }
}
