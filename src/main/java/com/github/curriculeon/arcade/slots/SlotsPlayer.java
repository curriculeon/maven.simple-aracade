package com.github.curriculeon.arcade.slots;
import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

public class SlotsPlayer implements PlayerInterface  {
        private ArcadeAccount account;

        public SlotsPlayer(){};

        public SlotsPlayer(ArcadeAccount account) {
            this.account = account;
        }


        public ArcadeAccount getArcadeAccount() {
            return account;
        }


        public void play(SlotsReel slotsReel, String userInput) {
            IOConsole console = new IOConsole(AnsiColor.YELLOW);
            if("pull-lever".equals(userInput)) {
                slotsReel.spin();
            } else if("view-slot-reel".equals(userInput)) {
                slotsReel.display();
            } else if("quit".equals(userInput)) {
            } else {
                console.println("You dun messed up");
                console.println("Mm hmm, knew you would");
                console.println("%s is not a valid input", userInput);
                console.println("Please, try again");
                play(slotsReel, userInput);
            }
        }
    }
















