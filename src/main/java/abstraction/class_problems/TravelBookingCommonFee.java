package abstraction.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class TravelBooking {
    private static final double BOOKING_FEE = 50.0;
    final String mode;
    final double distanceKm;
    TravelBooking(String mode, double distanceKm) { this.mode = mode; this.distanceKm = distanceKm; }
    abstract double baseFare();
    final double totalFare() { return baseFare() + BOOKING_FEE; }
}

class BusBooking extends TravelBooking {
    BusBooking(double distance) { super("BUS", distance); }
    @Override double baseFare() { return 2.0 * distanceKm; }
}

class TrainBooking extends TravelBooking {
    TrainBooking(double distance) { super("TRAIN", distance); }
    @Override double baseFare() { return 1.5 * distanceKm; }
}

class FlightBooking extends TravelBooking {
    FlightBooking(double distance) { super("FLIGHT", distance); }
    @Override double baseFare() { return 2500 + 4.0 * distanceKm; }
}

public class TravelBookingCommonFee {
    private static TravelBooking create(String mode, double distance) {
        switch (mode) {
            case "BUS": return new BusBooking(distance);
            case "TRAIN": return new TrainBooking(distance);
            case "FLIGHT": return new FlightBooking(distance);
            default: throw new IllegalArgumentException("Unknown travel mode: " + mode);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<TravelBooking> bookings = new ArrayList<>();
        for (int i = 0; i < count; i++) bookings.add(create(input.next(), input.nextDouble()));
        for (TravelBooking booking : bookings) {
            double fare = booking.totalFare();
            System.out.printf(Locale.US, "%s: %.2f%n", booking.mode, fare);
        }
    }
}
