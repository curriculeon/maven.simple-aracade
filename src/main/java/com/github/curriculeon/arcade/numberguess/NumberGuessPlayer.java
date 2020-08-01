package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessPlayer implements PlayerInterface<NumberGame> {
    private ArcadeAccount arcadeAccount;
    private NumberGame numberGame = new NumberGame();

    public NumberGuessPlayer(ArcadeAccount arcadeAccount) {
        this.arcadeAccount = arcadeAccount;
    }

    @Override
    public ArcadeAccount getArcadeAccount() {
        return arcadeAccount;
    }

    @Override
    public void play(NumberGame game, String userInput) {
        IOConsole console = new IOConsole(AnsiColor.YELLOW);
        int actualNumber;

        if (!("quit".equals(userInput))) {
            System.out.println("Your guessed number is:" + userInput);
            actualNumber = numberGame.displayNumber();
            System.out.println("The actual number is " + actualNumber);
            if (Integer.valueOf(userInput) == actualNumber) {
                System.out.println("Your guess is correct. Congratulations!");
            } else if (Integer.valueOf(userInput) < actualNumber) {
                System.out.println("Your guess is smaller than the number.");
            } else {
                System.out.println("Your guess is greater than the number.");
            }
        } else if("quit".equals(userInput)) {
        }  else {
            console.println(userInput + " is not a valid input");
            console.println("try again");
            play(numberGame, userInput);
        }

    }
}