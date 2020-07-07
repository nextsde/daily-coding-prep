package com.nextswe.prep.aditya_verma.dp;

public class KnapSack_01 {
    // for any problem if we see have some choices and in each step we have to decide something,
    // based on these criteria we can tell this is a recursive problem
    // and after that if the problem asks us to find some optimal value based on those choices
    // then we know we will have to explore all the options
    // in those cases we can tell this might require dp/memoization on top of our recursive solution
    // because in these types of problem at some point there might be cases where we are doing
    // same task over and over again

    private static int knapsack_recursive(int[] wt, int[] val, int W, int n){
        //base condition
        if(W==0||n==0){return 0;}
        //choice diagram
        if(wt[n-1]<=W){
            return Math.max(val[n-1]+knapsack_recursive(wt,val,W-wt[n-1],n-1),knapsack_recursive(wt,val,W,n-1));
        }else{
            return knapsack_recursive(wt,val,W,n-1);
        }
    }

    private static int knapsack_memo(int[] wt, int[] val, int W, int n, int[][] memo){
        if(W==0||n==0){return 0;}
        if(memo[n][W]!=-1){
            return memo[n][W];
        }
        if(wt[n-1]<=W){
            return memo[n][W] = Math.max(val[n-1]+knapsack_memo(wt,val,W-wt[n-1],n-1,memo),knapsack_memo(wt,val,W,n-1,memo));
        }else{
            return memo[n][W] = knapsack_memo(wt,val,W,n-1,memo);
        }
    }

    private static int knapsack_dp(int[] wt, int[] val, int W, int n){
        int[][] memo = new int[n+1][W+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0||j==0){
                    memo[i][j] = 0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1]<=j){
                    memo[i][j] = Math.max(val[i-1]+memo[i-1][j-wt[i-1]],memo[i-1][j]);
                }else{
                    memo[i][j] = memo[i-1][j];
                }
            }
        }
        return memo[n][W];
    }
    public static void main(String[] args){
        int[] wt = {1,2,3,5};
        int[] val = {1,3,5,7};
        int c = 7;
        System.out.println(knapsack_recursive(wt,val,c,wt.length));

    }
}
