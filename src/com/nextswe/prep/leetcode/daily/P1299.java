package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;

public class P1299 {
    //better - O(n)
    public int[] replaceElements(int[] arr) {
        if(arr.length==0){
            return arr;
        }
        int greatest = arr[arr.length-1];
        for(int i=arr.length-1;i>=0;i--){
            int tmp = arr[i];
            arr[i] = greatest;
            if(greatest<tmp){
                greatest = tmp;
            }
        }
        arr[arr.length-1] = -1;
        return arr;
    }

/*
    //O(n^2) solution
    public int[] replaceElements(int[] arr) {
        if(arr.length==0){
            return arr;
        }
        for(int i=1;i<arr.length;i++){
            int greatest = Integer.MIN_VALUE;
            for(int j=i;j<arr.length;j++){
                if(greatest<arr[j]){
                    greatest = arr[j];
                }
            }
            arr[i-1] = greatest;
        }
        arr[arr.length-1] = -1;
        return arr;
    }
*/

    public static void main(String[] args){
        P1299 mP1299 = new P1299();
        System.out.println(Arrays.toString(mP1299.replaceElements(new int[]{17,18,5,4,6,1})));
    }
}
