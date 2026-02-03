package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    int amountDice;
    int score;

    public Player() {
        this.amountDice = 6;
        this.score = 0;
    }
}
