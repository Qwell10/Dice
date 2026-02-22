package service;

import java.util.List;

public class Validation {

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isNumber1_6(int input) {
        return input > 0 && input <= 6;
    }

    public boolean isDiePresent(List<Integer> rolledDice, int pickedDie) {
        return rolledDice.contains(pickedDie);
    }
}
