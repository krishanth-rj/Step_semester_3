package inheritance.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Journey {
    final String type;
    final double distance;
    Journey(String type, double distance) { this.type = type; this.distance = distance; }
    abstract double fare();
}

class BusJourney extends Journey {
    BusJourney(double distance) { super("BUS", distance); }
    @Override double fare() { return Math.min(10, 2 + 0.10 * distance); }
}

class TrainJourney extends Journey {
    TrainJourney(double distance) { super("TRAIN", distance); }
    @Override double fare() { return 3 + 0.15 * distance; }
}

class MetroJourney extends Journey {
    final double peakHourFactor;
    MetroJourney(double distance, double peakHourFactor) {
        super("METRO", distance); this.peakHourFactor = peakHourFactor;
    }
    @Override double fare() { return (1.50 + 0.20 * distance) * peakHourFactor; }
}

public class PublicTransportFareCalculator {
    private static Journey create(String type, double distance, double peakFactor) {
        switch (type) {
            case "BUS": return new BusJourney(distance);
            case "TRAIN": return new TrainJourney(distance);
            case "METRO": return new MetroJourney(distance, peakFactor);
            default: throw new IllegalArgumentException("Unknown transport type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String type = input.next();
            double distance = input.nextDouble();
            double factor = type.equals("METRO") ? input.nextDouble() : 1;
            journeys.add(create(type, distance, factor));
        }
        double total = 0;
        for (Journey journey : journeys) {
            double fare = journey.fare();
            System.out.printf(Locale.US, "%s: %.2f%n", journey.type, fare);
            total += fare;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
