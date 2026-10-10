package inheritance.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class CanteenCustomer {
    final String type;
    final double bill;
    CanteenCustomer(String type, double bill) { this.type = type; this.bill = bill; }
    abstract double finalAmount();
}

class StudentCustomer extends CanteenCustomer {
    StudentCustomer(double bill) { super("STUDENT", bill); }
    @Override double finalAmount() { return bill * 0.90; }
}

class StaffCustomer extends CanteenCustomer {
    StaffCustomer(double bill) { super("STAFF", bill); }
    @Override double finalAmount() { return bill * 0.95; }
}

class GuestCustomer extends CanteenCustomer {
    GuestCustomer(double bill) { super("GUEST", bill); }
    @Override double finalAmount() { return bill + 10; }
}

public class CanteenBillingCounter {
    private static CanteenCustomer create(String type, double amount) {
        switch (type) {
            case "STUDENT": return new StudentCustomer(amount);
            case "STAFF": return new StaffCustomer(amount);
            case "GUEST": return new GuestCustomer(amount);
            default: throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<CanteenCustomer> bills = new ArrayList<>();
        for (int i = 0; i < count; i++) bills.add(create(input.next(), input.nextDouble()));
        double total = 0;
        for (CanteenCustomer customer : bills) {
            double amount = customer.finalAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", customer.type, amount);
            total += amount;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
