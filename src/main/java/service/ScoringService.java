package service;

import java.util.Arrays;
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
        return (diceCounts[1] >= 1 && diceCounts[2] == 1 && diceCounts[3] == 1 && diceCounts[4] == 1 && diceCounts[5] >= 1) ||
                (diceCounts[2] == 1 && diceCounts[3] == 1 && diceCounts[4] == 1 && diceCounts[5] >= 1 && diceCounts[6] == 1);
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

    public int calculateScore(int[] diceCounts) {
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

        if (hasInvalidDice(diceCounts)) {
            return -1;
        }

        //todo()

        int score = 0;

        score += calculateOnes(diceCounts);
        score += calculateTwos(diceCounts);
        score += calculateThrees(diceCounts);
        score += calculateFours(diceCounts);
        score += calculateFives(diceCounts);
        score += calculateSixes(diceCounts);

        return score;
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

    private int calculateTwos(int[] diceCounts) {
        if (diceCounts[2] == 0) {
            return 0;
        } else if (diceCounts[2] == 3) {
            return 200;
        } else if (diceCounts[2] == 4) {
            return 400;
        } else if (diceCounts[2] == 5) {
            return 800;
        } else return 1600;
    }

    private int calculateThrees(int[] diceCounts) {
        if (diceCounts[3] == 0) {
            return 0;
        } else if (diceCounts[3] == 3) {
            return 300;
        } else if (diceCounts[3] == 4) {
            return 600;
        } else if (diceCounts[3] == 5) {
            return 1200;
        } else return 2400;
    }


    private int calculateFours(int[] diceCounts) {
        if (diceCounts[4] == 0) {
            return 0;
        } else if (diceCounts[4] == 3) {
            return 400;
        } else if (diceCounts[4] == 4) {
            return 800;
        } else if (diceCounts[4] == 5) {
            return 1600;
        } else return 3200;
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

    private int calculateSixes(int[] diceCounts) {
        if (diceCounts[6] == 0) {
            return 0;
        } else if (diceCounts[6] == 3) {
            return 600;
        } else if (diceCounts[6] == 4) {
            return 1200;
        } else if (diceCounts[6] == 5) {
            return 2400;
        } else return 4800;
    }
}
