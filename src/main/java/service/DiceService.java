package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DiceService {

    Scanner sc = new Scanner(System.in);
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

    public int pickDie(List<Integer> rolledDice) {
        System.out.println(rolledDice);

        while (true) {
            System.out.println("choose dice: ");
            String pick = sc.nextLine();

            if (!validation.isNumeric(pick)) {
                System.out.printf("%s is not number bro. Try again. %n", pick);
                continue;
            }

            int pickInt = Integer.parseInt(pick);

            if (!validation.isNumber1_6(pickInt)) {
                System.out.printf("%d is not within range. Try again. %n", pickInt);
                continue;
            }

            if (!validation.isDiePresent(rolledDice, pickInt)) {
                System.out.printf("%d is not on table. Try again. %n", pickInt);
                continue;
            }

            rolledDice.remove(Integer.valueOf(pickInt));

            return pickInt;
        }
    }

    //todo
    public void saveOneDiceToPocket(List<Integer> rolledDice, List<Integer> takenDice) {
        System.out.println("Choose one dice:");

        String pick = sc.nextLine();
        validation.isNumeric(pick);
        int pickInt = Integer.parseInt(pick);

        takenDice.add(pickInt);
        rolledDice.remove(Integer.valueOf(pickInt));
    }
}
