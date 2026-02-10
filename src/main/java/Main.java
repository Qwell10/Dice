import entity.Player;
import service.DiceService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DiceService diceService = new DiceService();
        Player player = new Player();

        //player rolls dice
        List<Integer> droppedDice = diceService.rollDice(player.getAmountDice());

        //player choose  dice
        diceService.chooseDice(droppedDice);
    }
}
