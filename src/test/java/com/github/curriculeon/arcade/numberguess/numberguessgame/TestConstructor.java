package com.github.curriculeon.arcade.numberguess.numberguessgame;

import com.github.curriculeon.arcade.games.numberguess.NumberGuessGame;
import org.junit.Assert;
import org.junit.Test;

public class TestConstructor {
    @Test
    public void testParameterized() {
        // given
        int expected = 5;
        NumberGuessGame numberGuessGame = new NumberGuessGame(expected);

        // when
        int actual = numberGuessGame.getMaximumValue();

        // then
        Assert.assertNull(numberGuessGame.getWinnerList());
        Assert.assertNotNull(numberGuessGame.getPlayerList());
        Assert.assertTrue(numberGuessGame.getPlayerList().isEmpty());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNullary() {
        // given
        NumberGuessGame numberGuessGame = new NumberGuessGame();
        int expected = 10;

        // when
        int actual = numberGuessGame.getMaximumValue();

        // then
        Assert.assertNull(numberGuessGame.getWinnerList());
        Assert.assertNotNull(numberGuessGame.getPlayerList());
        Assert.assertTrue(numberGuessGame.getPlayerList().isEmpty());
        Assert.assertEquals(expected, actual);
    }
}
