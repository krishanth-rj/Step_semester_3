package encapsulation.class_problems;

public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be positive");
            return;
        }
        savings += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > savings) {
            System.out.println("Withdrawal rejected");
            return false;
        }
        savings -= amount;
        return true;
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank bank = new PiggyBank("PB-1");
        bank.deposit(100);
        bank.withdraw(30);
        System.out.println("Savings: " + bank.getSavings());
        bank.withdraw(500);
        System.out.println("Savings: " + bank.getSavings());
    }
}
