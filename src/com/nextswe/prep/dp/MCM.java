package com.nextswe.prep.dp;

//Matrix chain multiplication
public class MCM {
    public static void main(String[] args){
        int n = 5;
        int[] p = {5,4,6,2,7};
        int[][] m  = new int[5][5];
        int[][] s = new int[5][5];
        int j, min, q;
        for(int d=1;d<n-1;d++){
            for(int i=1; i<n-d; i++){
                j = i+d;
                min = Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    q = m[i][k]+m[k+1][j]+ (p[i-1]*p[k]*p[j]);
                    if (q < min) {
                        min = q;
                        s[i][j] = k;
                    }
                }
                m[i][j] = min;
            }
        }
        System.out.println(m[1][n-1]);
    }
}
