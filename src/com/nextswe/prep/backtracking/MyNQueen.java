package com.nextswe.prep.backtracking;

import com.nextswe.prep.utils.Utils;

public class MyNQueen {

    private boolean solve(int n, int row,int[] placement){
        if(row==n){
            return true;
        }
        for(int col=0;col<n;col++){
            placement[row] = col;
            if(isValid(placement,row)){
                if(solve(n,row+1,placement)) {
                    return true;
                }
            }
            placement[row] = -1;
        }

        return false;
    }

    private boolean isValid(int[] placement, int row){
        for(int q=0;q<row;q++){
            int diff = Math.abs(placement[q]-placement[row]);
            if(diff==0 || diff == row - q){
                return false;
            }
        }
        return true;
    }

    public void solveNQueen(int n){
        int[][] board= new int[n][n];
        int[] placement = {-1,-1,-1,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = 0;
            }
        }

        solve(n,0,placement);

//        for(int j=0;j<placement.length;j++){
//            System.out.print(placement[j]+" ");
//        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args){
        MyNQueen myNQueen = new MyNQueen();
        myNQueen.solveNQueen(4);
    }
}
