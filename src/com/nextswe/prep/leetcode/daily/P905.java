package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P905 {
/*
    public int[] sortArrayByParity(int[] A) {
        PriorityQueue<Integer> oddHeap = new PriorityQueue<>();
        PriorityQueue<Integer> evenHeap = new PriorityQueue<>();
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                evenHeap.add(A[i]);
            }else{
                oddHeap.add(A[i]);
            }
        }
        int i = 0;
        while(!evenHeap.isEmpty()){
            A[i++]=evenHeap.poll();
        }
        while(!oddHeap.isEmpty()){
            A[i++]=oddHeap.poll();
        }
        return A;
    }
*/

/*
    public int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        Arrays.sort(A);
        int j = 0;
        int k = B.length-1;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                B[j++] = A[i];
            }else{
                B[k--] = A[i];
            }
        }
        return B;
    }
*/

/*
    public int[] sortArrayByParity(int[] A) {
        Integer[] B = new Integer[A.length];
        for (int t = 0; t < A.length; ++t)
            B[t] = A[t];
        Arrays.sort(B, new Comparator<Integer>(){

            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(a%2, b%2);
            }
        });
        for (int t = 0; t < A.length; ++t)
            A[t] = B[t];
        return A;
    }
*/

    public int[] sortArrayByParity(int[] A) {
        //in place
        int i = 0, j = A.length-1;
        while(i<j){
            if(A[i]%2>A[j]%2){
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if(A[i]%2==0) i++;
            if(A[j]%2==1) j--;
        }
        return A;
    }

    public static void main(String[] args){
        P905 mP905 = new P905();
        System.out.println(Arrays.toString(mP905.sortArrayByParity(new int[]{3,1,2,4})));
    }
}
