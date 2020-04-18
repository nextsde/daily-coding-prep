package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.utils.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1365 {
/*
    //my solution : Accepted... need to be better
    //came up with this one quickly
    //O(nlogn)+O(n)+O(n) = O(nlogn) time and O(4n) = O(n) space complexity
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer,Integer> map = new HashMap();

        int[] sortedNums = new int[nums.length];
        int[] output = new int[nums.length];
        int[] finalOutput = new int[nums.length];

        for (int i=0; i<nums.length; i++) {
            sortedNums[i] = nums[i];
        }

        Arrays.sort(sortedNums);

        int prev = 0;
        int same = 0;
        output[0] = prev;
        map.put(sortedNums[0],0);
        for (int i=1; i<sortedNums.length; i++) {
            if(sortedNums[i-1]==sortedNums[i]){
                same++;
                output[i] = output[i-1];
            }else{
                prev++;
                output[i] = prev+same;
            }
            map.put(sortedNums[i],output[i]);
        }

        for (int i=0; i<nums.length; i++) {
            finalOutput[i] = map.get(nums[i]);
        }
        return finalOutput;
    }*/

    //optimal solution by others
    //https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/discuss/524996/JAVA-beats-100-O(n)
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101];
        for (int a : nums)
            cnt[a]++;

        for (int i = 1; i <= 100; i++)
            cnt[i] += cnt[i - 1];

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                res[i] = cnt[nums[i] - 1];
        }

        return res;
    }

    public static void main(String[] args){
        P1365 p13 = new P1365();
        Utils.printArray(p13.smallerNumbersThanCurrent(new int[]{8,0,2,2,3,3,4,5,1,2}));
    }
}
