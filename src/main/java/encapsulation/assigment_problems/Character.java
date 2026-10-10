package encapsulation.assigment_problems;

public class Character {
    private int health;
    private final int maximumHealth;

    public Character(int maximumHealth) {
        if (maximumHealth < 0) throw new IllegalArgumentException("Maximum health cannot be negative.");
        this.maximumHealth = maximumHealth;
        health = maximumHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        if (amount > 0) health = Math.min(maximumHealth, health + amount);
    }

    public int getHealth() {
        return health;
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }

    public static void main(String[] args) {
        Character character = new Character(100);
        character.takeDamage(30);
        System.out.println("Health: " + character.getHealth());
        character.heal(50);
        System.out.println("Health: " + character.getHealth());
        character.takeDamage(150);
        System.out.println("Health: " + character.getHealth());
    }
}
