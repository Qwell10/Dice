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
        String choice = sc.nextLine();
        System.out.println(validation.isNumeric(choice));
    }
}
