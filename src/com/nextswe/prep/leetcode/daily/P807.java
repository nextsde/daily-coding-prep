package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;

public class P807 {
    //accepted
/*
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int runningSum = 0;
        int[] n = new int[grid.length];
        int[] m = new int[grid[0].length];
        Arrays.fill(n,Integer.MIN_VALUE);
        Arrays.fill(m,Integer.MIN_VALUE);
        for(int i=0;i<n.length;i++){
            for(int j=0;j<m.length;j++){
                if(n[i]<grid[i][j]){
                    n[i] = grid[i][j];
                }
                if(m[j]<grid[i][j]){
                    m[j] = grid[i][j];
                }
            }
        }

        for(int i=0;i<n.length;i++){
            for(int j=0;j<m.length;j++){
                if(grid[i][j]<Math.min(n[i],m[j])){
                    runningSum += Math.min(n[i],m[j]) - grid[i][j];
                    grid[i][j] = Math.min(n[i],m[j]);
                }
            }
        }
//        System.out.println(Arrays.deepToString(grid));
//
//        System.out.println(Arrays.toString(n));
//        System.out.println(Arrays.toString(m));
        return runningSum;
    }
*/

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int runningSum = 0;
        int[] n = new int[grid.length];
        int[] m = new int[grid[0].length];
        for(int i=0;i<n.length;i++){
            for(int j=0;j<m.length;j++){
                n[i] = Math.max(n[i],grid[i][j]);
                m[j] = Math.max(m[j],grid[i][j]);
            }
        }

        for(int i=0;i<n.length;i++){
            for(int j=0;j<m.length;j++){
                runningSum += Math.min(n[i],m[j]) - grid[i][j];
            }
        }
        return runningSum;
    }

    public static void main(String[] args){
        P807 p8 = new P807();
        System.out.println(p8.maxIncreaseKeepingSkyline(new int[][]
                {
                        {3,0,8,4},
                        {2,4,5,7},
                        {9,2,6,3},
                        {0,3,1,0}
                }));
    }
}
