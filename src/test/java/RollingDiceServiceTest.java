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
    void countScore_countIdenticalNums() {
        List<Integer> playerSelectedNums = List.of(1, 2, 5, 2, 1);

        rollingDiceService.countScore(playerSelectedNums);
    }

}