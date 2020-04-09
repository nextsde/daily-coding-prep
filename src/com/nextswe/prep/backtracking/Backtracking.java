package com.nextswe.prep.backtracking;

import com.nextswe.prep.utils.Utils;

public class Backtracking {
    public void permutation(int[] items, int start, int end){
        if(start==end){
            Utils.printArray(items);
        }

        for(int i=start;i<=end;i++){
            //swapping
            int tmp = items[start];
            items[start] = items[i];
            items[i] = tmp;
            permutation(items,start+1,end);
            //backtracking
            tmp = items[start];
            items[start] = items[i];
            items[i] = tmp;
        }
    }

    private static void permute(String perm, String word) {
        if (word.isEmpty()) {
            System.err.println(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permute(perm + word.charAt(i), word.substring(0, i)
                        + word.substring(i + 1, word.length()));
            }
        }
    }

    public static void main(String[] args){
        Backtracking backtracking = new Backtracking();
//        int arr[] = new int[]{1,2,3};
//        backtracking.permutation(arr, 0, arr.length-1);
//        permute("", "123");
    }


}
