package com.github.curriculeon.arcade.redorblackgame;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.games.cardgames.redorblack.RedOrBlackGame;
import com.github.curriculeon.arcade.games.cardgames.redorblack.RedOrBlackPlayer;
import com.github.curriculeon.arcade.games.cardgames.utils.Card;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

public class RunTest {
    @Test
    public void testWinner() {
        // given
        RedOrBlackGame redOrBlackGame = new RedOrBlackGame();
        redOrBlackGame.setup();
        Card card = redOrBlackGame.getVisibleCard();
        String inputString = card.isRed() ? "red" : "black";
        RedOrBlackPlayer player = getPlayer(inputString);
        redOrBlackGame.add(player);

        // when
        redOrBlackGame.run();
        List<RedOrBlackPlayer> winnerList = redOrBlackGame.getWinnerList();

        // then
        Assert.assertTrue(winnerList.contains(player));
    }

    private RedOrBlackPlayer getPlayer(String inputString) {
        return new RedOrBlackPlayer(new ArcadeAccount("test", "")) {
            @Override
            public IOConsole getIOConsole() {
                byte[] inputBytes = inputString.getBytes();
                ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
                return new IOConsole(AnsiColor.RED, inputByteArray, System.out) {
                    @Override
                    public void print(String val, Object... vals) {
                        super.print(val, vals);
                        new IOConsole(AnsiColor.GRAY).print("user input = { %s }", inputString);
                    }
                };
            }
        };
    }
}
