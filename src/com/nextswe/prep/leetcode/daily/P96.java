package com.nextswe.prep.leetcode.daily;

//https://www.youtube.com/watch?v=0s20L4-chDA
public class P96 {
    public int numTrees(int n) {
        if(n>1){
            int[] tdp = new int[n+1];
            tdp[0] = 1;
            tdp[1] = 1;
            for(int m=2;m<=n;m++){
                int res = 0;
                for(int i=1;i<=m;i++){
                    res += (tdp[i-1] * tdp[m-i]);
                }
                tdp[m] = res;
            }
            return tdp[n];
        }else{
            return 1;
        }
    }
}
