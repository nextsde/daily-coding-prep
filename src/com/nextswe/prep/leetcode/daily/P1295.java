package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.utils.Utils;

public class P1295 {
    //https://brilliant.org/wiki/finding-digits-of-a-number/
    //accepted for any numbers
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if((((int)Math.floor(Math.log10(nums[i]))+1)%2)==0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        P1295 p1295 = new P1295();
        Utils.println(p1295.findNumbers(new int[]{12,345,2,6,7896}));
        Utils.println(p1295.findNumbers(new int[]{555,901,482,1771}));
    }
}
