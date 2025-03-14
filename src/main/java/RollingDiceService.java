import java.util.*;

public class RollingDiceService {

    public List<Integer> rollingDice(int numberOfDice) {
        Random random = new Random();
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < numberOfDice; i++) {
            int roll = random.nextInt(6) + 1;
            results.add(roll);
        }
        return results;
    }

    public boolean canPlayerContinue(Dice dice) {
        List<Integer> scoreNumbers = dice.getScoreNumbers();
        int numberOfDice = dice.getNumberOfDice();

        for (int i = 0; i < numberOfDice; i++) {
            if (dice.getScoreNumbers().get(i) == 1 || dice.getScoreNumbers().get(i) == 5) {
                return true;
            }
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (int value : scoreNumbers) {
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }

        for (int count : counts.values()) {
            if (count >= 3) {
                return true;
            }
        }
        return false;
    }

    public int countScore(List<Integer> playerSelectedNums) {
        //todo -> complete method to count score
        int score = 0;

        Map<Integer, Integer> identicalDiceNums = new HashMap<>();

        for (int diceRolledNum : playerSelectedNums) {
            identicalDiceNums.put(diceRolledNum, identicalDiceNums.getOrDefault(diceRolledNum, 0) + 1);
        }

        Map<Integer, Integer> sortedIdenticalDiceNums = new TreeMap<>(identicalDiceNums);

        score += countOnes(sortedIdenticalDiceNums);
        score += countTwos(sortedIdenticalDiceNums);
        score += countThrees(sortedIdenticalDiceNums);
        score += countFours(sortedIdenticalDiceNums);
        score += countFives(sortedIdenticalDiceNums);
        score += countSixes(sortedIdenticalDiceNums);

        return score;
    }

    private int countOnes(Map<Integer, Integer> sortedIdenticalDiceNums) {
        Integer onesOnDice = sortedIdenticalDiceNums.get(1);

        if (onesOnDice == null || onesOnDice == 0) {
            return 0;
        } else if (onesOnDice == 1) {
            return 100;
        } else if (onesOnDice == 2) {
            return 200;
        } else if (onesOnDice == 3) {
            return 1000;
        } else if (onesOnDice == 4) {
            return 2000;
        } else return 3000;
    }

    private int countTwos(Map<Integer, Integer> sortedIdenticalDiceNums) {
        Integer twosOnDice = sortedIdenticalDiceNums.get(2);

        if (twosOnDice == null || twosOnDice < 3) {
            return 0;
        } else if (twosOnDice == 3) {
            return 200;
        } else if (twosOnDice == 4) {
            return 400;
        } else return 600;
    }

    private int countThrees(Map<Integer, Integer> sortedIdenticalDiceNums) {
        Integer threesOnDice = sortedIdenticalDiceNums.get(3);

        if (threesOnDice == null || threesOnDice < 3) {
            return 0;
        } else if (threesOnDice == 3) {
            return 300;
        } else if (threesOnDice == 4) {
            return 600;
        } else return 900;
    }

    private int countFours(Map<Integer, Integer> sortedIdenticalDiceNums) {
        Integer foursOnDice = sortedIdenticalDiceNums.get(4);

        if (foursOnDice == null || foursOnDice < 3) {
            return 0;
        } else if (foursOnDice == 3) {
            return 400;
        } else if (foursOnDice == 4) {
            return 800;
        } else return 1200;
    }

    private int countFives(Map<Integer, Integer> sortedIdenticalDiceNums) {
        Integer fivesOnDice = sortedIdenticalDiceNums.get(5);

        if (fivesOnDice == null || fivesOnDice == 0) {
            return 0;
        } else if (fivesOnDice == 1) {
            return 50;
        } else if (fivesOnDice == 2) {
            return 100;
        } else if (fivesOnDice == 3) {
            return 500;
        } else if (fivesOnDice == 4) {
            return 1000;
        } else return 1500;
    }

    private int countSixes(Map<Integer, Integer> sortedIdenticalDiceNums) {
        Integer sixesOnDice = sortedIdenticalDiceNums.get(6);

        if (sixesOnDice == null || sixesOnDice < 3) {
            return 0;
        } else if (sixesOnDice == 3) {
            return 600;
        } else if (sixesOnDice == 4) {
            return 1200;
        } else return 1800;
    }
}

