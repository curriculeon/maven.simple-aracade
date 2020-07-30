package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame implements GameInterface {
    private IOConsole console = new IOConsole(AnsiColor.PURPLE);
    private IOConsole consoleGameOver = new IOConsole(AnsiColor.RED);
    private NumberGuessPlayer player;

    public NumberGuessGame(){}

    public NumberGuessGame(NumberGuessPlayer player) {
        this.player = player;
    }

    @Override
    public void add(PlayerInterface player) {
        this.player.setPlayerName(player.getArcadeAccount().getAccountName());
        this.player.setPlayerPassword(player.getArcadeAccount().getAccountPassword());
    }

    @Override
    public void remove(PlayerInterface player) {
        this.player = null;
    }

    @Override
    public void run() {
        play(player);
    }

    private void play(NumberGuessPlayer player) {
        Integer numberToGuess;
        Integer currentGuess = null;
        Integer numberOfTried = 5;
        Integer min = 0;
        Integer max = 0;
        console.println("%s, WELCOME to The Number Guess Game:", player.getPlayerName());
        while(max <= min) {
            min = console.getIntegerInput("Enter the lowest number your are expecting to guess:");
            max = console.getIntegerInput("Enter the highest number your are expecting to guess:");
        }
        numberToGuess = new Random().nextInt(max - min) + min;
        console.println("The number to guess is: %d", numberToGuess); // For testing
        currentGuess = console.getIntegerInput("Guess a number between %d and %d.", min, max);

        while(numberToGuess != currentGuess && numberOfTried != 0) {
            if(currentGuess < min || currentGuess > max) {
                console.println("The number is out of range, TRY AGAIN!");
                currentGuess = console.getIntegerInput("Guess a number between %d and %d.", min, max);
            } else if(currentGuess >= min && currentGuess < numberToGuess) {
                min = currentGuess;
                numberOfTried--;
                console.println("Good try, but the number is bigger than %d, TRY AGAIN!", currentGuess);
                currentGuess = console.getIntegerInput("Guess a number between %d and %d.", min, max);
            } else if(currentGuess > numberToGuess && currentGuess <= max) {
                max = currentGuess;
                numberOfTried--;
                console.println("Good try, but the number is smaller than %d, TRY AGAIN!", currentGuess);
                currentGuess = console.getIntegerInput("Guess a number between %d and %d.", min, max);
            }
        }
        if(numberToGuess == currentGuess) consoleGameOver.println("Congratulations, you found the number. %d was the number.", currentGuess);

        if(numberOfTried == 0) consoleGameOver.println("THE GAME IS OVER you tried %d times, %d was the number, you couldn't guess it.", numberOfTried, numberToGuess);

        String playerNextMove = console.getStringInput("Do you want to continue playing? \n [ new-game ] ");

        if(playerNextMove.equalsIgnoreCase("new-game")) {
            play(player);
        } else {
            consoleGameOver.println("THE GAME IS OVER");
        }

    }
}