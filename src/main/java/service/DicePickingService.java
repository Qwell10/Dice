package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DicePickingService {

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

    public void chooseDiceToScore(List<Integer> rolledDice, List<Integer> pickedDice, Scanner sc) {
        while (!rolledDice.isEmpty()) {
            int result = saveOneDieToPocket(rolledDice, pickedDice, sc);

            if (result == 0) {
                break;
            }
        }
    }

    public int saveOneDieToPocket(List<Integer> rolledDice, List<Integer> pickedDice, Scanner sc) {
        if (!rolledDice.isEmpty()) {
            int pickedDie = pickDie(rolledDice, sc);

            if (pickedDie != 0) {
                pickedDice.add(pickedDie);
            }

            System.out.println(rolledDice);

            return pickedDie;

        } else {
            System.out.println("No more dice on table.");
            return 0;
        }
    }

    public int pickDie(List<Integer> rolledDice, Scanner sc) {
        while (true) {
            System.out.println("Pick a die (or type 'N' to stop): ");
            String pick = sc.nextLine();

            if (pick.equalsIgnoreCase("n")) {
                return 0;
            }

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
