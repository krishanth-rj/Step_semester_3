package abstraction.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class StaffMember {
    final String name;
    StaffMember(String name) { this.name = name; }
    abstract double weeklyPay();
}

class FullTimeStaff extends StaffMember {
    final double weeklySalary;
    FullTimeStaff(String name, double salary) { super(name); weeklySalary = salary; }
    @Override double weeklyPay() { return weeklySalary; }
}

class HourlyStaff extends StaffMember {
    final double hours, rate;
    HourlyStaff(String name, double hours, double rate) { super(name); this.hours = hours; this.rate = rate; }
    @Override double weeklyPay() {
        double regularHours = Math.min(hours, 40);
        double overtimeHours = Math.max(0, hours - 40);
        return regularHours * rate + overtimeHours * rate * 1.5;
    }
}

class InternStaff extends StaffMember {
    final double stipend;
    InternStaff(String name, double stipend) { super(name); this.stipend = stipend; }
    @Override double weeklyPay() { return stipend; }
}

public class WeeklyStaffPay {
    private static StaffMember create(Scanner input) {
        String type = input.next();
        switch (type) {
            case "FULLTIME": return new FullTimeStaff(input.next(), input.nextDouble());
            case "HOURLY": return new HourlyStaff(input.next(), input.nextDouble(), input.nextDouble());
            case "INTERN": return new InternStaff(input.next(), input.nextDouble());
            default: throw new IllegalArgumentException("Unknown staff type: " + type);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<StaffMember> staff = new ArrayList<>();
        for (int i = 0; i < count; i++) staff.add(create(input));
        double total = 0;
        for (StaffMember member : staff) {
            double pay = member.weeklyPay();
            System.out.printf(Locale.US, "%s: %.2f%n", member.name, pay);
            total += pay;
        }
        System.out.printf(Locale.US, "Total Payroll: %.2f%n", total);
    }
}
