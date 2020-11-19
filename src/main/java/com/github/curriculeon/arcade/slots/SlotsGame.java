package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;


/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {

    ArcadeAccount arcadeAccount;
    public void add(PlayerInterface player){

        arcadeAccount=player.getArcadeAccount();
    }
    public void remove(PlayerInterface player){
    }
    public void run() {
        IOConsole ioConsole = new IOConsole(AnsiColor.RED);
        Long a=ioConsole.getLongInput("You are in Slots Game. Please enter any digit between 0-9 ","1");
        if(a!=null)
        {
            if(a.longValue()==4){
                  ioConsole.println("You are winner","3");
            }else
            {
                ioConsole.println("Sorry. Keep Trying...You are very close","3");
            }
        }
    }
}
