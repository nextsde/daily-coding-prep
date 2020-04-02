package com.nextswe.prep.sorts;


import java.util.Random;

public class BasicSort {
    public static void swap(int A[], int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    //https://www.youtube.com/watch?v=GUDLRan2DWM
    public static void selection_sort(int A[]){
        int n = A.length;
        int iMin = 0;
        //don't need to look at last element since it will be sorted anyway
        //since all of the smaller element got selected and swapped with earlier position
        for(int i = 0; i<n-1; i++){
            iMin = i;
            for(int j=i+1;j<n;j++){
                if(A[j]<A[iMin]){
                    iMin = j;
                }
            }
            swap(A,i,iMin);
        }
    }

    public static void bubble_sort(int A[]){
        int n = A.length;
        //slight improvement O(n^2)
        int flag = 0;
        for(int i=0;i<n;i++){
            flag = 0;
            for(int j=0;j<n-i-1;j++){
                if(A[j]>A[j+1]){
                    swap(A,j,j+1);
                    flag = 1;
                }
            }
            if(flag==0){
                break;
            }
        }
        /*
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(A[j]>A[j+1]){
                    swap(A,j,j+1);
                }
            }
        }*/

        //general aproach O(n^2)
        /*
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(A[j]>A[j+1]){
                    swap(A,j,j+1);
                }
            }
        }
        */
    }

    public static void insertion_sort(int[] A){
        int n = A.length;
        int hole = 0;
        int value = 0;
        for(int i=1;i<n;i++){
            value = A[i];
            hole = i;
            while(hole>0 && A[hole-1]>value){
                A[hole] = A[hole-1];
                hole = hole-1;
            }
            A[hole] = value;
        }
    }


    private static void merge(int[] left, int[] right, int[] A){
        int nL = left.length;
        int nR = right.length;
        int i = 0;
        int j = 0;
        int k = 0;

        while(i<nL && j<nR){
            if(left[i]<=right[j]){
                A[k] = left[i];
                i++;
            }else{
                A[k] = right[j];
                j++;
            }
            k++;
        }
        while(i<nL){
            A[k] = left[i];
            i++;
            k++;
        }
        while(j<nR){
            A[k] = right[j];
            j++;
            k++;
        }
    }

    public static void mergesort(int A[]){
        int n = A.length;
        if(n<2){
            return;
        }
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];
        for(int i=0;i<mid;i++){
            left[i] = A[i];
        }
        for(int j=mid;j<n;j++){
            right[j-mid] = A[j];
        }
        mergesort(left);
        mergesort(right);
        merge(left,right,A);
    }


    static Random randomNumberGenerator = new Random();

    private static int randomizedPartition(int[] A, int start, int end){
        int rnd = randomNumberGenerator.nextInt(end);
        int pivotIndex = start+ (rnd %(end-start));
        int tmp =  A[pivotIndex];
        A[pivotIndex] = A[end];
        A[end] = tmp;
        return partition(A,start,end);
    }

    private static int partition(int[] A, int start, int end){
        int pivot = A[end];
        int pindex = start;
        for(int i = start;i<end;i++){
            if(A[i]<=pivot){
                swap(A,i,pindex);
                pindex++;
            }
        }
        int tmp = A[pindex];
        A[pindex] = pivot;
        A[end] = tmp;

        return pindex;
    }

    private static void qsort(int[] A, int start, int end){
        if(start<end){
            int pindex = randomizedPartition(A,start,end);
            qsort(A,start,pindex-1);
            qsort(A,pindex+1,end);
        }
    }

    public static void qsort(int[] A){
        qsort(A,0,A.length-1);
    }
}
