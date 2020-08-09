package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Slot {
    private SlotReel imageOne;
    private SlotReel imageTwo;
    private SlotReel imageThree;

    public void spin(){
       imageOne = getRandom();
       imageTwo = getRandom();
       imageThree = getRandom();
    }

    private SlotReel getRandom() {
        SlotReel[] slotSpin = SlotReel.values();
        List<SlotReel> slotReelList = Arrays.asList(slotSpin);
        Collections.shuffle(slotReelList);
        return slotReelList.get(0);
    }

    public void display(){
        IOConsole console = new IOConsole(AnsiColor.PURPLE);
        console.println("image 1 = " + imageOne);
        console.println("image 1 = " + imageTwo);
        console.println("image 1 = " + imageThree);
    }
}
