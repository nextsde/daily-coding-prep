package com.nextswe.prep.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=JzONv5kaPJM
//keeping the messy code for future reference :)
//took me 4 hour just to find i had to
/*
        int subGridRow = (row/3);
        int subGridCol = (col/3);
        multiply this by 3:
        int subGridRow = (row/3)*3;
        int subGridCol = (col/3)*3;
 */
public class SudokuSolver {
    private boolean solve_sudoku(List<List<Integer>> sudokuList, int row, int col){
        if (col == sudokuList.size()) {
            col = 0;
            row++;
        }
        if (row == sudokuList.size()) {
            return true;
        }

        if (sudokuList.get(row).get(col) != 0) {
            return solve_sudoku(sudokuList,row,col+1);
        }

        for(int val = 1; val<=9; val++){
            if(isValid(sudokuList,row,col,val)){
//                System.out.println("setting row="+row+" col="+col+" current > "+sudokuList.get(row).get(col));
                sudokuList.get(row).set(col,val);
//                System.out.println("setting ["+row+"]["+col+"]="+sudokuList.get(row).get(col) +"\ncalling ["+row+"]["+(col+1)+"]");
                if(solve_sudoku(sudokuList,row,col+1)){
                    return true;
                }
                sudokuList.get(row).set(col,0);
            }
        }


//        for(int cc = 0; cc < sudokuList.get(row).size(); cc++){
////            System.out.println("setting row="+row+" col="+cc+" > "+sudokuList.get(row).get(cc));
//            if(sudokuList.get(row).get(cc)==0){
//                for(int vv = 1; vv<=9;vv++){
//                    if(isValid(sudokuList,row,cc,vv)){
//                        System.out.println("setting row="+row+" col="+cc+" new > "+vv);
//                        sudokuList.get(row).set(cc,vv);
//                        if(solve_sudoku(sudokuList,row+1)){
//                            return true;
//                        }else{
//                            sudokuList.get(row).set(cc,0);
//                        }
////                        sudokuList.get(row).set(col,0);
//                    }else{
////                        System.out.println("failed row="+row+" col="+cc+" > "+vv);
//                    }
//                }
//            }
//        }

//        if(row==sudokuList.size()){
//            return true;
//        }
//        for(int rr = row; rr < sudokuList.size(); rr++){
//            for(int cc = col; cc < sudokuList.get(cc).size(); cc++){
//                if(sudokuList.get(row).get(col)==0){
//                    for(int vv = 1; vv<=9;vv++){
//                        if(isValid(sudokuList,row,col,vv)){
//                            sudokuList.get(row).set(col,vv);
//                            solve_sudoku(sudokuList,row+1,col);
//                        }
//                    }
//                }
//            }
//        }
//        for(int row = 0; row < sudokuList.size(); row++){
//            for(int col = 0; col < sudokuList.get(row).size(); col++){
////            System.out.println("setting row="+row+" col="+cc+" > "+sudokuList.get(row).get(cc));
//                if(sudokuList.get(row).get(col)==0){
//                    for(int vv = 1; vv<=9;vv++){
//                        if(isValid(sudokuList,row,col,vv)){
//                            System.out.println("setting row="+row+" col="+col+" new > "+vv);
//                            if(solve_sudoku(sudokuList,row+1)){
//                                sudokuList.get(row).set(col,vv);
//                                return true;
//                            }
////                        sudokuList.get(row).set(col,0);
//                        }else{
////                        System.out.println("failed row="+row+" col="+cc+" > "+vv);
//                        }
//                    }
//                    return false;
//                }
//            }
//        }
//        for(int cc = 0; cc < sudokuList.get(row).size(); cc++){
////            System.out.println("setting row="+row+" col="+cc+" > "+sudokuList.get(row).get(cc));
//            if(sudokuList.get(row).get(cc)==0){
//                for(int vv = 1; vv<=9;vv++){
//                    if(isValid(sudokuList,row,cc,vv)){
//                        System.out.println("setting row="+row+" col="+cc+" new > "+vv);
//                        sudokuList.get(row).set(cc,vv);
//                        if(solve_sudoku(sudokuList,row+1)){
//                            return true;
//                        }else{
//                            sudokuList.get(row).set(cc,0);
//                        }
////                        sudokuList.get(row).set(col,0);
//                    }else{
////                        System.out.println("failed row="+row+" col="+cc+" > "+vv);
//                    }
//                }
//            }
//        }
//        if(sudokuList.get(row).get(col)==0){
//            sudokuList.get(row).set(col,i);
//            if(isValid())
//                solve_sudoku(sudokuList,)
//        }
//        for(int i=1;i<=9;i++){
//
//        }
        return false;
    }



    private boolean isValid(List<List<Integer>> sudokuList, int row, int col, int val){
        //check row
//        System.out.println(val);
        for(int j=0;j<sudokuList.size();j++){
            if(sudokuList.get(row).get(j)==val){
//                System.out.println("["+row+"]"+"["+j+"]"+val);
                return false;
            }
        }

        for(int j=0;j<sudokuList.size();j++){
            if(sudokuList.get(j).get(col)==val){
//                System.out.println("["+j+"]"+"["+col+"]"+val);
                return false;
            }
        }
        //only for multiplying it by 3 had to spend 4 hour debugging
        int subGridRow = (row/3)*3;
        int subGridCol = (col/3)*3;

//        System.out.println("subGridRow ["+row+"]"+"["+col+"]"+val);
//        System.out.println("subGridRow ["+subGridRow+"]"+"["+subGridCol+"]"+val);
        for(int i=subGridRow;i<subGridRow+3;i++){
            for(int j=subGridCol;j<subGridCol+3;j++){
                if(sudokuList.get(i).get(j)==val){
//                    System.out.println("["+i+"]"+"["+j+"]"+val);
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
        List<List<Integer>> sudokuList = new ArrayList<>();
        for(int i=0;i<9;i++){
            sudokuList.add(new ArrayList<>());
            for(int j=0;j<9;j++){
                sudokuList.get(i).add(sudoku[i][j]);
            }
        }

        for(int row=0;row<sudokuList.size();row++){
            for(int col=0;col<sudokuList.get(row).size();col++){
                System.out.print(sudokuList.get(row).get(col) + " ");
            }
            System.out.print("\n");
        }

//        for (List<Integer> integers : sudokuList) {
//            for (Integer integer : integers) {
//                System.out.print(integer + " ");
//            }
//            System.out.print("\n");
//        }

//        for(int j=0;j<sudokuList.get(0).size();j++){
//            System.out.print(sudokuList.get(0).get(j) + " ");
//        }


        SudokuSolver sudokuSolver = new SudokuSolver();
        System.out.println(sudokuSolver.solve_sudoku(sudokuList,0,0));

        for(int row=0;row<sudokuList.size();row++){
            for(int col=0;col<sudokuList.get(row).size();col++){
                System.out.print(sudokuList.get(row).get(col) + " ");
            }
            System.out.print("\n");
        }
    }

}
