package com.nextswe.prep.aditya_verma.dp;

import java.util.Arrays;

public class SubsetSum {
    public static boolean isSubSetSum(int[] arr, int sum){
        boolean[][] memo = new boolean[arr.length+1][sum+1];
        Arrays.fill(memo[0], false);
        for(int i=0;i<memo.length;i++){
            memo[i][0] = true;
        }
        for(int i=1;i<memo.length;i++){
            for(int j=1;j<memo[i].length;j++){
                if(arr[i-1]<=j){
                    memo[i][j] = memo[i-1][j-arr[i-1]]||memo[i-1][j];
                }else{
                    memo[i][j] = memo[i-1][j];
                }
            }
        }
        return memo[arr.length][sum];
    }
    public static void main(String[] args){
        System.out.println(isSubSetSum(new int[]{5,1,7,12},11));
    }
}
