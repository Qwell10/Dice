import java.util.List;

public class Dice {
    int numberOfDice;
    List<Integer> scoreNumbers;

    public Dice(int numberOfDice, List<Integer> scoreNumbers) {
        this.numberOfDice = numberOfDice;
        this.scoreNumbers = scoreNumbers;
    }

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public List<Integer> getScoreNumbers() {
        return scoreNumbers;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public void setScoreNumbers(List<Integer> scoreNumbers) {
        this.scoreNumbers = scoreNumbers;
    }
}
