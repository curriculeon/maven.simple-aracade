package com.github.curriculeon.utils;

import java.io.InputStream;
import java.io.PrintStream;

public interface IOSocketInterface {
    default IOConsole getIOConsole() {
        return getIOConsole(AnsiColor.AUTO);
    }

    default IOConsole getIOConsole(AnsiColor ansiColor) {
        return getIOConsole(ansiColor, System.in, System.out);
    }

    default IOConsole getIOConsole(AnsiColor ansiColor, InputStream inputStream, PrintStream printStream) {
        return new IOConsole(ansiColor, inputStream, printStream);
    }
}
