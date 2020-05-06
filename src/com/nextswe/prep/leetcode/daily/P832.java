package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;

public class P832 {
    public int[] flipNInvert(int[] A){
        for(int i=0,j=A.length-1;i<=j;i++,j--){
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
        for(int i=0;i<A.length;i++){
            A[i] = A[i]==0?1:0;
        }
        return A;
    }
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i=0;i<A.length;i++){
            A[i] = flipNInvert(A[i]);
        }
        return A;
    }

    public static void main(String[] args){

    }
}
