package com.github.curriculeon.arcade.games;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractGame<SomePlayerType extends PlayerInterface>
        implements GameInterface<SomePlayerType> {
    private List<SomePlayerType> playerList;

    public AbstractGame() {
        this(new ArrayList<>());
    }

    public AbstractGame(List<SomePlayerType> playerList) {
        this.playerList = playerList;
    }

    @Override
    public List<SomePlayerType> getPlayerList() {
        return playerList;
    }
}
