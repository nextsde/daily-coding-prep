package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.utils.Utils;

public class P540 {
    //binary search approach
    //accepted O(logn)
    public int singleNonDuplicate(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int m;
        while(l<r){
            m = (l+r)/2;
            //m is odd for even position
            //m is even for odd position
            if(m%2==1){
                if(nums[m] == nums[m-1]){
                    l = m+1;
                }else{
                    r = m-1;
                }
            }else{
                if(nums[m] != nums[m-1]){
                    l = m;
                }else{
                    r = m;
                }
            }
        }
        return nums[l];
    }

//    //quick solution
//    //accepted O(n)
//    public int singleNonDuplicate(int[] nums) {
//        if(nums==null || nums.length==0){
//            return 0;
//        }
//        int sum = 0;
//        int count = 0;
//        while(count!=nums.length){
//            if(count%2==0){
//                sum+=nums[count];
//            }else{
//                sum-=nums[count];
//            }
//            count++;
//        }
//        return Math.abs(sum);
//    }

    public static void main(String[] args){
        P540 p540 = new P540();
        Utils.println(p540.singleNonDuplicate(new int[]{1,1,2,3,3}));
        Utils.println(p540.singleNonDuplicate(new int[]{1,1,2,2,3}));
        Utils.println(p540.singleNonDuplicate(new int[]{2,3,3,4,4}));
        Utils.println(p540.singleNonDuplicate(new int[]{2,2,3,3,4}));
        Utils.println(p540.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
        Utils.println(p540.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        Utils.println(p540.singleNonDuplicate(new int[]{1,1,2}));
    }
}
