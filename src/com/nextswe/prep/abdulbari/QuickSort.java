package com.nextswe.prep.abdulbari;

import java.util.Arrays;

public class QuickSort {
    public int partition(int[] A, int l, int h){
        int pivot = A[l];
        int i = l;
        int j = h;
        while(i<j) {
            do{
                i++;
            }while(i<A.length && A[i]<=pivot);
            do{
                j--;
            }while(j>=0 && A[j]>pivot);
            if (i < j) {
                //swap
                A[i] = A[i] ^ A[j];
                A[j] = A[j] ^ A[i];
                A[i] = A[i] ^ A[j];
            }
        }

        A[j] = A[j] ^ A[l];
        A[l] = A[l] ^ A[j];
        A[j] = A[j] ^ A[l];

        return j;
    }

    public void quick_sort_helper(int[] A, int l, int h){
        if(l<h){
            int j = partition(A,l,h);
            quick_sort_helper(A,l,j-1);
            quick_sort_helper(A,j+1,h);
        }
    }

    public void quick_sort(int[] A){
        quick_sort_helper(A,0,A.length-1);
    }

    public static void main(String[] args){
        int A[] = new int[]{10,7,8,9,1,5};
        QuickSort mQuickSort = new QuickSort();
        mQuickSort.quick_sort(A);
        System.out.println(Arrays.toString(A));
    }
}
