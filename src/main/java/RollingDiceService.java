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

        return score;
    }
}

