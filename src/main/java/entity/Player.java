package entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Player {
    int score;
    List<Integer> rolledDice;
    List<Integer> pickedDice;

    public Player() {
        this.score = 0;
        this.rolledDice = new ArrayList<>();
        this.pickedDice = new ArrayList<>();
    }
}
