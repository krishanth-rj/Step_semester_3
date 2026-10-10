package string.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String[] MOVES = {"rock", "paper", "scissors"};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int wins = 0, losses = 0, draws = 0;
        System.out.print("Number of rounds: ");
        int rounds = input.nextInt();
        if (rounds <= 0) {
            System.out.println("Please enter a positive number of rounds.");
            return;
        }
        for (int round = 1; round <= rounds; round++) {
            System.out.print("Round " + round + " (rock/paper/scissors): ");
            String player = input.next().toLowerCase();
            if (!player.equals("rock") && !player.equals("paper") && !player.equals("scissors")) {
                System.out.println("Invalid move; this round is a draw.");
                draws++;
                continue;
            }
            String computer = MOVES[random.nextInt(MOVES.length)];
            System.out.println("Computer chose " + computer + ".");
            if (player.equals(computer)) {
                System.out.println("Draw.");
                draws++;
            } else if ((player.equals("rock") && computer.equals("scissors"))
                    || (player.equals("paper") && computer.equals("rock"))
                    || (player.equals("scissors") && computer.equals("paper"))) {
                System.out.println("You win this round.");
                wins++;
            } else {
                System.out.println("You lose this round.");
                losses++;
            }
        }
        System.out.printf("Final score: %d wins, %d losses, %d draws.%n", wins, losses, draws);
        System.out.printf("Win percentage: %.2f%%%n", wins * 100.0 / rounds);
    }
}
