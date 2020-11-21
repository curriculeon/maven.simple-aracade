package com.github.curriculeon.arcade.games.numberguess;

import com.github.curriculeon.arcade.games.AbstractGame;
import com.github.curriculeon.arcade.games.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;
import com.github.curriculeon.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame extends AbstractGame<NumberGuessPlayer> {
    private final int maximumValue;
    private Integer mysteryNumber;
    private List<PlayerInterface> winnerList;

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

    public List<PlayerInterface> getWinnerList() {
        return winnerList;
    }

    @Override
    public void setup() {
        setMysteryNumber(RandomUtils.createInteger(0, getMaximumValue()));
    }

    @Override
    public void run() {
        IOConsole console = getIOConsole(AnsiColor.GREEN);
        this.winnerList = new ArrayList<>();
        for (PlayerInterface player : getPlayerList()) {
            Integer numberGuessedByPlayer = player.play();
            if (numberGuessedByPlayer.equals(getMysteryNumber())) {
                getWinnerList().add(player);
            }
        }
        console.println("The following is a list of players who guessed the correct value:");
        console.println(getWinnerList().toString());
    }
}