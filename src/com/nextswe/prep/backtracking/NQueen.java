package com.nextswe.prep.backtracking;

import com.nextswe.prep.utils.Utils;

import java.util.ArrayList;
import java.util.List;
//https://www.youtube.com/watch?v=wGbuCyNpxIg
public class NQueen {
    public void nqueens_solver(int n, int row, List<Integer> colPlacements, List<List<Integer>> result){
        if(n==row){
            result.add(new ArrayList<>(colPlacements));
        }else{
            for(int col=0;col<n;col++){
                colPlacements.add(col);
                if(isValid(colPlacements)){
                    nqueens_solver(n,row+1,colPlacements,result);
                }
                colPlacements.remove(colPlacements.size()-1);
            }
        }
    }

    public boolean isValid(List<Integer> colPlacements){
        int rowId = colPlacements.size()-1;
        for(int i=0;i<rowId;i++){
            int diff = Math.abs(colPlacements.get(i)-colPlacements.get(rowId));
            if(diff==0 || diff == rowId - i){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        NQueen nQueen = new NQueen();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();
        nQueen.nqueens_solver(4, 0, colList, result);
        Utils.printListList(result);
//        Utils.printList(colList);
    }
}
