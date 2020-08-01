package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.arcade.slots.SlotsPlayer;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame implements GameInterface {
    IOConsole console = new IOConsole(AnsiColor.PURPLE);
    private List<PlayerInterface> playerlist = new ArrayList<>();
    private NumberGame numberGame;

    @Override
    public void add(PlayerInterface player) {
        playerlist.add(player);
    }

    @Override
    public void remove(PlayerInterface player) {
        playerlist.remove(player);
    }

    @Override
    public void run() {
        for (PlayerInterface playerInterface : playerlist) {
            String userInput;
            do {
                NumberGuessPlayer player = (NumberGuessPlayer) playerInterface;
                console.println("Welcome to the Number guess game.");
                userInput = console.getStringInput("Guess a number from 1-100 or quit");
                player.play(numberGame, userInput);
            } while(!"quit".equals(userInput)); // go to next player
        }
    }
}