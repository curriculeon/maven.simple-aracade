package com.github.curriculeon.arcade.games.numberguess;

import com.github.curriculeon.arcade.games.AbstractGame;
import com.github.curriculeon.utils.RandomUtils;

import java.util.ArrayList;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame extends AbstractGame<NumberGuessPlayer> {
    private final int maximumValue;
    private Integer mysteryNumber;

    public NumberGuessGame() {
        this(10);
    }

    public NumberGuessGame(int maximumValue) {
        this.maximumValue = maximumValue;
    }

    public Integer getMysteryNumber() {
        return this.mysteryNumber;
    }

    public void setMysteryNumber(Integer mysteryNumber) {
        this.mysteryNumber = mysteryNumber;
    }

    public int getMaximumValue() {
        return maximumValue;
    }

    @Override
    public void setup() {
        setMysteryNumber(RandomUtils.createInteger(0, getMaximumValue()));
    }

    @Override
    public void run() {
        this.winnerList = new ArrayList<>();
        for (NumberGuessPlayer player : getPlayerList()) {
            Integer numberGuessedByPlayer = player.play();
            if (numberGuessedByPlayer.equals(getMysteryNumber())) {
                getWinnerList().add(player);
            }
        }
    }

    @Override
    public void tearDown() {
        getIOConsole().println("The following is a list of players who guessed the correct value:");
        getIOConsole().println(getWinnerList().toString());
    }
}