package com.github.curriculeon.arcade.numberguessgame;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.games.numberguess.NumberGuessGame;
import com.github.curriculeon.arcade.games.numberguess.NumberGuessPlayer;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

public class GetWinnerListTest {
    @Test
    public void positiveTest() {
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

    @Test
    public void negativeTest() {
        // given
        int maximumValue = 999;
        NumberGuessGame numberGuessGame = new NumberGuessGame(maximumValue);
        numberGuessGame.setup();
        NumberGuessPlayer numberGuessPlayer = getPlayer("-1");
        numberGuessGame.add(numberGuessPlayer);
        numberGuessGame.run();

        // when
        List<NumberGuessPlayer> winnerList = numberGuessGame.getPlayerList();

        // then
        Assert.assertFalse(winnerList.contains(numberGuessPlayer));
    }

    private NumberGuessPlayer getPlayer(String inputString) {
        return new NumberGuessPlayer(new ArcadeAccount("test", "")) {
            @Override
            public IOConsole getIOConsole() {
                byte[] inputBytes = inputString.getBytes();
                ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
                return new IOConsole(AnsiColor.RED, inputByteArray, System.out) {
                    @Override
                    public String getStringInput(String val, Object... vals) {
                        new IOConsole(AnsiColor.GRAY).print("user input = { %s }", inputString);
                        return super.getStringInput(val, vals);
                    }
                };
            }
        };
    }
}
