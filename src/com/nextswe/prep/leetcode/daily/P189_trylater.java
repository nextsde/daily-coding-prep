package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;
// TODO
// not accepted, try later
public class P189_trylater {

//      time limit exceeded
//    public void rotate(int[] nums, int k) {
//        if(nums.length>0) {
//            int n = nums.length;
//            for (int i = 0; i < k; i++) {
//                int tmp = nums[0];
//                for (int j = 0; j < n; j++) {
//                    int tmp2 = nums[(j + 1) % n];
//                    nums[(j + 1) % n] = tmp;
//                    tmp = tmp2;
//                }
//            }
//        }
//    }

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k==0){
            return;
        }
        System.out.println(Arrays.toString(nums));
        int n = nums.length;
//        int current_index = 0;
//        int current_val = nums[current_index];
//        int next_index = (current_index+k)%n;
//
//        int next_val = nums[next_index];
//        nums[next_index] = current_val;
//        current_val = next_val;
//        current_index = next_index;
//        next_index = (next_index+k)%n;

//        System.out.println(Arrays.toString(nums));
////        System.out.println("current_index "+current_index);
//        System.out.println("current_val "+current_val);
//        System.out.println("next_index "+next_index);

        int next_index = 0;
        int current_val = nums[next_index];
        int item_rotated = 0;
        while(item_rotated!=n){
            next_index = (next_index+k)%n;
//            if(next_index == 0){
//                next_index++;
//            }
            System.out.println("next_index "+next_index);
            item_rotated++;
        }

//        System.out.println("next_val "+next_val);
//        int j = 0;
//        int jj = 0;
//        int tmp = nums[0];
//        for (int i = 0; i < n; i++) {
//            j=j+k+jj;
//            System.out.println(j%n);
//            int tmp2 = nums[j%n];
//            nums[j%n] = tmp;
//            tmp = tmp2;
//            if(j%n==0){
//                tmp = nums[jj];
//                jj++;
//                j = k+jj;
//            }
//        }
    }

    public static void main(String[] args){
        P189_trylater pP189 = new P189_trylater();
        int nums[] = {1,2,3,4,5,6,7};
//        pP189.rotate(nums,3);
//        System.out.println(Arrays.toString(nums));
//
//        nums = new int[]{-1, -100, 3, 99};
//        pP189.rotate(nums,2);
//        System.out.println(Arrays.toString(nums));

        nums = new int[]{1,2,3,4,5,6};
        pP189.rotate(nums,3);
//        System.out.println(Arrays.toString(nums));

    }
}
