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

    private ReelImage getRandomImages() {
        ReelImage[] imageArray = ReelImage.values();
        List<ReelImage> imageReelList = Arrays.asList(imageArray);
        Collections.shuffle(imageReelList);
        return imageReelList.get(0);
    }

    public void spin() {
        image1 = getRandomImages();
        image2 = getRandomImages();
        image3 = getRandomImages();
    }

    public void display() {
        IOConsole console = new IOConsole(AnsiColor.PURPLE);
        console.println("Image 1 = " + image1);
        console.println("Image 2 = " + image2);
        console.println("Image 3 = " + image3);
    }
}
