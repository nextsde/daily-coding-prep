package com.nextswe.prep.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

public class P1387 {
    Map<Integer,Integer> memoMap = new HashMap<>();
    public int calculatePower(int val){
        if(val==1){
            return 0;
        }
        if(memoMap.containsKey(val)){
            return memoMap.get(val);
        }
        int v;
        if(val%2==0){
            v = calculatePower(val/2);
        }else{
            v = calculatePower(3*val +1);
        }
        memoMap.put(val, v+1);
        return memoMap.get(val);
    }

    public int getKth(int lo, int hi, int k) {
        int[][] items = new int[hi-lo+1][2];
        int j = 0;
        for(int i=lo;i<=hi;i++){
            items[j][0] = i;
            items[j][1] = calculatePower(i);
            j++;
        }
        merge_sort(items);
        return items[k-1][1];
    }

    public void merge_sort(int[][] A){
        int n = A.length;
        if(n<2){
            return;
        }
        int mid = n/2;
        int[][] p1 = new int[mid][2];
        int[][] p2 = new int[n-mid][2];
        for(int i=0;i<mid;i++){
            p1[i] = A[i];
        }
        for(int j=mid;j<n;j++){
            p2[j-mid] = A[j];
        }
        merge_sort(p1);
        merge_sort(p2);
        merge(A,p1,p2);
    }

    public void merge(int[][] A, int[][] p1, int[][] p2){
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<p1.length && j<p2.length){
            if(p2[j][1]<p1[i][1]){
                A[k++] = p2[j++];
            }else{
                A[k++] = p1[i++];
            }
        }
        while(i<p1.length){
            A[k++] = p1[i++];
        }
        while(j<p2.length){
            A[k++] = p2[j++];
        }
    }


//    public void merge(Item[] A, Item[] p1, Item[] p2){
//        int i = 0;
//        int j = 0;
//        int k = 0;
//        while(i<p1.length && j<p2.length){
//            if(p2[j].power<p1[i].power){
//                A[k++] = p2[j++];
//            }else{
//                A[k++] = p1[i++];
//            }
//        }
//        while(i<p1.length){
//            A[k++] = p1[i++];
//        }
//        while(j<p2.length){
//            A[k++] = p2[j++];
//        }
//    }
//
//    public void merge_sort(Item[] A){
//        int n = A.length;
//        if(n<2){
//            return;
//        }
//        int mid = n/2;
//        Item[] p1 = new Item[mid];
//        Item[] p2 = new Item[n-mid];
//        for(int i=0;i<mid;i++){
//            p1[i] = A[i];
//        }
//        for(int j=mid;j<n;j++){
//            p2[j-mid] = A[j];
//        }
//        merge_sort(p1);
//        merge_sort(p2);
//        merge(A,p1,p2);
//    }
//    Map<Integer,Integer> memoMap = new HashMap<>();
//    public int calculatePower(int val){
//        if(val==1){
//            return 0;
//        }
//        if(memoMap.containsKey(val)){
//            return memoMap.get(val);
//        }
//        int v;
//        if(val%2==0){
//            v = calculatePower(val/2);
//        }else{
//            v = calculatePower(3*val +1);
//        }
//        memoMap.put(val, v+1);
//        return memoMap.get(val);
//    }
//    public Item getPower(int val){
//        int p = calculatePower(val);
//        return new Item(val,p);
//    }
//    public Item getPower(int val){
//        int p = calculatePower(val);
//        return new Item(val,p);
//    }

    public static void main(String[] args){
        P1387 mP1387 = new P1387();
        mP1387.getKth(12,15,2);
    }
}
