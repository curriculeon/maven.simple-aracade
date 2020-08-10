package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.ArcadeAccount;
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
    IOConsole console = new IOConsole(AnsiColor.YELLOW);
    private List<PlayerInterface> playerList = new ArrayList<>();

    @Override
    public void add(PlayerInterface player) {
        console.println("Adding player %s ", player);
        playerList.add(player);
    }

    @Override
    public void remove(PlayerInterface player) {
        console.println("Removing player %s", player);
        playerList.remove(player);
    }

    @Override
    public void run() {

        for (PlayerInterface playerInterface : playerList) {
            String userInput;
            do {
                NumberGuessPlayer numberGuessPlayer = (NumberGuessPlayer) playerInterface;
                console.println("Welcome to the number guess game");
                userInput = console.getStringInput(" or type quit to exit");
                numberGuessPlayer.play(new NumberGuessGame(), userInput);
            } while (!"quit".equalsIgnoreCase(userInput) || !"N".equalsIgnoreCase(userInput)); // go onto next player.
        }//for

    }//run
    }
