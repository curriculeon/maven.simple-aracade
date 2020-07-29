package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame implements GameInterface {
    private NumberGuessPlayer numberGuessPlayer;
    private final Integer numberToGuess;

    public NumberGuessGame() {
        numberGuessPlayer = new NumberGuessPlayer();
        numberToGuess = new Random().nextInt();
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {

    }
}