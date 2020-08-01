package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.arcade.numberguess.NumberGuessPlayer;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {
    private IOConsole console = new IOConsole(AnsiColor.PURPLE);
    private IOConsole consoleGameOver = new IOConsole(AnsiColor.RED);
    private SlotsPlayer player;

    public SlotsGame(){}

    public SlotsGame(SlotsPlayer player) {
        this.player = player;
    }

    @Override
    public void add(PlayerInterface player) {
        this.player.setPlayerName(player.getArcadeAccount().getAccountName());
        this.player.setPlayerPassword(player.getArcadeAccount().getAccountPassword());
    }

    @Override
    public void remove(PlayerInterface player) {
            this.player = null;
    }

    @Override
    public void run() {
        play(player);
    }

    private void play(SlotsPlayer player) {
        console.println("%s, WELCOME to The Slots Game:", player.getPlayerName());
        Double playerBudget = 0D;
        while(playerBudget > 400) {
            playerBudget = console.getDoubleInput("What is your budget today($)?(You cannot play more than $400)");
        }
        String nextMove = console.getStringInput("What do you want to do now? \n [ spin ], [ quit ], [ logout ] ");
    }
}
