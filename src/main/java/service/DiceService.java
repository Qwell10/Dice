package service;

import entity.Dice;

import java.util.Random;

public class DiceService {

    Dice dice = new Dice();

    public int RollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
