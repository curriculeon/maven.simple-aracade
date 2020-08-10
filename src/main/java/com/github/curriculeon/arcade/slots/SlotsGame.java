package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {
    private IOConsole ioConsole = new IOConsole(AnsiColor.GREEN);
    private List<PlayerInterface> playerList = new ArrayList<>();
    private SlotReel slotReel = new SlotReel();

    @Override
    public void add(PlayerInterface player) {
        ioConsole.println("Adding player %s to the slot game, ", player.toString());
        playerList.add(player);
    }

    @Override
    public void remove(PlayerInterface player) {
        ioConsole.println("Removing player %s from the slot game, ", player.toString());
        playerList.remove(player);
    }

    @Override
    public void run() {

        for (PlayerInterface playerInterface : playerList) {
            String userInput;
            do {
                SlotsPlayer slotsPlayer = (SlotsPlayer) playerInterface;
                ioConsole.println("Welcome to the slot game");
                ioConsole.println("From here you can select any of the following options:");
                userInput = ioConsole.getStringInput("pull-lever, view-slot-real, quit");
                slotsPlayer.play(slotReel, userInput);
            } while (!"quit".equalsIgnoreCase(userInput)); // go onto next player.
        }//for

    }//run
}
