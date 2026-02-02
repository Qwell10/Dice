import entity.Player;
import service.DiceService;

public class Main {
    public static void main(String[] args) {

        DiceService diceService = new DiceService();
        Player player = new Player();

        System.out.println(diceService.RollDice());
    }
}
