package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer implements PlayerInterface {
    private ArcadeAccount account;

    public SlotsPlayer(ArcadeAccount account){
        this.account = account;

    }    @Override
    public ArcadeAccount getArcadeAccount() {
        return account;
    }

    @Override
    public void play(Object slot) {
        
    }

    @Override
    public String toString() {
        return account.getAccountName();
    }
}