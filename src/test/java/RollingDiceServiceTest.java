import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RollingDiceServiceTest {

    RollingDiceService rollingDiceService = new RollingDiceService();

    @Test
    void rollingDice6() {
        List<Integer> result = rollingDiceService.rollingDice(6);
        assertEquals(6, result.size());
    }

    @Test
    void rollingDice4() {
        List<Integer> result = rollingDiceService.rollingDice(4);
        assertEquals(4, result.size());
    }

    @Test
    void canPlayerContinue_true_trinity() {
        Dice dice = new Dice(6, List.of(3, 3, 3, 4, 2, 6));
        boolean result = rollingDiceService.canPlayerContinue(dice);

        assertTrue(result);
    }

    @Test
    void canPlayerContinue_true_scoreNumber1() {
        Dice dice = new Dice(6, List.of(3, 1, 3, 2, 2, 6));
        boolean result = rollingDiceService.canPlayerContinue(dice);

        assertTrue(result);
    }

    @Test
    void canPlayerContinue_false() {
        Dice dice = new Dice(6, List.of(3, 3, 4, 2, 2, 6));
        boolean result = rollingDiceService.canPlayerContinue(dice);

        assertFalse(result);
    }

    @Test
    void countScore_countIdenticalNums1() {
        List<Integer> playerSelectedNums = List.of(1, 2, 1, 1, 1);

        int result = rollingDiceService.countScore(playerSelectedNums);

        assertEquals(2000, result);
    }

    @Test
    void countScore_countIdenticalNums2() {
        List<Integer> playerSelectedNums = List.of(2, 2, 2, 2);

        int result = rollingDiceService.countScore(playerSelectedNums);

        assertEquals(400, result);
    }

    @Test
    void countScore_countIdenticalNums3() {
        List<Integer> playerSelectedNums = List.of(3, 3, 3, 3, 3);

        int result = rollingDiceService.countScore(playerSelectedNums);

        assertEquals(900, result);
    }

    @Test
    void countScore_countIdenticalNums4() {
        List<Integer> playerSelectedNums = List.of(4, 4, 4, 4);

        int result = rollingDiceService.countScore(playerSelectedNums);

        assertEquals(800, result);
    }

    @Test
    void countScore_countIdenticalNums5() {
        List<Integer> playerSelectedNums = List.of(5, 5);

        int result = rollingDiceService.countScore(playerSelectedNums);

        assertEquals(100, result);
    }

    @Test
    void countScore_countIdenticalNums6() {
        List<Integer> playerSelectedNums = List.of(6, 6, 6);

        int result = rollingDiceService.countScore(playerSelectedNums);

        assertEquals(600, result);
    }
}