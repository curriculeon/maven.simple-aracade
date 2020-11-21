package com.github.curriculeon.arcade.utils.ansicolor;

import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;
import org.junit.Test;

public class TestValues {
    @Test
    public void test() {
        for(AnsiColor ansiColor : AnsiColor.values()) {
            new IOConsole(ansiColor).println("Color = ".concat(ansiColor.name()));
        }
    }
}
