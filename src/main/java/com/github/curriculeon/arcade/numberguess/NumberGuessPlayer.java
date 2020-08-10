package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessPlayer implements PlayerInterface<NumberGuessGame> {
    private ArcadeAccount account;
    private  NumberGuessSlot numberGuessSlot = new NumberGuessSlot();
    IOConsole console = new IOConsole(AnsiColor.YELLOW);



    public NumberGuessPlayer(ArcadeAccount account){
        this.account = account;
    }
    @Override
    public ArcadeAccount getArcadeAccount() {
        return account;
    }

    @Override
    public void play(NumberGuessGame guessGame, String userInput) {
        if ((!"quit".equalsIgnoreCase(userInput)) || (!"N".equalsIgnoreCase(userInput))) {
            numberGuessSlot.runPlay(guessGame, userInput);
        } else if ("quit".equalsIgnoreCase(userInput)) {
        } else {
            console.println("You dun messed up");
            console.println("Mm hmm, you crazy ");
            console.println("Not valid %s", userInput);
            play(guessGame, userInput);
        }
    }

    }// numberguessplayer class ends