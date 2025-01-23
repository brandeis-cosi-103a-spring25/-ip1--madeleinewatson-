package edu.brandeis.cosi103a.ip1;
import java.util.Random;
import java.util.Scanner;
/**
 * Hello world!
 *
 */



public class App { // Top-level class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int rounds = 10;
        int player1Score = 0;
        int player2Score = 0;

        System.out.println("Welcome to the Dice Game!");
        System.out.println("Each player gets 10 turns. The player with the highest score wins.\n");

        for (int round = 1; round <= rounds; round++) {
            System.out.println("Round " + round + ":\n");

            // Player 1's turn
            System.out.println("Player 1's turn:");
            player1Score += playTurn(scanner, random);
            System.out.println("Player 1's total score: " + player1Score + "\n");

            // Player 2's turn
            System.out.println("Player 2's turn:");
            player2Score += playTurn(scanner, random);
            System.out.println("Player 2's total score: " + player2Score + "\n");
        }

        // Determine the winner
        System.out.println("Game over!\n");
        System.out.println("Final Scores:");
        System.out.println("Player 1: " + player1Score);
        System.out.println("Player 2: " + player2Score);

        if (player1Score > player2Score) {
            System.out.println("Player 1 wins!");
        } else if (player2Score > player1Score) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }

    static int playTurn(Scanner scanner, Random random) {
        int roll = rollDie(random);
        System.out.println("You rolled: " + roll);

        for (int rerolls = 0; rerolls < 2; rerolls++) {
            System.out.print("Would you like to re-roll? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("yes")) {
                roll = rollDie(random);
                System.out.println("You re-rolled and got: " + roll);
            } else {
                break;
            }
        }

        System.out.println("Your turn ends with a roll of: " + roll);
        return roll;
    }

    public static int rollDie(Random random) {
        return random.nextInt(6) + 1; // Generates a number between 1 and 6
    }
}
