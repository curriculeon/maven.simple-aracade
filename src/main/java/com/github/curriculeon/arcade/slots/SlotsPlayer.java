package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer implements PlayerInterface<SlotReel> {
    private ArcadeAccount account;

    public SlotsPlayer(ArcadeAccount account){
        this.account = account;

    }    @Override
    public ArcadeAccount getArcadeAccount() {
        return account;
    }

    @Override
    public void play(SlotReel slotReel, String userInput) {
        IOConsole console = new IOConsole(AnsiColor.PURPLE);
        if ("pull-lever".equalsIgnoreCase(userInput)) {
            slotReel.spin();
        }else if ("view-slot-real".equalsIgnoreCase(userInput)){
            slotReel.display();
        } else if ("quit".equalsIgnoreCase(userInput)) {

        }else {
            console.println("You dun messed up");
            console.println("Mm hmm, you crazy ");
            console.println("Not valid %s", userInput);
            play(slotReel, userInput);
        }

    }


    @Override
    public String toString() {
        return account.getAccountName();
    }
}