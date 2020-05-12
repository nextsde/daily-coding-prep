package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/lucky-numbers-in-a-matrix/
public class P1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int min_index = 0, min, max;
        for(int i=0;i<matrix.length;i++){
            min_index = 0;
            min = matrix[i][0];
            for(int j=0;j<matrix[i].length;j++){
                if(min>matrix[i][j]){
                    min = matrix[i][j];
                    min_index = j;
                }
            }
            max = min;
            for(int k=0;k<matrix.length;k++){
                if(matrix[k][min_index]>max){
                    max = matrix[k][min_index];
                    break;
                }
            }
            if(min==max){
                list.add(min);
            }
        }
        return list;
    }

    public static void main(String[] args){
        P1380 mP1380 = new P1380();
        Utils.printPlainList(mP1380.luckyNumbers(
                new int[][]{
                        {3,7,8},
                        {9,11,13},
                        {15,16,17}
                }
        ));

        Utils.printPlainList(mP1380.luckyNumbers(
                new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}}
        ));
    }

    // others solution
/*
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] mi = new int[m], mx = new int[n];
        Arrays.fill(mi, Integer.MAX_VALUE);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                mi[i] = Math.min(matrix[i][j], mi[i]);
                mx[j] = Math.max(matrix[i][j], mx[j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (mi[i] == mx[j])
                    res.add(mi[i]);
        return res;
    }
*/
}
