import com.dice.entity.Player;
import com.dice.service.DicePickingService;
import com.dice.service.ScoringService;
import com.dice.service.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMain {
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

                System.out.println(player.getName() + " score: " + player.getScore() + "\n");
                pause();

                List<Integer> rolledDice = dicePickingService.rollDice(6);
                System.out.println(rolledDice);

                if (validation.isRollScorable(rolledDice)) {
                    dicePickingService.chooseDiceToScore(rolledDice, player.getPickedDice(), sc);

                } else System.out.println("You failed");

                System.out.println();


                //     int score = scoringService.calculateScore(player.getPickedDice());

                //     player.setScore(player.getScore() + score);

                //     System.out.println("You scored: " + score);
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
