package service;

import java.util.List;

public class ScoringService {

    int[] getDiceCounts(List<Integer> pickedDice) {
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
        return (diceCounts[1] == 1 && diceCounts[2] == 1 && diceCounts[3] == 1 && diceCounts[4] == 1 && diceCounts[5] == 1) ||
                (diceCounts[2] == 1 && diceCounts[3] == 1 && diceCounts[4] == 1 && diceCounts[5] == 1 && diceCounts[6] == 1);
    }

    public boolean hasInvalidDice(int[] diceCounts) {
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
}
