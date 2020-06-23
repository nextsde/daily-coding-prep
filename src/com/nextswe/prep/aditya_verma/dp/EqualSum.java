package com.nextswe.prep.aditya_verma.dp;

public class EqualSum {
    public static boolean isEqualSum(int[] arr){
        int sum = 0;
        for(int a:arr){
            sum+=a;
        }
        if(sum%2!=0){
            return false;
        }
        return SubsetSum.isSubSetSum(arr,sum/2);
    }
    public static void main(String[] args){
        System.out.println(isEqualSum(new int[]{5,1,6,11}));
    }
}
