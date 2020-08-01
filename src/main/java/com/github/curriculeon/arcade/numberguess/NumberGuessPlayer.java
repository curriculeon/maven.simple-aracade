package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.ArcadeAccountManager;
import com.github.curriculeon.arcade.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessPlayer implements PlayerInterface {
    private ArcadeAccountManager arcadeAccountManager = ArcadeAccountManager.getInstance();
    private String playerName;
    private String playerPassword;

    public NumberGuessPlayer() {}

    public NumberGuessPlayer(String playerName, String playerPassword) {
        this.playerName = playerName;
        this.playerPassword = playerPassword;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerPassword(String playerPassword) {
        this.playerPassword = playerPassword;
    }

    public String getPlayerPassword() {
        return playerPassword;
    }

    @Override
    public ArcadeAccount getArcadeAccount() {
        return arcadeAccountManager.getAccount(playerName, playerPassword);
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}