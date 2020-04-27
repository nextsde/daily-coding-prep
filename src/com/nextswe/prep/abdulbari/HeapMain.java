package com.nextswe.prep.abdulbari;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HeapMain {
    static void swap(Integer[] x, int a, int b) {
        Integer t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    static int left(int i) {
        return 2*i + 1;
    }
    static int right(int i) {
        return 2*i + 2;
    }
    static int parent(int i) {
        return (i-1)/2;
    }

    public static void buildHeap(Integer[] A, int current_index){
        int parent = parent(current_index);
        if(current_index==0 || A[current_index]<=A[parent]){
            return;
        }else{
            swap(A, parent, current_index);
            buildHeap(A,parent);
        }
    }

    public static void siftDown(Integer[] A, int current_index, int len){
        int leftChild = left(current_index);
        int rightChild = right(current_index);
        if(leftChild<=len && A[leftChild]>A[current_index] && ( len<rightChild || A[leftChild]>A[rightChild])){
            swap(A,current_index,leftChild);
            siftDown(A,leftChild,len);
        }else if(rightChild<=len && A[rightChild]>A[leftChild] && A[rightChild]>A[current_index]){
            swap(A,current_index,rightChild);
            siftDown(A,rightChild,len);
        }
    }

    public static Integer deleteHeap(Integer[] A, int len){
        swap(A,0,len);
        siftDown(A,0,len-1);
        return A[len];
    }

    public static void main(String[] args){
        Integer[] arr = {1,2,3,4,5,6,7,8,9};
        List<Integer> list = Arrays.asList(arr);
        Collections.shuffle(list);
        System.out.println(Arrays.toString(arr));

//        for(int i=0;i<arr.length;i++){
//            buildHeap(arr,i);
//        }
        //heapify
        for(int i=arr.length-1;i>=0;i--){
            siftDown(arr,i,arr.length-1);
        }

//        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));
//        for(int i=arr.length-1;i>=0;i--){
//            System.out.println(deleteHeap(arr,i));
//        }
//        System.out.println(Arrays.toString(arr));
    }
}
