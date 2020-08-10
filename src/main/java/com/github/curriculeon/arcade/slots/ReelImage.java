package com.github.curriculeon.arcade.slots;

public enum ReelImage {
    CHERRY(500),
    LEMON(750),
    SEVEN(100),
    DIAMOND(9999);
    Integer valueOfSlot;

    ReelImage(Integer valueOfSlot){
        this.valueOfSlot = valueOfSlot;


    }

    public Integer getValueOfSlot() {
        return valueOfSlot;
    }
}
