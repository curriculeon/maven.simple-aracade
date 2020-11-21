package com.github.curriculeon.utils;

/**
 * Created by leon on 7/21/2020.
 * used to create color for output of `IOConsole`
 */
public enum AnsiColor {
    UNDERLINED("\33[4m"),
    AUTO(0),
    GRAY(37),
    BLACK("\33[90m"),
    RED(31),
    YELLOW(33),
    GREEN(32),
    CYAN(36),
    BLUE(34),
    PURPLE(35),
    ;

    private final String color;

    AnsiColor(String color) {
        this.color = color;
    }

    AnsiColor(int ansiNumber) {
        this.color = "\u001B[" + ansiNumber + "m";
    }

    public String getColor() {
        return color;
    }

}