package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DicePickingServiceTest {

    DicePickingService service = new DicePickingService();

    @Test
    void pickDie() {
        List<Integer> rolledDice = new ArrayList<>(List.of(1, 2, 3, 4));

        String simulatedInput = "1\n";
        Scanner fakeScanner = new Scanner(simulatedInput);

        int result = service.pickDie(rolledDice, fakeScanner);

        Assertions.assertEquals(1, result);
    }
}