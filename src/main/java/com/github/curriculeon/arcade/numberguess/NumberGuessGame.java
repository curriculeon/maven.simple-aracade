package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame implements GameInterface {
    List<PlayerInterface> players = new ArrayList<PlayerInterface>();
    private static final IOConsole console = new IOConsole(AnsiColor.BLUE);
    @Override
    public void add(PlayerInterface player) {
        players.add(player);

    }

    @Override
    public void remove(PlayerInterface player) {
        players.remove(player);
    }

    @Override
    public void run() {
        console.println("Welcome to the Number Guess game");
        console.println("You must enter 5 numbers between 0 and 100.");
        console.println("It will be compared to 5 random integers. and ");
        console.println("If the total sum of the difference between each respective number is less than 100 you are a WINNER!");
        int total = 0;
        for(PlayerInterface player: players) {
            total = 0;
            Integer[] guessedNumbers = player.play();
            Integer[] randomNumbers = createRandomArray();
            for( int i = 0; i < 5; i++){
                total+= Math.abs(guessedNumbers[i]-randomNumbers[i]);
            }
            console.println(Arrays.toString(randomNumbers));
            console.println("Total: " + total);
            if(total < 100)
                console.println("YOU WIN!!!");
            else
                console.println("YOU LOSE :(");
        }


    }

    private Integer[] createRandomArray() {
        Random rand = new Random();
        Integer[] tempArray = new Integer[5];
        for(int i = 0; i < tempArray.length;i++)
            tempArray[i] = rand.nextInt(100);
        return tempArray;
    }
}