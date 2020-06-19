package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;
import java.util.Comparator;

public class P179 {
    //Accepted after lots wrong answer and stupid mistakes
/*
    public int getBigger(int num1, int num2){
        if(num1==num2){
            return num1;
        }
        int d1 = (int)Math.floor(Math.log10(num1))+1;
        int d2 = (int)Math.floor(Math.log10(num2))+1;
        if(num1 == 0){
            d1 = 1;
        }
        if(num2 == 0){
            d2 = 1;
        }
        int td = d1 + d2;
        double val1 = (num1 * Math.pow(10,td-d1)) + num2;
        double val2 = (num2 * Math.pow(10,td-d2)) + num1;
        if(val1>val2){
            return num1;
        }else{
            return num2;
        }
    }
    private int getPivot(int[] nums, int start, int end){
        int pv = nums[end];
        int pi = start;
        for(int i=start;i<end;i++){
            if(getBigger(nums[i],pv)==pv){
                int tmp = nums[pi];
                nums[pi] = nums[i];
                nums[i] = tmp;
                pi++;
            }
        }

        int tmp = nums[end];
        nums[end] = nums[pi];
        nums[pi] = tmp;

        return pi;
    }
    private void quick_sort(int[] nums, int start, int end){
        if(start<end){
            int pIndex = getPivot(nums,start,end);
            quick_sort(nums,start,pIndex-1);
            quick_sort(nums,pIndex+1,end);
        }
    }

    private void quick_sort(int[] nums){
        quick_sort(nums,0,nums.length-1);
    }

    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if(nums.length>0){
            boolean allZero = true;
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]!=0){
                    allZero = false;
                    break;
                }
            }
            if(allZero){
                sb.append('0');
            }else{
                quick_sort(nums);
                for(int i=nums.length-1;i>=0;i--){
                    sb.append(nums[i]+" ");
                }
            }
        }
        return sb.toString();
    }
*/

    private static class LargerNumberComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer num1, Integer num2) {
            int d1 = (int)Math.floor(Math.log10(num1))+1;
            int d2 = (int)Math.floor(Math.log10(num2))+1;
            if(num1 == 0){
                d1 = 1;
            }
            if(num2 == 0){
                d2 = 1;
            }
            int td = d1 + d2;
            double val1 = (num1 * Math.pow(10,td-d1)) + num2;
            double val2 = (num2 * Math.pow(10,td-d2)) + num1;
            return Double.compare(val1, val2);
        }
    }
    //easier and quicker by others
    //this one done using lexicographical string sorting
    public String largestNumber(int[] nums) {
        Integer[] s_num = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            s_num[i] = nums[i];
        }
        Arrays.sort(s_num, new LargerNumberComparator());
        StringBuilder sb = new StringBuilder();
        for(int i=s_num.length-1;i>=0;i--) {
            sb.append(s_num[i]);
        }
        String result = sb.toString();
        if (result.charAt(0) == '0') {
            return "0";
        }
        return result;
    }

    public static void main(String[] args){
        P179 mP179 = new P179();
        System.out.println(mP179.largestNumber(new int[]{1,2,3,4,5,6,7,8,9,0}));
        System.out.println(mP179.largestNumber(new int[]{999999998,999999997,999999999}));
        System.out.println(mP179.largestNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247}));
        System.out.println(mP179.largestNumber(new int[]{43,432}));
        System.out.println(mP179.largestNumber(new int[]{1,2,3,3,10,20,30,11,22,33,112,221,332,43,43,1212,121212,232,3232,2321,213,123,432,6,111,5}));
        System.out.println(mP179.largestNumber(new int[]{3,30,34,5,9}));
    }
}
