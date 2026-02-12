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

    public void saveDiceToPocket(List<Integer> droppedDice) {
        List<Integer> takenDice = new ArrayList<>();

        int index = getIndex(droppedDice, chooseDice(droppedDice));
        //todo()
    }

    private int getIndex(List<Integer> droppedDice, int value) {
        return IntStream.range(0, droppedDice.size())
                .filter(i -> droppedDice.get(i) == value)
                .findAny()
                .orElse(-1);

    }
}
