package inheritance.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class ParkedVehicle {
    final String type;
    final int hours;
    ParkedVehicle(String type, int hours) { this.type = type; this.hours = hours; }
    abstract double charge();
}

class Bike extends ParkedVehicle {
    Bike(int hours) { super("BIKE", hours); }
    @Override double charge() { return 10.0 * hours; }
}

class Car extends ParkedVehicle {
    Car(int hours) { super("CAR", hours); }
    @Override double charge() { return 30 + 20.0 * (hours - 1); }
}

class Truck extends ParkedVehicle {
    Truck(int hours) { super("TRUCK", hours); }
    @Override double charge() { return Math.max(100, 50.0 * hours); }
}

public class ParkingChargeCalculator {
    private static ParkedVehicle create(String type, int hours) {
        switch (type) {
            case "BIKE": return new Bike(hours);
            case "CAR": return new Car(hours);
            case "TRUCK": return new Truck(hours);
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<ParkedVehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < count; i++) vehicles.add(create(input.next(), input.nextInt()));
        double total = 0;
        for (ParkedVehicle vehicle : vehicles) {
            double charge = vehicle.charge();
            System.out.printf(Locale.US, "%s: %.2f%n", vehicle.type, charge);
            total += charge;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
