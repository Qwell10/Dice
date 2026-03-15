package service;

import com.dice.service.ScoringService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ScoringServiceTest {

    ScoringService service = new ScoringService();

    @Test
    void getDiceCounts() {
        int[] result = service.getDiceCounts(List.of(1, 5, 5, 5));

        Assertions.assertEquals(0, result[0]);
        Assertions.assertEquals(1, result[1]);
        Assertions.assertEquals(3, result[5]);
    }

    @Test
    void isLargeStraight_true() {
        int[] diceCounts = {0, 1, 1, 1, 1, 1, 1};

        boolean result = service.isLargeStraight(diceCounts);

        Assertions.assertTrue(result);
    }

    @Test
    void isLargeStraight_false() {
        int[] diceCounts = {0, 1, 1, 1, 1, 1, 0};

        boolean result = service.isLargeStraight(diceCounts);

        Assertions.assertFalse(result);
    }

    @Test
    void isSmallStraight_true() {
        int[] diceCounts = {0, 0, 1, 1, 1, 1, 1};

        boolean result = service.isSmallStraight(diceCounts);

        Assertions.assertTrue(result);
    }

    @Test
    void isSmallStraight_false() {
        int[] diceCounts = {0, 1, 1, 1, 0, 1, 1};

        boolean result = service.isSmallStraight(diceCounts);

        Assertions.assertFalse(result);
    }


    @Test
    void hasInvalidDice_true() {
        List<Integer> pickedDice = List.of(1, 1, 3, 3);

        boolean result = service.hasInvalidDice(pickedDice);

        Assertions.assertTrue(result);
    }

    @Test
    void hasInvalidDice_false() {
        List<Integer> pickedDice = List.of(1, 1, 3, 3, 3);

        boolean result = service.hasInvalidDice(pickedDice);

        Assertions.assertFalse(result);
    }

    @Test
    void calculateScore_LargeStraight() {
        List<Integer> pickedDice = List.of(1, 2, 3, 4, 5, 6);

        int result = service.calculateScore(pickedDice);

        Assertions.assertEquals(3000, result);
    }

    @Test
    void calculateScore_invalidDice() {
        List<Integer> pickedDice = List.of(1, 2, 2, 3, 4, 5);

        int result = service.calculateScore(pickedDice);

        Assertions.assertEquals(-1, result);
    }

    @Test
    void calculateScore_smallStraight_and_1() {
        List<Integer> pickedDice = List.of(1, 1, 2, 3, 4, 5);

        int result = service.calculateScore(pickedDice);

        Assertions.assertEquals(1600, result);
    }

    @Test
    void calculateScore() {
        List<Integer> pickedDice = List.of(1, 1, 2, 2, 2, 5);

        int result = service.calculateScore(pickedDice);

        Assertions.assertEquals(450, result);
    }
}