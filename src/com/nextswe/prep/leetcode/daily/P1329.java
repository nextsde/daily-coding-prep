package com.nextswe.prep.leetcode.daily;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P1329 {
    public int[][] diagonalSort(int[][] mat) {
        PriorityQueue<Integer> minHeap= new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                if (o1>o2)
                    return -1;
                else if (o1==o2)
                    return 0;
                else
                    return 1;
            }
        });

        int m = mat.length-1;
        int n = mat[0].length - 1;
        int i = 0;
        int j = n;
        while(i!=m || j!=0){
            int ii = i;
            int jj = j;
            while(!(ii<0 || jj<0)){
                minHeap.add(mat[ii][jj]);
                ii--;
                jj--;
            }

            ii = i;
            jj = j;
            while(!(ii<0 || jj<0) && minHeap.size()>0){
                mat[ii][jj] = minHeap.poll();
                ii--;
                jj--;
            }
            if(i!=m){
                i++;
            }else{
                j--;
            }
        }
        return mat;
    }

    public static void main(String[] args){
        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        P1329 mP1329 = new P1329();
        mP1329.diagonalSort(mat);
    }
}
