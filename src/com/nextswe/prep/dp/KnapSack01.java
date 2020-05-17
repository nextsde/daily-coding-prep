package com.nextswe.prep.dp;

public class KnapSack01 {
    public static int knapSackRecursive(int itemsNumber, int capacity, int[] weights, int[] values) {
        int finalResult;
        if(itemsNumber == 0 || capacity == 0) {
            finalResult = 0;
        } else if(weights[itemsNumber] > capacity) {
            finalResult = knapSackRecursive(itemsNumber - 1, capacity, weights, values);
        } else {
            int dontPutInKnapsack = knapSackRecursive(itemsNumber - 1, capacity, weights, values);
            int putInSack = values[itemsNumber] + knapSackRecursive(itemsNumber - 1, capacity - weights[itemsNumber], weights, values);
            finalResult = Math.max(dontPutInKnapsack, putInSack);
        }
        return finalResult;
    }

    public static int knapSackRecursiveMemo(int dp[][], int itemsNumber, int capacity, int[] weights, int[] values) {
        if(dp[itemsNumber][capacity]!=0) return dp[itemsNumber][capacity];
        int finalResult;
        if(itemsNumber == 0 || capacity == 0) {
            finalResult = 0;
        } else if(weights[itemsNumber] > capacity) {
            finalResult = knapSackRecursiveMemo(dp,itemsNumber - 1, capacity, weights, values);
        } else {
            int dontPutInKnapsack = knapSackRecursiveMemo(dp,itemsNumber - 1, capacity, weights, values);
            int putInSack = values[itemsNumber] + knapSackRecursiveMemo(dp,itemsNumber - 1, capacity - weights[itemsNumber], weights, values);
            finalResult = Math.max(dontPutInKnapsack, putInSack);
        }
        dp[itemsNumber][capacity] = finalResult;
        return finalResult;
    }

    //https://www.youtube.com/watch?v=8LusJS5-AGo
    public static int[][] knapSackDP(int items, int capacity, int[] weights, int[] values) {
        int[][] dp = new int[items+1][capacity+1];
        for(int i=1;i<=items;i++){
            for(int j=1;j<=capacity;j++){
                if(weights[i]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(values[i] + dp[i-1][j-weights[i]], dp[i-1][j]);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args){
        int[] w = new int[]{0,1,2,4,2,5};
        int[] v = new int[]{0,5,3,5,3,2};
        int items = 5;
        int capacity = 5;

//        int[] w = new int[]{0,1,3,4,7};
//        int[] v = new int[]{0,1,4,5,7};
//        int items = 4;
//        int capacity = 7;

        System.out.println(knapSackRecursive(items,capacity,w,v));
        int[][] dp = new int[items+1][capacity+1];
        System.out.println(knapSackRecursiveMemo(dp,items,capacity,w,v));
        int[][] ksTable = knapSackDP(items,capacity,w,v);
        int i = items;
        int j = capacity;
        while(j>0){
            if(ksTable[i][j] == ksTable[i-1][j]){
                i--;
            }else{
                System.out.println(w[i]+"("+v[i]+")");
                j = j - w[i];
                i--;
            }
        }
    }
}
