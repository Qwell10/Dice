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

    public void chooseDice(List<Integer> droppedDice) {
        System.out.println(droppedDice);

        boolean canContinue = true;

        while (canContinue) {
            String choice = sc.nextLine();

            if (!validation.isNumeric(choice)) {
                System.out.printf("%s is not number bro. Try again", choice);
            } else canContinue = false;

            int choiceInt = Integer.parseInt(choice);

            if (!validation.isWithinRange(choiceInt)) {
                System.out.printf("%d is not within range. Try again", choiceInt);
            } else canContinue = false;
        }
    }
}
