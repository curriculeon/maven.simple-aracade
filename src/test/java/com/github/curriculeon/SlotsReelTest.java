package com.github.curriculeon;

import com.github.curriculeon.arcade.slots.ReelImage;
import org.junit.Assert;
import org.junit.Test;


public class SlotsReelTest {
    @Test
    public void testCherry() {
        // given
        ReelImage cherry = ReelImage.CHERRY;
        int expectedValue = 500;

        // when
        int actualValue = cherry.getValueOfImage();

        // then
        Assert.assertEquals(expectedValue, actualValue);
    }
}