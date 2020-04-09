package com.nextswe.prep.leetcode.april30;

import com.nextswe.prep.utils.Utils;

public class Apr4_P283 {
    //was able to solve it quickly :D
    //kudos to me
    //time complexity: O(n)
    //space complexity: O(1)
    public void moveZeroes(int[] nums) {
        int zeroPos = -1;
        int zeroCounter = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=0 && zeroPos!=-1){
                swap(nums,i,zeroPos);
                zeroPos = i - (zeroCounter - 1);
            }else if(nums[i]==0){
                if(zeroPos==-1){
                    zeroPos = i;
                    zeroCounter = 1;
                }else{
                    zeroCounter++;
                }
            }
        }
    }



    public void swap(int[] nums,int p1, int p2){
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }

    public static void main(String[] args) {
        Apr4_P283 apr4283 = new Apr4_P283();
        int[] nums = new int[]{-1, 0, -1, 0};
        apr4283.moveZeroes(nums);
        Utils.printArray(nums);
    }
}
