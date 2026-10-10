package abstraction.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface Insurable {
    double insuranceAmount();
}

abstract class Parcel {
    final String type;
    final double weightKg;
    final double declaredValue;
    Parcel(String type, double weightKg, double declaredValue) {
        this.type = type; this.weightKg = weightKg; this.declaredValue = declaredValue;
    }
    abstract double shippingCharge();
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double value) { super("STANDARD", weight, value); }
    @Override double shippingCharge() { return 40 + 10 * weightKg; }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double value) { super("EXPRESS", weight, value); }
    @Override double shippingCharge() { return 80 + 15 * weightKg; }
    @Override public double insuranceAmount() { return declaredValue * 0.02; }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double value) { super("FRAGILE", weight, value); }
    @Override double shippingCharge() { return 40 + 10 * weightKg + 50; }
    @Override public double insuranceAmount() { return declaredValue * 0.02; }
}

public class ParcelShippingDesk {
    private static Parcel create(String type, double weight, double value) {
        switch (type) {
            case "STANDARD": return new StandardParcel(weight, value);
            case "EXPRESS": return new ExpressParcel(weight, value);
            case "FRAGILE": return new FragileParcel(weight, value);
            default: throw new IllegalArgumentException("Unknown parcel type: " + type);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < count; i++) parcels.add(create(input.next(), input.nextDouble(), input.nextDouble()));
        double grandTotal = 0;
        for (Parcel parcel : parcels) {
            double charge = parcel.shippingCharge();
            double insurance = parcel instanceof Insurable ? ((Insurable) parcel).insuranceAmount() : 0;
            double total = charge + insurance;
            System.out.printf(Locale.US, "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.type, charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
    }
}
