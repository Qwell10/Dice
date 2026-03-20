import entity.Player;
import service.DicePickingService;
import service.ScoringService;
import service.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DicePickingService dicePickingService = new DicePickingService();
        ScoringService scoringService = new ScoringService();
        Validation validation = new Validation();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        while (player1.getScore() < 6000 && player2.getScore() < 6000) {
            for (Player player : players) {

                int turnScore = 0;
                int diceCount = 6;
                boolean turnContinue = true;

                while (turnContinue) {
                    System.out.println("\n --- " + player.getName() + " ---");
                    System.out.println("Score: " + player.getScore() + "\n -----------------------------");

                    List<Integer> rolledDice = dicePickingService.rollDice(diceCount);
                    System.out.println("You rolled: " + rolledDice);

                    if (validation.isRollScorable(rolledDice)) {
                        dicePickingService.chooseDiceToScore(rolledDice, player.getPickedDice(), sc);
                        turnScore += scoringService.calculateScore(player.getPickedDice());
                        System.out.println("Turn Score: " + turnScore);
                        diceCount =- player.getPickedDice().size();

                    } else {
                        System.out.println("--- NO DICE TO SCORE ---");
                        turnScore = 0;
                        turnContinue = false;
                        pause();
                    }
                }
            }
        }
    }

    public static void pause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}

