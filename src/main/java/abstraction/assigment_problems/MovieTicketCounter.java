package abstraction.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class MovieTicket {
    private static final double CONVENIENCE_FEE = 20.0;
    final String seat;
    final int count;
    MovieTicket(String seat, int count) { this.seat = seat; this.count = count; }
    abstract double ticketPrice();
    final double bookingAmount() { return count * (ticketPrice() + CONVENIENCE_FEE); }
}

class RegularTicket extends MovieTicket {
    RegularTicket(int count) { super("REGULAR", count); }
    @Override double ticketPrice() { return 150; }
}

class PremiumTicket extends MovieTicket {
    PremiumTicket(int count) { super("PREMIUM", count); }
    @Override double ticketPrice() { return 250; }
}

class ReclinerTicket extends MovieTicket {
    ReclinerTicket(int count) { super("RECLINER", count); }
    @Override double ticketPrice() { return 400; }
}

public class MovieTicketCounter {
    private static MovieTicket create(String seat, int count) {
        switch (seat) {
            case "REGULAR": return new RegularTicket(count);
            case "PREMIUM": return new PremiumTicket(count);
            case "RECLINER": return new ReclinerTicket(count);
            default: throw new IllegalArgumentException("Unknown seat type: " + seat);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        List<MovieTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) tickets.add(create(input.next(), input.nextInt()));
        double total = 0;
        for (MovieTicket ticket : tickets) {
            double amount = ticket.bookingAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", ticket.seat, amount);
            total += amount;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
