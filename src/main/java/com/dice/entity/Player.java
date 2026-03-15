package com.dice.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Player {
    String name;
    int score;
    List<Integer> rolledDice;
    List<Integer> pickedDice;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.rolledDice = new ArrayList<>();
        this.pickedDice = new ArrayList<>();
    }
}
