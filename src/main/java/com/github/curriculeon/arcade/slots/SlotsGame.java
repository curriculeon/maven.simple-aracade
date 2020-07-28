package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.IOConsole;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {

    private PlayerInterface player;
    @Override
    public void add(PlayerInterface player) {
        this.player = player;
    }

    @Override
    public void remove(PlayerInterface player) {
        this.player = null;
    }

    @Override
    public void run() {
        player.play();
        remove(player);
    }
}
