package com.nextswe.prep.abdulbari;

public class MergeSort {
    public static void merge(int[] A, int[] B, int[] C){
        int m = A.length-1;
        int n = B.length-1;
        int i = 0,j = 0,k = 0;
        while(i<=m && j<=n){
            if(A[i]<B[j]){
                C[k++] = A[i++];
            }else{
                C[k++] = B[j++];
            }
        }
        while(i<=m){
            C[k++] = A[i++];
        }
        while(j<=n){
            C[k++] = A[j++];
        }
    }

    public static void main(String[] args){

    }
}
