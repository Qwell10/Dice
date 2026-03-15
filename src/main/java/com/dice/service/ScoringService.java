package com.dice.service;

import java.util.List;

public class ScoringService {

    public int[] getDiceCounts(List<Integer> pickedDice) {
        int[] diceCounts = new int[7];

        for (int die : pickedDice) {
            diceCounts[die]++;
        }

        return diceCounts;
    }

    //[0][1][1][1][1][1][1]
    public boolean isLargeStraight(int[] diceCounts) {
        int marker = 0;

        for (int die : diceCounts) {
            if (die == 1) {
                marker++;
            }
        }

        return marker == 6;
    }

    //[0][1][1][1][1][1][0]
    public boolean isSmallStraight(int[] diceCounts) {
        return (diceCounts[1] >= 1 && diceCounts[2] == 1 && diceCounts[3] == 1 && diceCounts[4] == 1 && diceCounts[5] >= 1) ||
                (diceCounts[2] == 1 && diceCounts[3] == 1 && diceCounts[4] == 1 && diceCounts[5] >= 1 && diceCounts[6] == 1);
    }

    public boolean hasInvalidDice(List<Integer> pickedDice) {
        int[] diceCounts = getDiceCounts(pickedDice);

        for (int i = 2; i < diceCounts.length; i++) {
            if (i == 5) {
                continue;
            }
            if (diceCounts[i] != 0 && diceCounts[i] < 3) {
                return true;
            }
        }
        return false;
    }


    public int calculateScore(List<Integer> pickedDice) {
        int[] diceCounts = getDiceCounts(pickedDice);

        if (isLargeStraight(diceCounts)) {
            return 3000;
        }

        if (isSmallStraight(diceCounts) && diceCounts[1] == 2) {
            return 1600;
        } else if (isSmallStraight(diceCounts) && diceCounts[5] == 2) {
            return 1550;
        } else if (isSmallStraight(diceCounts)) {
            return 1500;
        }

        if (hasInvalidDice(pickedDice)) {
            return -1;
        }

        int score = 0;

        score += calculateOnes(diceCounts);
        score += calculateFives(diceCounts);
        score += calculateStandardDice(diceCounts, 2);
        score += calculateStandardDice(diceCounts, 3);
        score += calculateStandardDice(diceCounts, 4);
        score += calculateStandardDice(diceCounts, 6);

        return score;
    }


    private int calculateStandardDice(int[] diceCounts, int dieValue) {
        if (diceCounts[dieValue] == 0) {
            return 0;
        } else if (diceCounts[dieValue] == 3) {
            return (dieValue * 100);
        } else if (diceCounts[dieValue] == 4) {
            return (dieValue * 100) * 2;
        } else if (diceCounts[dieValue] == 5) {
            return (dieValue * 100) * 4;
        } else return (dieValue * 100) * 8;
    }

    private int calculateOnes(int[] diceCounts) {
        if (diceCounts[1] == 0) {
            return 0;
        } else if (diceCounts[1] == 1) {
            return 100;
        } else if (diceCounts[1] == 2) {
            return 200;
        } else if (diceCounts[1] == 3) {
            return 1000;
        } else if (diceCounts[1] == 4) {
            return 2000;
        } else if (diceCounts[1] == 5) {
            return 4000;
        } else return 8000;
    }

    private int calculateFives(int[] diceCounts) {
        if (diceCounts[5] == 0) {
            return 0;
        } else if (diceCounts[5] == 1) {
            return 50;
        } else if (diceCounts[5] == 2) {
            return 100;
        } else if (diceCounts[5] == 3) {
            return 500;
        } else if (diceCounts[5] == 4) {
            return 1000;
        } else if (diceCounts[5] == 5) {
            return 2000;
        } else return 4000;
    }
}
