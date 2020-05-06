package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;
import java.util.Collections;

public class P1054_trylater {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Integer[] sort1 = new Integer[barcodes.length];
        Integer[] sort2 = new Integer[barcodes.length];

        for(int i = 0;i<barcodes.length;i++){
            sort1[i]= sort2[i] = barcodes[i];
            barcodes[i] = 0;
        }

        Arrays.sort(sort1);
        Arrays.sort(sort2, Collections.reverseOrder());

        int k1 = 0;
        int k2 = 0;
        int n = barcodes.length/2;
        int i = 0;
        while(n>0){
            barcodes[i++] = sort1[k1++];
            barcodes[i++] = sort2[k2++];
            n--;
        }
        if(barcodes.length>1 && barcodes.length%2==1 && sort1[k1].equals(sort2[k2])){
            barcodes[i] = sort1[k1];
            if(barcodes[i-1]==barcodes[i]){
                int tmp = barcodes[0];
                barcodes[0] = barcodes[i-1];
                barcodes[i-1] = tmp;
            }
        }else{
            if(barcodes.length>1 && barcodes[i-2]==barcodes[i-1]){
                int tmp = barcodes[0];
                barcodes[0] = barcodes[i-2];
                barcodes[i-2] = tmp;
            }
        }
        return barcodes;
    }

    public static void main(String[] args){
        P1054_trylater mP1054 = new P1054_trylater();
        System.out.println(Arrays.toString(mP1054.rearrangeBarcodes(
                new int[]{1,1,1,2,2,2}
        )));
        System.out.println(Arrays.toString(mP1054.rearrangeBarcodes(
                new int[]{1,1,1,1,2,2,3,3}
        )));

        System.out.println(Arrays.toString(mP1054.rearrangeBarcodes(
                new int[]{2,2,1,3}
        )));

        System.out.println(Arrays.toString(mP1054.rearrangeBarcodes(
                new int[]{2,2,2,1,5}
        )));
        System.out.println(Arrays.toString(mP1054.rearrangeBarcodes(
                new int[]{2,2,9,9,9,9,10,10,10,9}
        )));
    }
}
