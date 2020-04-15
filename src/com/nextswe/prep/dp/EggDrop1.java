package com.nextswe.prep.dp;

public class EggDrop1 {
    int egg(int numberOfEggs, int numberOfFloors){
        //base case
        if(numberOfEggs==1){
            return numberOfFloors;
        }
        if(numberOfFloors==1){
            return 1;
        }
        if(numberOfFloors==0){
            return 0;
        }

        int minimum = Integer.MAX_VALUE;

        for(int x=1;x<=numberOfFloors;x++) {
            minimum = Math.min(minimum, (1 + Math.max(
                    egg(numberOfEggs, numberOfFloors - x),
                    egg(numberOfEggs - 1, x - 1))));
        }
        return minimum;
    }

    public static void main(String[] args){
        EggDrop1 eggDrop = new EggDrop1();
        System.out.println(eggDrop.egg(2,3));
    }
}
