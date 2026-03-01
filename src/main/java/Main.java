import entity.Player;
import service.DiceService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DiceService diceService = new DiceService();
        Player player = new Player();
        Scanner sc = new Scanner(System.in);


        diceService.chooseDiceToScore();

    }
}
