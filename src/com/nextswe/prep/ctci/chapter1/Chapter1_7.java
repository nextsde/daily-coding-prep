package com.nextswe.prep.ctci.chapter1;

import java.util.Arrays;

public class Chapter1_7 {
    /*
    Question: Given an image represented by NxN matrix, where each pixel in the image is 4 bytes,
    write a method to rotate the image by 90 degrees. Can you do this in place?
    DON'T START WRITING CODE:

    Understand the question well.

    Ask or Clarify:
    Is it going to be clockwise or counterclockwise rotation?


    My thought:
     */
    static boolean rotate(int[][] matrix){
        if( matrix.length==0|| matrix.length!=matrix[0].length ) return false;
        int n = matrix.length;
        System.out.println();
        for(int[] row:matrix){
            System.out.println(Arrays.toString(row));
        }
        //from: https://www.youtube.com/watch?v=SA867FvqHrM
        //transpose the matrix
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //reverse the array
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
        System.out.println();
        for(int[] row:matrix){
            System.out.println(Arrays.toString(row));
        }
        return true;
        /*
        //From CTCI
        for(int layer = 0;layer<n/2;layer++){
            int last = n-1-layer;
            for(int i = layer; i < last; i++){
                int offset = i - layer;
                int top = matrix[layer][i];
                matrix[layer][i] = matrix[last - offset][layer];
                matrix[last-offset][layer] = matrix[last][last - offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
        for(int[] row:matrix){
            System.out.println(Arrays.toString(row));
        }
        return true;
        */
    }



    public static void main(String[] args){
        rotate(
                new int[][]{
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                }
        );
        rotate(
                new int[][]{
                        {1,2,3,4,5},
                        {6,7,8,9,10},
                        {11,12,13,14,15},
                        {16,17,18,19,20},
                        {21,22,23,24,25}
                }
        );
    }
}
