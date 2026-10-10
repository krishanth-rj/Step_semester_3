package inheritance.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Payment {
    final String type;
    final double amount;

    Payment(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    abstract double adjustedAmount();
}

class CardPayment extends Payment {
    CardPayment(double amount) { super("CARD", amount); }
    @Override double adjustedAmount() { return amount * 1.02; }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) { super("WALLET", amount); }
    @Override double adjustedAmount() { return amount * 1.01; }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) { super("BANKTRANSFER", amount); }
    @Override double adjustedAmount() { return amount; }
}

public class PaymentSystemFeeCalculation {
    private static Payment createPayment(String type, double amount) {
        switch (type) {
            case "CARD": return new CardPayment(amount);
            case "WALLET": return new WalletPayment(amount);
            case "BANKTRANSFER": return new BankTransferPayment(amount);
            default: throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = Integer.parseInt(input.nextLine().trim());
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < count; i++) payments.add(createPayment(input.next(), input.nextDouble()));
        double total = 0;
        for (Payment payment : payments) {
            double adjusted = payment.adjustedAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", payment.type, adjusted);
            total += adjusted;
        }
        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
