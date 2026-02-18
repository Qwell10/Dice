package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DiceServiceTest {

    DiceService service = new DiceService();

    @Test
    void testGetScoreNumberHappyScenario() {
        List<Integer> droppedDice = List.of(3, 1, 3, 6);
        int searchingValue = 1;

        int scoreNumber = service.getScoreNumber(droppedDice, searchingValue);

        Assertions.assertEquals(1, scoreNumber);
    }

    @Test
    void testGetScoreReturn0() {
        List<Integer> droppedDice = List.of(3, 4, 3, 6);
        int searchingValue = 1;

        int scoreNumber = service.getScoreNumber(droppedDice, searchingValue);

        Assertions.assertEquals(0, scoreNumber);
    }
}