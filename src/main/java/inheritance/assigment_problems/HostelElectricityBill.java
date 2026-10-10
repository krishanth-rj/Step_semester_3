package inheritance.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class HostelRoom {
    final String type;
    final int units;
    HostelRoom(String type, int units) { this.type = type; this.units = units; }
    abstract double bill();
}

class SingleRoom extends HostelRoom {
    SingleRoom(int units) { super("SINGLE", units); }
    @Override double bill() { return 8.0 * units; }
}

class SharedRoom extends HostelRoom {
    final int occupants;
    SharedRoom(int units, int occupants) { super("SHARED", units); this.occupants = occupants; }
    @Override double bill() { return 6.0 * units / occupants; }
}

class AIRoom extends HostelRoom {
    AIRoom(int units) { super("AC", units); }
    @Override double bill() { return 10.0 * units + 200; }
}

public class HostelElectricityBill {
    private static HostelRoom create(String type, int units, int occupants) {
        switch (type) {
            case "SINGLE": return new SingleRoom(units);
            case "SHARED": return new SharedRoom(units, occupants);
            case "AC": return new AIRoom(units);
            default: throw new IllegalArgumentException("Unknown room type: " + type);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<HostelRoom> rooms = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String type = input.next();
            int units = input.nextInt();
            int occupants = type.equals("SHARED") ? input.nextInt() : 0;
            rooms.add(create(type, units, occupants));
        }
        double total = 0;
        for (HostelRoom room : rooms) {
            double bill = room.bill();
            System.out.printf(Locale.US, "%s: %.2f%n", room.type, bill);
            total += bill;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
