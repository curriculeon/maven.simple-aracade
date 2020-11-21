package com.github.curriculeon.arcade.numberguess.numberguessgame;

import com.github.curriculeon.arcade.games.numberguess.NumberGuessGame;
import org.junit.Assert;
import org.junit.Test;

public class TestSetUp {
    @Test
    public void test() {
        // given
        int maximumValue = 5;
        NumberGuessGame numberGuessGame = new NumberGuessGame(maximumValue);
        Assert.assertNull(numberGuessGame.getMysteryNumber());

        // when
        numberGuessGame.setup();
        int mysteryValue = numberGuessGame.getMysteryNumber();
        boolean isLessThanOrEqualToExpected = mysteryValue <= maximumValue;
        boolean isGreaterThanOrEqualToZero = mysteryValue >= 0;

        // then
        Assert.assertTrue(isLessThanOrEqualToExpected);
        Assert.assertTrue(isGreaterThanOrEqualToZero);
    }
}
