package com.nextswe.prep.leetcode.april30;

import java.util.HashMap;
import java.util.Map;

public class Apr1_P136 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.replace(nums[i],map.get(nums[i])+1);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])==1){
                return nums[i];
            }
        }
        return 0;
    }
}
