package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.IOConsole;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer implements PlayerInterface {

    private ArcadeAccount playerArcadeAccount;

    public SlotsPlayer(ArcadeAccount playerArcadeAccount) {
        this.playerArcadeAccount = playerArcadeAccount;
    }

    @Override
    public ArcadeAccount getArcadeAccount() {
        //return null;
        return playerArcadeAccount;
    }

    @Override
    //public <SomeReturnType> SomeReturnType play() {
    public void play() {
        IOConsole console = new IOConsole();
        console.println("Welcome to the game of slots!");
        String playerChoice = console.getStringInput("Please spin by typing 'spin'");
        while("spin".equals(playerChoice)) {
            Random rand = new Random();
            int random1 = rand.nextInt(5);
            int random2 = rand.nextInt(5);
            int random3 = rand.nextInt(5);
            console.println("You spun: %s %s %s ", random1, random2, random3);
            playerChoice = console.getStringInput("Type 'y' if you'd like to spin again.");
            if("y".equals(playerChoice)) {
                playerChoice = "spin";
            }
        }
    }
}