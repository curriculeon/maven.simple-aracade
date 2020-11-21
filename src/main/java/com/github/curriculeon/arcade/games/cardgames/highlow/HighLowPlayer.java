package com.github.curriculeon.arcade.games.cardgames.highlow;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.games.AbstractPlayer;
import com.github.curriculeon.utils.IOConsole;

import java.util.StringJoiner;

public class HighLowPlayer extends AbstractPlayer {
    public HighLowPlayer(ArcadeAccount arcadeAccount) {
        super(arcadeAccount);
    }

    @Override
    public String play() {
        return getIOConsole().getStringInput(new StringJoiner("\n")
                .add("From here, you can select any of the following options")
                .add("[ high ], [ low ], [ even ], [ quit ]")
                .toString());
    }
}
