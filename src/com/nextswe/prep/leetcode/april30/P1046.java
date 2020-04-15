package com.nextswe.prep.leetcode.april30;

import java.util.Random;

//solved in April 16
//complexity n^2logn
//not good solution
//using priority queue would've been better
//good thing is that it does not require any extra space and since qsort is in place sorting algorithm(recall)
public class P1046 {
    static Random randomNumberGenerator = new Random();

    public void swap(int A[], int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    private int randomizedPartition(int[] A, int start, int end){
        int rnd = randomNumberGenerator.nextInt(end);
        int pivotIndex = start+ (rnd %(end-start));
        int tmp =  A[pivotIndex];
        A[pivotIndex] = A[end];
        A[end] = tmp;
        return partition(A,start,end);
    }

    private int partition(int[] A, int start, int end){
        int pivot = A[end];
        int pindex = start;
        for(int i = start;i<end;i++){
            if(A[i]>=pivot){
                swap(A,i,pindex);
                pindex++;
            }
        }
        int tmp = A[pindex];
        A[pindex] = pivot;
        A[end] = tmp;

        return pindex;
    }

    private void qsort(int[] A, int start, int end){
        if(start<end){
            int pindex = randomizedPartition(A,start,end);
            qsort(A,start,pindex-1);
            qsort(A,pindex+1,end);
        }
    }

    public void qsort(int[] A){
        qsort(A,0,A.length-1);
    }


    public int lastStoneWeight(int[] stones) {
        if(stones.length==1){
            return stones[0];
        }
        qsort(stones);
        while(!(stones[0]>=0 && stones[1] == 0 )){
            if(stones[0]==stones[1]){
                stones[0] = 0;
                stones[1] = 0;
            }else{
                stones[0] = stones[0] - stones[1];
                stones[1] = 0;
            }
            qsort(stones);
        }
        return stones[0];
    }

    public static void main(String[] args){
        P1046 p5 = new P1046();
        System.out.println(p5.lastStoneWeight(new int[]{1,3}));
//        System.out.println(p5.lastStoneWeight(new int[]{2,7,4,1,8,1}));
//        System.out.println(p5.lastStoneWeight(new int[]{2,7,4,1,12,1}));
    }
}
