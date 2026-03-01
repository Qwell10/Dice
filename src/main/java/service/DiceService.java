package service;

import entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DiceService {

    Validation validation = new Validation();

    public List<Integer> rollDice(int amountDice) {
        Random random = new Random();
        ArrayList<Integer> diceNumbers = new ArrayList<>();

        for (int i = 1; i <= amountDice; i++) {
            int number = random.nextInt(amountDice) + 1;
            diceNumbers.add(number);
        }
        return diceNumbers;
    }

    //todo(try in Main)
    public void chooseDiceToScore(List<Integer> rolledDice, Player player, Scanner sc) {
        String next = "y";

        while (rolledDice.size() > 0 && next.equalsIgnoreCase("y")) {
            saveOneDieToPocket(rolledDice, player, sc);

            while (true) {
                System.out.println("Do you want to pick another die? Y or N");

                String playerWannaContinue = sc.nextLine();

                if (playerWannaContinue.equalsIgnoreCase("Y") || playerWannaContinue.equalsIgnoreCase("N")) {
                    next = playerWannaContinue;
                    break;
                } else System.out.println("Type only Y or N. Try again.");
            }
        }
    }


    public void saveOneDieToPocket(List<Integer> rolledDice, Player player, Scanner sc) {
        if (!rolledDice.isEmpty()) {
            int pickedDie = pickDie(rolledDice, sc);

            player.getPickedDice().add(pickedDie);
            System.out.printf("You picked: %d%n\"", pickedDie);

        } else System.out.println("No more dice on table.");
    }

    public int pickDie(List<Integer> rolledDice, Scanner sc) {
        System.out.println(rolledDice);

        while (true) {
            System.out.println("choose die: ");
            String pick = sc.nextLine();

            if (!validation.isNumeric(pick)) {
                System.out.printf("%s is not number bro. Try again. %n", pick);
                continue;
            }

            int pickInt = Integer.parseInt(pick);

            if (!validation.isDiePresent(rolledDice, pickInt)) {
                System.out.printf("%d is not on table. Try again. %n", pickInt);
                continue;
            }

            rolledDice.remove(Integer.valueOf(pickInt));

            return pickInt;
        }
    }
}
