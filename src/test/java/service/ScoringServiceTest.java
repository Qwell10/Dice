package service;

import entity.Player;
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
        int[] diceCounts = {0, 2, 0, 2};

        boolean result = service.hasInvalidDice(diceCounts);

        Assertions.assertTrue(result);
    }

    @Test
    void hasInvalidDice_false() {
        int[] diceCounts = {0, 2, 0, 3};

        boolean result = service.hasInvalidDice(diceCounts);

        Assertions.assertFalse(result);
    }

    @Test
    void calculateScore_LargeStraight() {
        int[] diceCounts = {0,1,1,1,1,1,1};

        int result = service.calculateScore(diceCounts);

        Assertions.assertEquals(3000, result);
    }

    @Test
    void calculateScore_invalidDice() {
        int[] diceCounts = {0,1,2,1,1,1,0};

        int result = service.calculateScore(diceCounts);

        Assertions.assertEquals(-1, result);
    }

    @Test
    void calculateScore_smallStraight_and_1() {
        int[] diceCounts = {0,2,1,1,1,1,0};

        int result = service.calculateScore(diceCounts);

        Assertions.assertEquals(1600, result);
    }
}