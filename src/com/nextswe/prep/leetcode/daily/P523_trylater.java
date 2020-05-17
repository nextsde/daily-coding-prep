package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;

public class P523_trylater {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length==0){
            return false;
        }
        if(k<0){
            k *=-1;
        }
        int[] cSum = new int[nums.length];
        cSum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            cSum[i] = cSum[i-1]+nums[i];
        }
        int i = 0;
        int j = 1;
        while(j<cSum.length){
            if(j-i==1 && cSum[j]%k==0){return true;}
            else if((cSum[j]-cSum[i])%k==0){return true;}
            else if(cSum[j]<k){j++;}
            else{i++;}
        }
        return false;
    }

    public static void main(String[] args){
        P523_trylater mP523_trylater = new P523_trylater();
        System.out.println(mP523_trylater.checkSubarraySum(new int[]{23,7},6));
        System.out.println(mP523_trylater.checkSubarraySum(new int[]{23,2,6,4,7},0));
        System.out.println(mP523_trylater.checkSubarraySum(new int[]{23, 2, 4, 6, 7},6));
        System.out.println(mP523_trylater.checkSubarraySum(new int[]{23, 2, 6, 4, 7},6));
        System.out.println(mP523_trylater.checkSubarraySum(new int[]{1, 2, 3, 5, 7},8));
        System.out.println(mP523_trylater.checkSubarraySum(new int[]{1, 2, 3, 5, 7},9));
        System.out.println(mP523_trylater.checkSubarraySum(new int[]{0, 0},0));
    }
}
