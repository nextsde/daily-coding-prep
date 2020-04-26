package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;

public class P1252 {
    //others solution
    //https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/discuss/425100/JavaPython-3-2-methods%3A-time-O(m-*-n-%2B-L)-and-O(L)-codes-w-comment-and-analysis.
    public int oddCells(int n, int m, int[][] indices) {
        boolean[] oddRows = new boolean[n];
        boolean[] oddCols = new boolean[m];
        int oddCount = 0;
        for(int[] idx: indices){
            oddRows[idx[0]] ^= true;
            oddCols[idx[1]] ^= true;
            System.out.println(Arrays.toString(oddRows));
            System.out.println(Arrays.toString(oddCols));
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                oddCount += oddRows[i] ^ oddCols[j]?1:0;
            }
        }
        return oddCount;
    }

    //Accepted: worst running time
/*
    public int oddCells(int n, int m, int[][] indices) {
        int oddCount = 0;
        int[][] matrix = new int[n][m];
        for(int i=0;i<indices.length;i++){
            int row = indices[i][0];
            for(int j=0;j<m;j++){
                matrix[row][j] += 1;
                if(matrix[row][j]%2==1) {
                    oddCount+=1;
                }else if(matrix[row][j]>0 && matrix[row][j]%2==0){
                    oddCount-=1;
                }
            }
            int col = indices[i][1];
            for(int j=0;j<n;j++){
                matrix[j][col] += 1;
                if(matrix[j][col]%2==1) {
                    oddCount+=1;
                }else if(matrix[j][col]>0 && matrix[j][col]%2==0){
                    oddCount-=1;
                }
            }
        }
        return oddCount;
    }
*/

    public static void main(String[] args){
        P1252 mP1252 = new P1252();
        System.out.println(mP1252.oddCells(2,3,
                new int[][]{
                        {0,1},
                        {1,0}
        }));

//        System.out.println(mP1252.oddCells(2,2,
//                new int[][]{
//                        {0,1},
//                        {1,1}
//                }));
//        System.out.println(mP1252.oddCells(2,2,
//                new int[][]{
//                        {1,1},
//                        {0,0}
//                }));
    }
}
