package com.nextswe.prep.ds_goodrich.chapter12;

import com.nextswe.prep.utils.Utils;

import java.util.*;

//https://www.youtube.com/watch?v=hGK_5n81drs
public class KthSelect {
    private static Random rand = new Random();
    public static int getRandomPartition(int[] A, int start, int end){
        int rnd = rand.nextInt(end);
        int pid = start + (rnd%(end-start));
        int tmp = A[pid];
        A[pid] = A[end];
        A[end] = tmp;
        return getPartition(A,start,end);
    }
    public static int getPartition(int[] A, int start, int end){
        int pValue = A[end];
        int pid = start;
        for(int i=start;i<end;i++){
            if(A[i]<pValue){
                int tmp = A[pid];
                A[pid] = A[i];
                A[i] = tmp;
                pid++;
            }
        }
        A[end] = A[pid];
        A[pid] = pValue;
        return pid;
    }

/*
    public static void qsort(int[] A, int start, int end){
        if(start<end){
            int pIndex = getRandomPartition(A,start,end);
            qsort(A,start,pIndex-1);
            qsort(A,pIndex+1,end);
        }
    }
*/
    //expected O(n) time
    public static int kthSmallest(int[] A, int k, int start, int end){
        if(start<end){
            int pIndex = getRandomPartition(A,start,end);
            if(k-1<pIndex) {
                return kthSmallest(A, k, start, pIndex - 1);
            }else if (k-1>pIndex) {
                return kthSmallest(A, k, pIndex + 1, end);
            }else{
                return A[pIndex];
            }
        }else{
            return A[end];
        }
    }

    public static int kthSmallestPartitionMethod(int[] A, int k){
        return kthSmallest(A,k,0,A.length-1);
    }

    public static int kthLargest(int[] A, int k, int start, int end){
        if(start<end){
            int pIndex = getRandomPartition(A,start,end);
            if(A.length-k<pIndex) {
                return kthLargest(A, k, start, pIndex - 1);
            }else if (A.length-k>pIndex) {
                return kthLargest(A, k, pIndex + 1, end);
            }else{
                return A[pIndex];
            }
        }else{
            return A[end];
        }
    }

    public static int kthLargestPartitionMethod(int[] A, int k){
        return kthLargest(A,k,0,A.length-1);
    }

    //O(klogk)
    public static int kthSmallestHeapMethod(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                if(o1>o2){
                    return -1;
                }else if(o1<o2){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(pq.peek()>arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.poll();
    }

    public static int kthLargestHeapMethod(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(pq.peek()<arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args){
        int[] arr = Utils.getRandomIntArray(10);

        System.out.println(Arrays.toString(arr));
        System.out.println(kthLargestPartitionMethod(arr,3));
        System.out.println(kthLargestHeapMethod(arr,3));
        System.out.println(kthSmallestHeapMethod(arr,5));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
