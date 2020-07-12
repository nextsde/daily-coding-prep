package com.nextswe.prep.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

public class Weekly_Contest_197 {
    public int numIdenticalPairs(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int[] num_count = new int[101];
        for(int a:nums){
            num_count[a]++;
        }

        int count = 0;
        for(int i=1;i<num_count.length;i++){
            int val = num_count[i];
            if(val>1){
                count += (val*(val-1)/2);
            }
        }
        return count;
    }

    //needed hint, will do better next time
    static int M = 1000000007;
    public int numSub(String s) {
        int i = 0;
        int count = 0;
        int res = 0;
        while(i<s.length()){
            if(s.charAt(i)=='1'){
                count++;
            }else{
                count = 0;
            }
            res = (res+count) % M;
            i++;
        }
        return res;
    }

    public static void main(String[] args){
        Weekly_Contest_197 mWeekly_Contest_197 = new Weekly_Contest_197();
//        System.out.println(mWeekly_Contest_197.numIdenticalPairs(new int[]{1,2,3,1,1,3}));
//        System.out.println(mWeekly_Contest_197.numIdenticalPairs(new int[]{1,1,1,1}));
//        System.out.println(mWeekly_Contest_197.numIdenticalPairs(new int[]{1,2,3}));
        System.out.println(mWeekly_Contest_197.numSub("0110111"));
        System.out.println(mWeekly_Contest_197.numSub("101"));
        System.out.println(mWeekly_Contest_197.numSub("111111"));
        System.out.println(mWeekly_Contest_197.numSub("000"));
    }
}
