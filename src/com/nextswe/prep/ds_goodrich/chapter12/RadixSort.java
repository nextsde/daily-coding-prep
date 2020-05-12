package com.nextswe.prep.ds_goodrich.chapter12;

import com.nextswe.prep.utils.Utils;

import java.util.Arrays;
//https://www.youtube.com/watch?v=pJ1IQD5rv4o
//https://www.youtube.com/watch?v=JMlYkE8hGJM
//https://www.programiz.com/dsa/radix-sort
public class RadixSort {
    public static void radix_sort(int[] arr){
        System.out.println(Arrays.toString(arr));
        //final output array
        int[] output = new int[arr.length];
        //get the max key from the arr
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        //get number of digits from the max number using logarithm
        //FLOOR[LOG10(N)]+1
        int digits = ((int)Math.floor(Math.log10(max)))+1;
        int[] count = new int[10];
        //current place value we are working with
        //here is the process we are going to follow:
        //since we need to select current significant digit from right to left
        //first digit we will choose is right most digit
        //if we just do mod by 10 we can get the rightmost digit but since we need to select
        //the next significant digit that is why we need place value selector
        //at first we are selecting the unit place that is why place is 1
        //for example: 485 with place=1 -> (485/1)%10 = 5
        //after processing the first one place will be 10, (485/10)%10 = 8
        int place = 1;
        //counting sort is done digits times for each significant digits
        while(digits>0){
            Arrays.fill(count,0);
            for(int i=0;i<arr.length;i++){
                count[(arr[i]/place)%10]++;
            }
            for(int i=1;i<count.length;i++){
                count[i] = count[i-1]+count[i];
            }
            for(int i=arr.length-1;i>=0;i--){
                output[--count[(arr[i]/place)%10]] = arr[i];
            }
            place *= 10;
            digits--;
            for(int i=0;i<output.length;i++){
                arr[i] = output[i];
            }
        }
        System.out.println(Arrays.toString(output));
    }

    public static void main(String[] args){
        radix_sort(Utils.getRandomIntArray(20,500));
    }
}
