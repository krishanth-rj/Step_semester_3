package abstraction.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class CollegeStudent {
    final String name;
    CollegeStudent(String name) { this.name = name; }
    abstract double tuition();
    abstract double additionalFee();
    abstract boolean usesBus();
    final double totalFee() { return tuition() + additionalFee() + (usesBus() ? 12000 : 0); }
}

class DayScholar extends CollegeStudent {
    DayScholar(String name) { super(name); }
    @Override double tuition() { return 40000; }
    @Override double additionalFee() { return 0; }
    @Override boolean usesBus() { return true; }
}

class Hosteller extends CollegeStudent {
    Hosteller(String name) { super(name); }
    @Override double tuition() { return 40000; }
    @Override double additionalFee() { return 60000; }
    @Override boolean usesBus() { return false; }
}

class ScholarshipStudent extends CollegeStudent {
    ScholarshipStudent(String name) { super(name); }
    @Override double tuition() { return 20000; }
    @Override double additionalFee() { return 0; }
    @Override boolean usesBus() { return true; }
}

public class CollegeFeeCounter {
    private static CollegeStudent create(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR": return new DayScholar(name);
            case "HOSTELLER": return new Hosteller(name);
            case "SCHOLAR": return new ScholarshipStudent(name);
            default: throw new IllegalArgumentException("Unknown student type: " + type);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<CollegeStudent> students = new ArrayList<>();
        for (int i = 0; i < count; i++) students.add(create(input.next(), input.next()));
        double total = 0;
        for (CollegeStudent student : students) {
            double fee = student.totalFee();
            System.out.printf(Locale.US, "%s: %.2f%n", student.name, fee);
            total += fee;
        }
        System.out.printf(Locale.US, "Total Collected: %.2f%n", total);
    }
}
