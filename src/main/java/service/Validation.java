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

    public boolean isDiePresent(List<Integer> rolledDice, int pickedDie) {
        return rolledDice.contains(pickedDie);
    }
}
