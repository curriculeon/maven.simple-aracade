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
    IOConsole console=new IOConsole(AnsiColor.PURPLE);
    private List<PlayerInterface> playerlist=new ArrayList<>();
    private SlotsReel reel=new SlotsReel();


    @Override
    public void add(PlayerInterface player) {
        console.println("Adding player "+player.toString() +" to slots game");
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
                SlotsPlayer player = (SlotsPlayer) playerInterface;
                console.println("Welcome to the slots game.");
                console.println("Select any of the following options:");
                userInput = console.getStringInput("pull-lever, view-slot-reel, quit");
                player.play(reel, userInput);
            } while(!"quit".equals(userInput)); // go to next player
        }


    }
}
