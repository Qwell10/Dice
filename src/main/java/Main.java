import entity.Player;
import service.DicePickingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DicePickingService service = new DicePickingService();

        Player player1 = new Player();
        Player player2 = new Player();

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        //todo()
        while (player1.getScore() != 6000 || player2.getScore() != 6000) {
            for (Player player : players) {
                List<Integer> rolledDice = service.rollDice(6);

                System.out.println("player 1 score: " + player1.getScore());
                service.chooseDiceToScore(rolledDice, player1.getPickedDice(), sc);

            }
        }
    }
}
