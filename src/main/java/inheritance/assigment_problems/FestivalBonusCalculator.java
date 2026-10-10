package inheritance.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class BonusEmployee {
    final String name;
    final double monthlySalary;
    BonusEmployee(String name, double monthlySalary) { this.name = name; this.monthlySalary = monthlySalary; }
    abstract double bonus();
}

class FullTimeEmployee extends BonusEmployee {
    FullTimeEmployee(String name, double salary) { super(name, salary); }
    @Override double bonus() { return monthlySalary * 0.10; }
}

class PartTimeEmployee extends BonusEmployee {
    PartTimeEmployee(String name, double salary) { super(name, salary); }
    @Override double bonus() { return monthlySalary * 0.05; }
}

class InternEmployee extends BonusEmployee {
    InternEmployee(String name, double salary) { super(name, salary); }
    @Override double bonus() { return 2000; }
}

public class FestivalBonusCalculator {
    private static BonusEmployee create(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME": return new FullTimeEmployee(name, salary);
            case "PARTTIME": return new PartTimeEmployee(name, salary);
            case "INTERN": return new InternEmployee(name, salary);
            default: throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<BonusEmployee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++) employees.add(create(input.next(), input.next(), input.nextDouble()));
        double total = 0;
        for (BonusEmployee employee : employees) {
            double bonus = employee.bonus();
            System.out.printf(Locale.US, "%s: %.2f%n", employee.name, bonus);
            total += bonus;
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
    }
}
