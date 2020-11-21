package com.github.curriculeon.arcade.games.numberguess;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.games.AbstractPlayer;
import com.github.curriculeon.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessPlayer extends AbstractPlayer {
    public NumberGuessPlayer(ArcadeAccount arcadeAccount) {
        super(arcadeAccount);
    }

    @Override
    public Integer play() {
        return getIOConsole().getIntegerInput("Please enter the number you would like to guess.");
    }
}