package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.*;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {
    private static final IOConsole console = new IOConsole(AnsiColor.PURPLE);
    List<PlayerInterface> players = new ArrayList<>();
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
        boolean playing = true;
        for(PlayerInterface player: players){
            console.println("Welcome to the Slots game");
            while(true) {
                console.println("Pull the lever.");
                playing = (player.play()[0] == 1);
                if(!playing)
                    break;
                Integer[] array = createRandomArray();
                console.println(Arrays.toString(array) );
                console.println(isWinner(array) ? "WINNER!!!" : "LOSER :(");
            }
        }

    }

    private Integer[] createRandomArray() {
        Random rand = new Random();
        Integer[] tempArray = new Integer[3];
        for(int i = 0; i < tempArray.length;i++)
            tempArray[i] = rand.nextInt(3);
        return tempArray;
    }
    private boolean isWinner(Integer[] randomArray){
        Set<Integer> tempArray = new HashSet<>(Arrays.asList(randomArray));
        return (tempArray.size() == 1);
    }


}
