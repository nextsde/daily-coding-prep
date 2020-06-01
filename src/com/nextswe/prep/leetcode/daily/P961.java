package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P961 {
    public int repeatedNTimes(int[] A) {
        if(A.length>3){
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<A.length;i++){
                if(set.contains(A[i])){
                    return A[i];
                }else{
                    set.add(A[i]);
                }
            }
        }
        return 0;
    }

    /*
    public int repeatedNTimes(int[] A) {
        if(A.length>3){
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<A.length;i++){
                map.put(A[i],map.getOrDefault(A[i],0)+1);
            }
            for(int i=0;i<A.length;i++){
                if(map.get(A[i])==A.length/2){
                    return A[i];
                }
            }
        }
        return 0;
    }
    */

/*
    public int repeatedNTimes(int[] A) {
        if(A.length>3){
            Arrays.sort(A);
            int i = 0, j = A.length-1;
            while(A[i]!=A[i+1]){
                i++;
            }
            while(A[j]!=A[j-1]){
                j--;
            }
            if(A[i]==A[j]){
                return A[i];
            }
        }
        return 0;
    }
*/
}
