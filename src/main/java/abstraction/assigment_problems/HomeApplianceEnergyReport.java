package abstraction.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface SaverMode {
    default double applySaver(double units) { return units * 0.75; }
}

abstract class Appliance {
    final String type;
    final double powerWatts;
    final double hours;
    Appliance(String type, double powerWatts, double hours) {
        this.type = type; this.powerWatts = powerWatts; this.hours = hours;
    }
    final double units() { return powerWatts * hours / 1000.0; }
}

class Fridge extends Appliance {
    Fridge(double hours) { super("FRIDGE", 150, hours); }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) { super("AC", 1500, hours); }
}

class Television extends Appliance {
    Television(double hours) { super("TV", 100, hours); }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) { super("WASHER", 500, hours); }
}

class ApplianceUsage {
    final Appliance appliance;
    final boolean saverRequested;
    ApplianceUsage(Appliance appliance, boolean saverRequested) {
        this.appliance = appliance; this.saverRequested = saverRequested;
    }
    boolean supportsRequestedMode() { return !saverRequested || appliance instanceof SaverMode; }
    double units() {
        double normalUnits = appliance.units();
        return saverRequested ? ((SaverMode) appliance).applySaver(normalUnits) : normalUnits;
    }
}

public class HomeApplianceEnergyReport {
    private static Appliance create(String type, double hours) {
        switch (type) {
            case "FRIDGE": return new Fridge(hours);
            case "AC": return new AirConditioner(hours);
            case "TV": return new Television(hours);
            case "WASHER": return new WashingMachine(hours);
            default: throw new IllegalArgumentException("Unknown appliance: " + type);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<ApplianceUsage> usages = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String type = input.next();
            double hours = input.nextDouble();
            boolean saver = input.hasNext("SAVER");
            if (saver) input.next();
            usages.add(new ApplianceUsage(create(type, hours), saver));
        }
        double totalCost = 0;
        for (ApplianceUsage usage : usages) {
            if (!usage.supportsRequestedMode()) {
                System.out.println(usage.appliance.type + ": saver mode not supported");
                continue;
            }
            double units = usage.units();
            double cost = units * 8;
            System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", usage.appliance.type, units, cost);
            totalCost += cost;
        }
        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
    }
}
