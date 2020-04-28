package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;

public class P88_trylater {
    public void merge(int[] A, int m, int[] B, int n) {
        if((m==0 && A.length==0) || n==0){
            return;
        }
        int i = 0,j = 0;
        while(i<m){
            if(A[i]<=B[j]){
                i++;
            }else{
                int tmp = A[i];
                A[i++] = B[j];
                B[j++] = tmp;
            }
        }
        j = 0;
        while(j<n){
            A[i+j] = B[j];
            j++;
        }
    }

    public static void main(String[] args){
        P88_trylater pp = new P88_trylater();
//        int[] mm = new int[]{1,0};
//        pp.merge(mm,1,new int[]{2},1);
//        int[] mm = new int[]{1};
//        pp.merge(mm,1,new int[]{},0);
//        System.out.println(Arrays.toString(mm));

//        int[] mm = new int[]{4,5,6,0,0,0};
//        pp.merge(mm,3,new int[]{1,2,3},3);
//        System.out.println(Arrays.toString(mm));

        int[] mm = new int[]{4,0,0,0,0,0};
        pp.merge(mm,1,new int[]{1,2,3,5,6},5);
        System.out.println(Arrays.toString(mm));
    }
}
