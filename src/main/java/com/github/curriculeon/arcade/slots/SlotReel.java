package com.github.curriculeon.arcade.slots;

public enum SlotReel {
    CHERRY(500),
    LEMON(750),
    SEVEN(100),
    DIAMOND(9999);
    Integer valueOfSlot;

    SlotReel(Integer valueOfSlot){
        this.valueOfSlot = valueOfSlot;


    }

    public Integer getValueOfSlot() {
        return valueOfSlot;
    }
}
