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

    public int chooseDice(List<Integer> droppedDice) {
        System.out.println(droppedDice);

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
    public void saveOneDiceToPocket(List<Integer> droppedDice, List<Integer> takenDice) {
        System.out.println("Choose one dice:");

        String pick = sc.nextLine();
        validation.isNumeric(pick);
        int pickInt = Integer.parseInt(pick);

        takenDice.add(pickInt);
        droppedDice.remove(Integer.valueOf(pickInt));
    }

    public int getScoreNumber(List<Integer> droppedDice, int searchingValue) {
        return IntStream.range(0, droppedDice.size())
                .filter(i -> droppedDice.get(i) == searchingValue)
                .map(droppedDice::get)
                .findFirst()
                .orElse(0);
    }
}
