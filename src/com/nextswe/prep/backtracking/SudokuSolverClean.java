package com.nextswe.prep.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=JzONv5kaPJM
public class SudokuSolverClean {

    private boolean solve_sudoku(int[][] sudoku, int row, int col){
        if (col == sudoku[row].length) {
            col = 0;
            row++;
        }
        if (row == sudoku.length) {
            return true;
        }

        if (sudoku[row][col] != 0) {
            return solve_sudoku(sudoku,row,col+1);
        }

        for(int val = 1; val<=9; val++){
            if(isValid(sudoku,row,col,val)){
                sudoku[row][col] = val;
                if(solve_sudoku(sudoku,row,col+1)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    private boolean isValid(int[][] sudoku, int row, int col, int val){
        //check row
        for(int j=0;j<sudoku[row].length;j++){
            if(sudoku[row][j]==val){
                return false;
            }
        }

        for(int j=0;j<sudoku.length;j++){
            if(sudoku[j][col]==val){
                return false;
            }
        }
        //only for multiplying it by 3 had to spend 4 hour debugging
        int subGridRow = (row/3)*3;
        int subGridCol = (col/3)*3;
        for(int i=subGridRow;i<subGridRow+3;i++){
            for(int j=subGridCol;j<subGridCol+3;j++){
                if(sudoku[i][j]==val){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[][] sudoku = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };

        SudokuSolverClean sudokuSolverClean = new SudokuSolverClean();
        sudokuSolverClean.solve_sudoku(sudoku,0,0);

        for(int row=0;row<sudoku.length;row++){
            for(int col=0;col<sudoku[row].length;col++){
                System.out.print(sudoku[row][col] + " ");
            }
            System.out.print("\n");
        }
    }

}
