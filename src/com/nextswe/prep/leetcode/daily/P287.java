package com.nextswe.prep.leetcode.daily;

import java.util.HashSet;
import java.util.Set;

public class P287 {
    //accepted but uses O(n) space

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return 0;
    }




    public static void main(String[] args){
        P287 p22 = new P287();
        System.out.println(p22.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(p22.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(p22.findDuplicate(new int[]{2,2,2,2,2}));
    }
}
