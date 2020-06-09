package com.nextswe.prep.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

public class P532_trylater {
    public int findPairs(int[] A, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = A.length;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(map.getOrDefault(A[i],Integer.MIN_VALUE)!=A[j] && Math.abs(A[i]-A[j])==k){
                    map.put(A[i],A[j]);
                    map.put(A[j],A[i]);
                    count++;
                }
            }
        }

        // int count = 0;
        // Arrays.sort(A);
        // int n = A.length;
        // for(int i=0;i<n;i++){
        //     int otherside = A[i]-k;
        //     if(Arrays.binarySearch(A,otherside)>=0){
        //         count++;
        //     }
        // }
        return count;
        // Set<Integer> set = new HashSet<>();
        // for(int a:nums){
        //     set.add(a)
        // }
        // for(int a:nums){
        //     int
        //     set.add(a)
        // }
    }
    public static void main(String[] args){
        P532_trylater mP532_trylater = new P532_trylater();
        System.out.println(mP532_trylater.findPairs(new int[]{1,3,1,5,4},
        0));
        System.out.println(mP532_trylater.findPairs(new int[]{3,1,4,1,5}
        ,2));
        System.out.println(mP532_trylater.findPairs(new int[]{0,0,0}
        ,0));
        System.out.println(mP532_trylater.findPairs(new int[]{-1,0,0,1,0,0,-1},
        1));
    }
}
