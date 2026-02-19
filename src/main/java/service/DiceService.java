package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

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

    public int chooseDice(List<Integer> rolledDice) {
        System.out.println(rolledDice);

        while (true) {
            System.out.println("choose dice: ");
            String choice = sc.nextLine();

            if (!validation.isNumeric(choice)) {
                System.out.printf("%s is not number bro. Try again", choice);
                continue;
            }

            int choiceInt = Integer.parseInt(choice);

            if (!validation.isNumber1_6(choiceInt)) {
                System.out.printf("%d is not within range. Try again", choiceInt);
                continue;
            }
            return choiceInt;
        }
    }

    //todo(dodelat metody nize)
    public void saveOneDiceToPocket(List<Integer> rolledDice, List<Integer> takenDice) {
        System.out.println("Choose one dice:");

        String pick = sc.nextLine();
        validation.isNumeric(pick);
        int pickInt = Integer.parseInt(pick);

        takenDice.add(pickInt);
        rolledDice.remove(Integer.valueOf(pickInt));
    }


    //todo - refactor getDie()
    public int getDieIfPresent(List<Integer> rolledDice, int searchingValue) {
        return IntStream.range(0, rolledDice.size())
                .filter(i -> rolledDice.get(i) == searchingValue)
                .map(rolledDice::get)
                .findFirst()
                .orElse(0);
    }
}
