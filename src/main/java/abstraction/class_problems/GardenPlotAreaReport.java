package abstraction.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Plot {
    final String owner;
    final String shape;
    Plot(String owner, String shape) { this.owner = owner; this.shape = shape; }
    abstract double area();
}

class CirclePlot extends Plot {
    final double radius;
    CirclePlot(String owner, double radius) { super(owner, "CIRCLE"); this.radius = radius; }
    @Override double area() { return Math.PI * radius * radius; }
}

class RectanglePlot extends Plot {
    final double length, width;
    RectanglePlot(String owner, double length, double width) {
        super(owner, "RECTANGLE"); this.length = length; this.width = width;
    }
    @Override double area() { return length * width; }
}

class TrianglePlot extends Plot {
    final double base, height;
    TrianglePlot(String owner, double base, double height) {
        super(owner, "TRIANGLE"); this.base = base; this.height = height;
    }
    @Override double area() { return 0.5 * base * height; }
}

public class GardenPlotAreaReport {
    private static Plot create(Scanner input) {
        String shape = input.next();
        String owner = input.next();
        switch (shape) {
            case "CIRCLE": return new CirclePlot(owner, input.nextDouble());
            case "RECTANGLE": return new RectanglePlot(owner, input.nextDouble(), input.nextDouble());
            case "TRIANGLE": return new TrianglePlot(owner, input.nextDouble(), input.nextDouble());
            default: throw new IllegalArgumentException("Unknown plot shape: " + shape);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < count; i++) plots.add(create(input));
        double total = 0;
        for (Plot plot : plots) {
            double area = plot.area();
            System.out.printf(Locale.US, "%s (%s): %.2f%n", plot.owner, plot.shape, area);
            total += area;
        }
        System.out.printf(Locale.US, "Total Area: %.2f%n", total);
    }
}
