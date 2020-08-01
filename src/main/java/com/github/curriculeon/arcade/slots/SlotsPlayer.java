package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer implements PlayerInterface<SlotsReel> {
    private ArcadeAccount arcadeAccount;

    public SlotsPlayer(ArcadeAccount arcadeAccount) {
        this.arcadeAccount = arcadeAccount;
    }


    @Override
    public ArcadeAccount getArcadeAccount() {
        return arcadeAccount;
    }

    @Override
    public void play(SlotsReel slotsReel, String userInput) {
        IOConsole console = new IOConsole(AnsiColor.YELLOW);
        if("pull-lever".equals(userInput)) {
            slotsReel.spin();
        } else if("view-slot-reel".equals(userInput)) {
            slotsReel.display();
        } else if("quit".equals(userInput)) {
        } else {

            console.println(userInput+" is not a valid input");
            console.println("try again");
            play(slotsReel, userInput);
        }
    }


}