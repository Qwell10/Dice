import entity.Player;
import service.DicePickingService;
import service.ScoringService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DicePickingService dicePickingService = new DicePickingService();
        ScoringService scoringService = new ScoringService();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        //todo (kdyz hrac vybere alespon jednu platnou kostku, muze hazet znovu)
        while (player1.getScore() != 6000 || player2.getScore() != 6000) {
            for (Player player : players) {
                System.out.println(player1.getName() + " score: " + player1.getScore());

                List<Integer> rolledDice = dicePickingService.rollDice(6);

                if(scoringService.hasInvalidDice(player1.getPickedDice())) {
                    continue;
                }

                dicePickingService.chooseDiceToScore(rolledDice, player1.getPickedDice(), sc);

                //todo canRollAgain()

                int score = scoringService.calculateScore(player1.getPickedDice());

                player1.setScore(score);

                System.out.println("You scored: " + score);
            }
        }
    }
}
