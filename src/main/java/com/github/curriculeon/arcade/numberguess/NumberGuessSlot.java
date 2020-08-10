package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

public class NumberGuessSlot {
    IOConsole console = new IOConsole(AnsiColor.YELLOW);
    NumberGuessPlayer numberGuessPlayer;

    int guess = 0;

    public void runPlay(NumberGuessGame numberGuessGame, String userInput){
        int guess = 0;
        do {
        console.println("I am thinking of a number between 1 and 10");
        userInput = console.getStringInput("guess what the number is:");
        int number = Integer.parseInt(userInput);
        int random = (int) (Math.random() * 10) + 1;
        if (random == number){
            console.println("Great job your %s guessing number was correct", number);
            console.println("The number was: %s", random);
        } else if(random != number){
            console.println("Your %s guessing number was wrong you loose", number);
            console.println("The correct number was %s", random);
        }else {
            console.println("You dun messed up");
            console.println("Mm hmm, you crazy ");
            console.println("Not valid %s", userInput);
            numberGuessPlayer.play(numberGuessGame, userInput);
        }

    }while (!"quit".equalsIgnoreCase(userInput) || !"N".equalsIgnoreCase(userInput));
}//play method
}
