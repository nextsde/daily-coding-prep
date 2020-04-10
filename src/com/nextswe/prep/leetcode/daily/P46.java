package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P46 {
    //Accepted
    public void permute(int[] nums, int start, int end, List<List<Integer>> result){
        if(start==end){
            result.add(Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toList()));
        }else{
            for(int i=start;i<=end;i++){
                int tmp = nums[start];
                nums[start] = nums[i];
                nums[i] = tmp;

                permute(nums,start+1,end,result);

                nums[i] = nums[start];
                nums[start] = tmp;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length>0) {
            permute(nums, 0, nums.length - 1, result);
        }else{
            result.add(new ArrayList<Integer>());
        }
        return result;
    }

    public static void main(String[] args){
        P46 p46 = new P46();
        p46.permute(new int[]{});
    }
}
