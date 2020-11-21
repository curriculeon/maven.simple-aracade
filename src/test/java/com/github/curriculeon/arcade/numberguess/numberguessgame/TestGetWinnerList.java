package com.github.curriculeon.arcade.numberguess.numberguessgame;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.games.numberguess.NumberGuessGame;
import com.github.curriculeon.arcade.games.numberguess.NumberGuessPlayer;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

public class TestGetWinnerList {
    @Test
    public void test() {
        // given
        int maximumValue = 999;
        NumberGuessGame numberGuessGame = new NumberGuessGame(maximumValue);
        numberGuessGame.setup();
        Integer mysteryValue = numberGuessGame.getMysteryNumber();
        NumberGuessPlayer numberGuessPlayer = getPlayer(mysteryValue.toString());
        numberGuessGame.add(numberGuessPlayer);
        numberGuessGame.run();

        // when
        List<NumberGuessPlayer> winnerList = numberGuessGame.getPlayerList();

        // then
        Assert.assertTrue(winnerList.contains(numberGuessPlayer));
    }

    private NumberGuessPlayer getPlayer(String inputString) {
        return new NumberGuessPlayer(new ArcadeAccount("test", "")) {
            @Override
            public IOConsole getIOConsole() {
                byte[] inputBytes = inputString.getBytes();
                ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
                return new IOConsole(AnsiColor.RED, inputByteArray, System.out);
            }
        };
    }
}
