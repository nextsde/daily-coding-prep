package com.nextswe.prep.leetcode.daily;

public class P1351 {
    //my solution - O(n^2)
    public int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length;
        if(m>0) {
            int n = grid[0].length;
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (grid[i][j] >= 0) {
                        break;
                    } else {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    //others solution (solution by https://leetcode.com/rock/)
    /*
    O(m + n)
    This solution uses the fact that the negative regions of the matrix
    will form a "staircase" shape, e.g.:

    ++++++
    ++++--
    ++++--
    +++---
    +-----
    +-----

    What this solution then does is to "trace" the outline of the staircase.
    /*
    /*
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length, r = m - 1, c = 0, cnt = 0;
        while (r >= 0 && c < n) {
            if (grid[r][c] < 0) {
                --r;
                cnt += n - c; // there are n - c negative numbers in current row.
            }else {
                ++c;
            }
        }
        return cnt;
    }
    */

    public static void main(String[] args){
        P1351 mP1351 = new P1351();
        System.out.println(mP1351.countNegatives(
                new int[][]{
                        {4,3,2,-1},
                        {3,2,1,-1},
                        {1,1,-1,-2},
                        {-1,-1,-2,-3}
                }
        ));

        System.out.println(mP1351.countNegatives(
                new int[][]{
                        {-1}
                }
        ));

        System.out.println(mP1351.countNegatives(
                new int[][]
                        {{1,-1},{-1,-1}}
        ));

        System.out.println(mP1351.countNegatives(
                new int[][]
                        {{3,2},{1,0}}
        ));
    }
}
