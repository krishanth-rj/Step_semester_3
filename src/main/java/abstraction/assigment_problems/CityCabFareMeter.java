package abstraction.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface NightService {
    default double applyNightService(double fare) { return fare * 1.20; }
}

abstract class Cab {
    final String type;
    final double ratePerKm;
    Cab(String type, double ratePerKm) { this.type = type; this.ratePerKm = ratePerKm; }
    final double fare(double distanceKm) { return Math.max(100, distanceKm * ratePerKm); }
}

class MiniCab extends Cab {
    MiniCab() { super("MINI", 10); }
}

class SedanCab extends Cab implements NightService {
    SedanCab() { super("SEDAN", 14); }
}

class SUVCab extends Cab implements NightService {
    SUVCab() { super("SUV", 18); }
}

class CabTrip {
    final Cab cab;
    final double distance;
    final boolean atNight;
    CabTrip(Cab cab, double distance, boolean atNight) {
        this.cab = cab; this.distance = distance; this.atNight = atNight;
    }
    boolean isAvailable() { return !atNight || cab instanceof NightService; }
    double fare() {
        double base = cab.fare(distance);
        return atNight ? ((NightService) cab).applyNightService(base) : base;
    }
}

public class CityCabFareMeter {
    private static Cab create(String type) {
        switch (type) {
            case "MINI": return new MiniCab();
            case "SEDAN": return new SedanCab();
            case "SUV": return new SUVCab();
            default: throw new IllegalArgumentException("Unknown cab type: " + type);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<CabTrip> trips = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String type = input.next();
            double distance = input.nextDouble();
            boolean night = input.next().equals("NIGHT");
            trips.add(new CabTrip(create(type), distance, night));
        }
        double total = 0;
        for (CabTrip trip : trips) {
            if (!trip.isAvailable()) {
                System.out.println(trip.cab.type + ": night service not available");
            } else {
                double fare = trip.fare();
                System.out.printf(Locale.US, "%s: %.2f%n", trip.cab.type, fare);
                total += fare;
            }
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
