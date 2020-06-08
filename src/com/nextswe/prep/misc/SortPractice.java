package com.nextswe.prep.misc;

import com.nextswe.prep.utils.Utils;

import java.util.Arrays;

public class SortPractice {

    public static void my_sort(int[] nums){

    }

    public static void main(String[] args){
        int[] nums = Utils.getRandomIntArray(20);
        System.out.println(Arrays.toString(nums));
        my_sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
