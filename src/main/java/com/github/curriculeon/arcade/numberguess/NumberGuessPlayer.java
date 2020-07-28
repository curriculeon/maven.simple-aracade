package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.ArcadeAccountManager;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessPlayer  implements PlayerInterface {
    private static final IOConsole console = new IOConsole(AnsiColor.PURPLE);
    ArcadeAccountManager accountManager;
    ArcadeAccount arcadeAccount;

    public NumberGuessPlayer(ArcadeAccount arcadeAccount) {
        this.arcadeAccount = arcadeAccount;
        accountManager = ArcadeAccountManager.getInstance();
    }

    @Override
    public ArcadeAccount getArcadeAccount() {
        return arcadeAccount;
    }

    @Override
    public Integer[] play() {
        List<Integer> playerInput = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++)
            playerInput.add(console.getIntegerInput("Enter number: "));

        return playerInput.toArray(new Integer[0]);
    }
}