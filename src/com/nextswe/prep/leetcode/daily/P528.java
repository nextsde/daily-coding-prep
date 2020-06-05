package com.nextswe.prep.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class P528 {
/*    // int totalWeight = 0;
    List<Integer> list;
    public P528(int[] W) {
        // for(int i=0;i<W.length;i++){
        //     totalWeight += W[i];
        // }
        list = new ArrayList<>();
        for(int i=0;i<W.length;i++){
            int n = W[i];
            while(n!=0){
                list.add(i);
                n--;
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
    // int index = 0;
    public int pickIndex() {
        int index = (int)(Math.random()*list.size());
        System.out.println(index);
        int val = list.get(index);
        // index++;
        // if(index==list.size()){
        //     index = 0;
        // }
        return val;
    }*/

    int totalWeight = 0;
    List<Integer> list;
    int[] sumArray;
    Random random = new Random();
    public P528(int[] W) {
        list = new ArrayList<>();
        sumArray = new int[W.length];
        sumArray[0] = W[0];
        for(int i=1;i<W.length;i++){
            sumArray[i] = sumArray[i-1] + W[i];
        }
        totalWeight = sumArray[sumArray.length-1];
    }
    public int pickIndex() {
        int rnd = random.nextInt(totalWeight) + 1;
        int bid = Arrays.binarySearch(sumArray,rnd);
        if(bid < 0) bid = -bid - 1;
        return bid;
    }

    public static void main(String[] args){
        P528 mP528 = new P528(new int[]{1,3,4,5,2});
        mP528.pickIndex();
        mP528.pickIndex();
        mP528.pickIndex();
        mP528.pickIndex();
//        System.out.print(mP528.pickIndex() +" ");
//        System.out.print(mP528.pickIndex() +" ");
//        System.out.print(mP528.pickIndex() +" ");
//        System.out.print(mP528.pickIndex() +" ");
    }
}
