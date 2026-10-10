package abstraction.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class ElectricityConnection {
    final String type;
    final int units;
    ElectricityConnection(String type, int units) { this.type = type; this.units = units; }
    abstract double bill();
}

class HomeConnection extends ElectricityConnection {
    HomeConnection(int units) { super("HOME", units); }
    @Override double bill() { return Math.min(units, 100) * 5.0 + Math.max(0, units - 100) * 7.0; }
}

class ShopConnection extends ElectricityConnection {
    ShopConnection(int units) { super("SHOP", units); }
    @Override double bill() { return 8.0 * units + 100; }
}

class FactoryConnection extends ElectricityConnection {
    FactoryConnection(int units) { super("FACTORY", units); }
    @Override double bill() { return Math.max(1000, 6.0 * units); }
}

public class ElectricityConnectionBilling {
    private static ElectricityConnection create(String type, int units) {
        switch (type) {
            case "HOME": return new HomeConnection(units);
            case "SHOP": return new ShopConnection(units);
            case "FACTORY": return new FactoryConnection(units);
            default: throw new IllegalArgumentException("Unknown connection type: " + type);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<ElectricityConnection> connections = new ArrayList<>();
        for (int i = 0; i < count; i++) connections.add(create(input.next(), input.nextInt()));
        double total = 0;
        for (ElectricityConnection connection : connections) {
            double bill = connection.bill();
            System.out.printf(Locale.US, "%s: %.2f%n", connection.type, bill);
            total += bill;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
