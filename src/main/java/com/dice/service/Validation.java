package com.dice.service;

import java.util.List;

public class Validation {

    ScoringService service = new ScoringService();

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

    public boolean isRollScorable(List<Integer> rolledDice) {
        if (rolledDice.contains(1) || rolledDice.contains(5)) {
            return true;
        }

        int[] diceCounts = service.getDiceCounts(rolledDice);

        for (int count : diceCounts) {
            if (count >= 3) {
                return true;
            }
        }
        return false;
    }
}
