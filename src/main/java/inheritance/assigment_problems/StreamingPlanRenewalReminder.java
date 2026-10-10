package inheritance.assigment_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class SubscriptionPlan {
    final String name;
    final LocalDate startDate;
    SubscriptionPlan(String name, LocalDate startDate) { this.name = name; this.startDate = startDate; }
    abstract int validityDays();
    LocalDate renewalDate() { return startDate.plusDays(validityDays()); }
}

class BasicPlan extends SubscriptionPlan {
    BasicPlan(String name, LocalDate date) { super(name, date); }
    @Override int validityDays() { return 30; }
}

class StandardPlan extends SubscriptionPlan {
    StandardPlan(String name, LocalDate date) { super(name, date); }
    @Override int validityDays() { return 90; }
}

class PremiumPlan extends SubscriptionPlan {
    PremiumPlan(String name, LocalDate date) { super(name, date); }
    @Override int validityDays() { return 365; }
}

public class StreamingPlanRenewalReminder {
    private static SubscriptionPlan create(String type, String name, LocalDate date) {
        switch (type) {
            case "BASIC": return new BasicPlan(name, date);
            case "STANDARD": return new StandardPlan(name, date);
            case "PREMIUM": return new PremiumPlan(name, date);
            default: throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = Integer.parseInt(input.nextLine().trim());
        List<SubscriptionPlan> plans = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] fields = input.nextLine().trim().split("\\s+");
            plans.add(create(fields[0], fields[1], LocalDate.parse(fields[2])));
        }
        for (SubscriptionPlan plan : plans) System.out.println(plan.name + ": " + plan.renewalDate());
    }
}
