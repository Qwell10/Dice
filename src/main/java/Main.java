import entity.Player;
import service.DiceService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DiceService service = new DiceService();
        Player player1 = new Player();
        Player player2 = new Player();

        player1.setRolledDice(service.rollDice(6));

        service.chooseDiceToScore(player1.getRolledDice(), player1, sc);

    }
}
