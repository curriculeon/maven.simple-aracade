package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class SlotsReel {
    private ReelImage image1;
    private ReelImage image2;
    private ReelImage image3;

    private ReelImage getRandom() {
        ReelImage[] imageReelArray = ReelImage.values();
        List<ReelImage> imageReelList = Arrays.asList(imageReelArray);
        Collections.shuffle(imageReelList);
        return imageReelList.get(0);
    }

    public void spin() {
        image1 = getRandom();
        image2 = getRandom();
        image3 = getRandom();
    }

    public void display() {
        IOConsole console = new IOConsole(AnsiColor.PURPLE);
        console.println("ReelImage 1 = " + image1);
        console.println("ReelImage 2 = " + image2);
        console.println("ReelImage 3 = " + image3);
    }
}