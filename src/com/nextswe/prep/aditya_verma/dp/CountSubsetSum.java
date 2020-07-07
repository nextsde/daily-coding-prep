package com.nextswe.prep.aditya_verma.dp;

import java.util.Arrays;

public class CountSubsetSum {
    public static int countSubSetSum(int[] arr, int sum){
        int[][] memo = new int[arr.length+1][sum+1];
        Arrays.fill(memo[0], 0);
        for(int i=0;i<memo.length;i++){
            memo[i][0] = 1;
        }
        for(int i=1;i<memo.length;i++){
            for(int j=1;j<memo[i].length;j++){
                if(arr[i-1]<=j){
                    memo[i][j] = memo[i-1][j-arr[i-1]]+memo[i-1][j];
                }else{
                    memo[i][j] = memo[i-1][j];
                }
            }
        }
        return memo[arr.length][sum];
    }

    public static void main(String[] args){
        System.out.println(countSubSetSum(new int[]{2,3,5,6,8,10},10));
    }
}
