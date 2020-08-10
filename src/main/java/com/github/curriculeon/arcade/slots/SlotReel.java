package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SlotReel {
    private ReelImage imageOne;
    private ReelImage imageTwo;
    private ReelImage imageThree;

    public void spin(){
       imageOne = getRandom();
       imageTwo = getRandom();
       imageThree = getRandom();
    }

    private ReelImage getRandom() {
        ReelImage[] imageArray = ReelImage.values();
        List<ReelImage> imageList = Arrays.asList(imageArray);
        Collections.shuffle(imageList);
        return imageList.get(0);
    }

    public void display(){
        IOConsole console = new IOConsole(AnsiColor.PURPLE);
        console.println("image 1 = " + imageOne);
        console.println("image 2 = " + imageTwo);
        console.println("image 3 = " + imageThree);
    }
}
