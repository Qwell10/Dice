package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ValidationTest {

    Validation validation = new Validation();

    @Test
    void testIsDiePresentTrue() {
        List<Integer> rolledDice = List.of(3, 4, 3, 6);
        int searchingValue = 6;

        boolean result = validation.isDiePresent(rolledDice, searchingValue);

        Assertions.assertTrue(result);
    }

    @Test
    void testIsDiePresentFalse() {
        List<Integer> rolledDice = List.of(3, 4, 3);
        int searchingValue = 6;

        boolean result = validation.isDiePresent(rolledDice, searchingValue);

        Assertions.assertFalse(result);
    }

}