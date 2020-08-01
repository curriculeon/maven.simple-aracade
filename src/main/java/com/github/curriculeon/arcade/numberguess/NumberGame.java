package com.github.curriculeon.arcade.numberguess;

public class NumberGame {
    private int number;

    public Integer displayNumber(){
        number = (int) (Math.random() * 99 + 1);
        return number;
    }
}