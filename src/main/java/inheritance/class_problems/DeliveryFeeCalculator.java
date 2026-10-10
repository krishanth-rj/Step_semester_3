package inheritance.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Delivery {
    final String type;
    final double weight;
    final double distance;
    Delivery(String type, double weight, double distance) {
        this.type = type; this.weight = weight; this.distance = distance;
    }
    abstract double fee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) { super("STANDARD", weight, distance); }
    @Override double fee() { return 5 + 0.50 * weight + 0.10 * distance; }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) { super("EXPRESS", weight, distance); }
    @Override double fee() { return 15 + weight + 0.20 * distance; }
}

class InternationalDelivery extends Delivery {
    final double customsFee;
    InternationalDelivery(double weight, double distance, double customsFee) {
        super("INTERNATIONAL", weight, distance); this.customsFee = customsFee;
    }
    @Override double fee() { return 25 + 2 * weight + 0.50 * distance + customsFee; }
}

public class DeliveryFeeCalculator {
    private static Delivery create(String type, double weight, double distance, double customs) {
        switch (type) {
            case "STANDARD": return new StandardDelivery(weight, distance);
            case "EXPRESS": return new ExpressDelivery(weight, distance);
            case "INTERNATIONAL": return new InternationalDelivery(weight, distance, customs);
            default: throw new IllegalArgumentException("Unknown delivery type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String type = input.next();
            double weight = input.nextDouble();
            double distance = input.nextDouble();
            double customs = type.equals("INTERNATIONAL") ? input.nextDouble() : 0;
            deliveries.add(create(type, weight, distance, customs));
        }
        double total = 0;
        for (Delivery delivery : deliveries) {
            double fee = delivery.fee();
            System.out.printf(Locale.US, "%s: %.2f%n", delivery.type, fee);
            total += fee;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
