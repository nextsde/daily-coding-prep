package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1029 {
    public int twoCitySchedCost(int[][] costs) {
        int[] refund = new int[costs.length];
        int result = 0;
        for(int i=0;i<costs.length;i++){
            result += costs[i][0];
            refund[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(refund);
        for(int i=0;i<costs.length/2;i++){
            result += refund[i];
        }
        return result;
    }

    public static void main(String[] args){
        P1029 mP1029 = new P1029();
        System.out.println(mP1029.twoCitySchedCost(new int[][]
                {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));
        //{{448,54},{926,667},{840,118},{577,469}}
        // A: {184,139}
        // A: {259,770}
        // A: {259,770}
        //[{184,139}, {259,770}, {448,54}, {577,469}, {840,118}, {926,667}]
        //[{448,54}, {840,118}, {184,139}, {577,469}, {926,667}, {259,770}]

        //[{184,139}, {259,770}, {577,469}, {926,667}]
        //[{184,139}, {577,469}, {926,667}, {259,770}]
        //B: {448,54}
        //B: {840,118}

        //0 : A -> 259
        //1 : B -> 54
        //2 : B -> 667
        //3 : A -> 184
        //4 : B -> 118
        //5 : A -> 577
    }
}
