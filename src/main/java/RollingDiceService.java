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

        return score;
    }

    public int countOnes(Map<Integer, Integer> sortedIdenticalDiceNums) {
        Integer onesOnDice = sortedIdenticalDiceNums.get(1);

        if (onesOnDice == null) {
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

    public int countTwos(Map<Integer, Integer> sortedIdenticalDiceNums) {
        //todo -> complete counting score with twos
        Integer twosOnDice = sortedIdenticalDiceNums.get(2);
        if (twosOnDice == null || twosOnDice < 3) {
            return 0;
        }
        if (sortedIdenticalDiceNums.get(1) == 1) {
            return 100;
        } else if (sortedIdenticalDiceNums.get(1) == 2) {
            return 200;
        } else if (sortedIdenticalDiceNums.get(1) == 3) {
            return 1000;
        } else if (sortedIdenticalDiceNums.get(1) == 4) {
            return 2000;
        } else return 3000;
    }
}

