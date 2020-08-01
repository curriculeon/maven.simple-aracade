package com.github.curriculeon.arcade.slots;

import java.util.*;

public class SlotsReelManager {
    private static List<SlotsReel> resultList = new ArrayList<>(3);

    public static List<SlotsReel> getResultList() {
        for (int i = 0; i < 3; i++) {
            Integer randomOrdinal = new Random().nextInt(5);
            SlotsReel slotsReel = null;
            for(SlotsReel sr : SlotsReel.values()) {
                if(sr.ordinal() == randomOrdinal) {
                    slotsReel = sr;
                }
            }
            resultList.add(slotsReel);
        }
        return resultList;
    }

    public static Double getWinningPrice(List<SlotsReel> list) {
        Double winningPrice = 0D;
        for (int i = 0; i < list.size(); i++) {
             winningPrice += (list.get(i).ordinal() + 1) * 0.4;
        }
        list.clear();
        return winningPrice;
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
//            List<SlotsReel> list1 = getResultList();
//            System.out.printf("%dth Time: " + list1 + " The price is $%.2f.\n", i + 1, getWinningPrice(list1) );
//        }
//    }
}
