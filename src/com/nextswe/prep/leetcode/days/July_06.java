package com.nextswe.prep.leetcode.days;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class July_06 {
    //https://leetcode.com/problems/first-missing-positive/
    public static int firstMissingPositive(int[] nums) {
        //optimal O(n) time, O(1) space
        boolean oneFound = false;
        for(int a:nums){
            if(a==1){
                oneFound = true;
                break;
            }
        }

        if(oneFound){
            int n = nums.length;
            for(int i=0;i<n;i++){
                if(nums[i]<=0 || nums[i]>n){
                    nums[i] = 1;
                }
            }

            for(int i=0;i<n;i++){
                int index = Math.abs(nums[i])-1;
                nums[index] = -Math.abs(nums[index]);
            }

            for(int i=0;i<n;i++){
                if(nums[i]>0){
                    return i+1;
                }
            }

            return nums.length+1;
        }else{
            return 1;
        }
        /*
        //brute force O(n) time, O(n) space
        Set<Integer> set = new HashSet<>();
        for(int a:nums){
            set.add(a);
        }
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return nums.length+1;
        */
    }


    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res =  new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] = -nums[index];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(!(nums[i]<0)){
                res.add(i+1);
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,0}));
    }
}
