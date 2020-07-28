package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.ArcadeAccountManager;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer implements PlayerInterface {
    private static final IOConsole console = new IOConsole(AnsiColor.PURPLE);
    ArcadeAccountManager accountManager;
    ArcadeAccount arcadeAccount;

    public SlotsPlayer(ArcadeAccount arcadeAccount) {
        this.arcadeAccount = arcadeAccount;
        accountManager = ArcadeAccountManager.getInstance();
    }

    @Override
    public ArcadeAccount getArcadeAccount() {
        return arcadeAccount;
    }

    @Override
    public Integer[] play() {
         return new Integer[]{console.getIntegerInput("1: pull lever ANY OTHER KEY: quit")};

    }
}