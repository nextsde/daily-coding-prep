package com.nextswe.prep.backtracking;

import com.nextswe.prep.utils.Utils;
import sun.security.util.BitArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {
    public void permutation(int[] items, int start, int end){
        if(start==end){
            Utils.printArray(items);
        }else {
            for (int i = start; i <= end; i++) {
                //swapping
                int tmp = items[start];
                items[start] = items[i];
                items[i] = tmp;
                permutation(items, start + 1, end);
                //backtracking
                tmp = items[start];
                items[start] = items[i];
                items[i] = tmp;
            }
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

    private static void permuteArray(int a[], int b[], int start, int end){
        if(start==end){
            Utils.printArray(a);
        }else{
            for(int i=start;i<a.length;i++){
                //fixing the first element
                a[start] = b[i];
                permuteArray(a,b,start+1,end);
                a[start] = b[i];
            }
        }
    }

    public static void permuteArray(int a[]){
        int[] b = a.clone();
        permuteArray(a,b,0,a.length);
    }

    public static void main(String[] args){
        Backtracking backtracking = new Backtracking();

//        int arr[]  = new int[]{1,2,3};
////        backtracking.permutation(arr, 0, arr.length-1);
////        permute("", "123");
//        permuteArray(arr);
//
//        //
//        int hour = 0;
//        //first position
//        hour = hour | 1;
//        //second position
//        hour = hour | (1<<1);
//        //third position
//        hour = hour | (1<<2);
//        //fourth position
//        hour = hour | (1 << 3);
//
//
//        int min = 0;
//        //first position
//        min = min | 1;
//        //second position
//        min = min | (1<<1);
//        //third position
//        min = min | (1<<2);
//        //fourth position
//        min = min | (1<<3);
//        //fifth position
//        min = min | (1<<4);
//        //sixth position
//        min = min | (1 << 5);
//
//
//        System.out.println("hour = " + hour);
//        System.out.println("min = " + min);
//        System.out.println("a&b = " + (hour | (1 << 2)));
    }


}
