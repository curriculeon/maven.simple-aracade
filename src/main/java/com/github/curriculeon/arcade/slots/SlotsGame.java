package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.arcade.numberguess.NumberGuessPlayer;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

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
        console.println("%s, WELCOME to The Slots Game!", player.getPlayerName());
        double playerBudget = 500D;
        while(playerBudget > 400D) {
            playerBudget = console.getDoubleInput("Insert Cash Here! (You cannot play more than $400)");
        }
        consoleGameOver.println("cash = $%.2f\tbet = $%.2f\twin = $%.2f", playerBudget, 4.00, 0.00);
        String nextMove = console.getStringInput("[ cash-out ], [ spin-reels ], [ logout ], 1 Credit = $4");

        while(nextMove.equalsIgnoreCase("spin-reels")) {
            List<SlotsReel> resultList = SlotsReelManager.getResultList();
            console.println("Reels: " + resultList);
            Double winningPrice = SlotsReelManager.getWinningPrice(resultList);
            playerBudget += winningPrice - 4.0;
            consoleGameOver.println("cash = $%.2f\tbet = $%.2f\twin = $%.2f", playerBudget, 4.00, winningPrice);
            nextMove = console.getStringInput("[ cash-out ], [ spin-reels ], 1 Credit = $4.00");
        }

        if(nextMove.equalsIgnoreCase("cash-out")) {
            playerBudget = 500D;
            play(player);
        } else {
            consoleGameOver.println("THE GAME IS OVER");
            remove(player);
        }
    }
}
