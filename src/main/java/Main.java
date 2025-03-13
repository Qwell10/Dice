import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        RollingDiceService rollingDiceService = new RollingDiceService();

        Player player1 = new Player("player1name", 0);
        Player player2 = new Player("player2name", 0);

        boolean player1WannaContinue = true;

        while (player1.getScore() <= 3500 || player2.getScore() <= 3500) {
            //... full game


            while (player1WannaContinue) {
                int numberOfDice = 4;
                Dice dice = new Dice(numberOfDice);

                System.out.println("hrac 1 hazi a pada mu:");
                Thread.sleep(1000);

                List<Integer> scoreNumbers = rollingDiceService.rollingDice(numberOfDice);
                dice.setScoreNumbers(scoreNumbers);
                System.out.println(scoreNumbers);
                if (!rollingDiceService.canPlayerContinue(dice)) {
                    player1WannaContinue = false;
                    System.out.println("Smůla!");
                }


                System.out.println("continue? [y/n]");
                String answer = sc.nextLine();
                if (answer.equals("n")) {
                    player1WannaContinue = false;
                }
            }
        }
    }
}
