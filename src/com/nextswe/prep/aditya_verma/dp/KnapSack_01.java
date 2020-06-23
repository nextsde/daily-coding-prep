package com.nextswe.prep.aditya_verma.dp;

public class KnapSack_01 {
    private static int knapsack_recursive(int[] wt, int[] val, int c, int n){
        if(c==0||n==0){return 0;}
        if(wt[n-1]<=c){
            return Math.max(val[n-1]+knapsack_recursive(wt,val,c-wt[n-1],n-1),knapsack_recursive(wt,val,c,n-1));
        }else{
            return knapsack_recursive(wt,val,c,n-1);
        }
    }

    private static int knapsack_memo(int[] wt, int[] val, int c, int n, int[][] memo){
        if(c==0||n==0){return 0;}
        if(memo[n][c]!=-1){
            return memo[n][c];
        }
        if(wt[n-1]<=c){
            return memo[n][c] = Math.max(val[n-1]+knapsack_memo(wt,val,c-wt[n-1],n-1,memo),knapsack_memo(wt,val,c,n-1,memo));
        }else{
            return memo[n][c] = knapsack_recursive(wt,val,c,n-1);
        }
    }

    private static int knapsack_dp(int[] wt, int[] val, int c, int n){
        int[][] memo = new int[n+1][c+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<c+1;j++){
                if(i==0||j==0){
                    memo[i][j] = 0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<c+1;j++){
                if(wt[i-1]<=j){
                    memo[i][j] = Math.max(val[i-1]+memo[i-1][j-wt[i-1]],memo[i-1][j]);
                }else{
                    memo[i][j] = memo[i-1][j];
                }
            }
        }
        return memo[n][c];
    }
    public static void main(String[] args){
        int[] wt = {1,2,3,5};
        int[] val = {1,3,5,7};
        int c = 7;
        System.out.println(knapsack_dp(wt,val,c,wt.length));

    }
}
