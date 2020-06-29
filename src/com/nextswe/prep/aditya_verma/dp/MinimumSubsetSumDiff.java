package com.nextswe.prep.aditya_verma.dp;

import java.util.ArrayList;
import java.util.List;

public class MinimumSubsetSumDiff {
    public static int minSubsetSumDiff(int[] arr){
        int sum=0;
        for(int a:arr){
            sum+=a;
        }
        boolean[][] memo = new boolean[arr.length+1][sum+1];
        for(int j=0;j<memo[0].length;j++){
            memo[0][j] = false;
        }
        for(int i=0;i<memo.length;i++){
            memo[i][0] = true;
        }

        for(int i=1;i<memo.length;i++){
            for(int j=1;j<memo[i].length;j++){
                if(arr[i-1]<=j){
                    memo[i][j] = memo[i-1][j-arr[i-1]] || memo[i-1][j];
                }else{
                    memo[i][j] = memo[i-1][j];
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int j=0;j<sum/2;j++){
            if(memo[arr.length][j]){
                list.add(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int a: list){
            min = Math.min(min, sum-2*a);
        }
        return min;
    }

    public static void main(String[] args){
        System.out.println(minSubsetSumDiff(new int[]{1,2,7}));
        System.out.println(minSubsetSumDiff(new int[]{1,2,7}));
    }
}
