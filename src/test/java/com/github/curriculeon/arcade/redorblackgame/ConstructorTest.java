package com.github.curriculeon.arcade.redorblackgame;

import com.github.curriculeon.arcade.games.cardgames.redorblack.RedOrBlackGame;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest {
    @Test
    public void testNullary() {
        // given
        // when
        RedOrBlackGame redOrBlackGame = new RedOrBlackGame();

        // then
        Assert.assertNull(redOrBlackGame.getVisibleCard());
        Assert.assertTrue(redOrBlackGame.getPlayerList().isEmpty());
        Assert.assertNull(redOrBlackGame.getWinnerList());
    }
}
