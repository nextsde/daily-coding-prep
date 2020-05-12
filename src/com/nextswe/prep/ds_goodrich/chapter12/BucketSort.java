package com.nextswe.prep.ds_goodrich.chapter12;

import com.nextswe.prep.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=NvZG0dZ60RQ
//https://www.youtube.com/watch?v=VuXbEb5ywrU
//https://www.programiz.com/dsa/bucket-sort
public class BucketSort {
    //helper insertion sort for bucket sort
    public static void insertion_sort(List<Integer> arr){
        int n = arr.size();
        //since we can think a single element array is sorted
        //so we start from arr[1] because sub array arr[0]..arr[0] is already sorted
        //since it has only one element :) clever :D
        for(int i=1;i<n;i++){
            //select the current element
            //because we need to loop through i...0 to find the appropriate index
            //to put current_val in its proper place
            int current_val = arr.get(i);
            int current_index = i;
            //we loop until 0, because if we can go until 0
            //then we can easily guess that our current_val should be placed in
            //0, and if loop exits before that ...then whatever current_index is
            //we need to place our current_val in that position
            //up until we find the appropriate position for current_val
            //we we need to move all the element one place to the right since these element
            //must be bigger than current_val
            while(current_index>0 && arr.get(current_index-1)>current_val){
                arr.set(current_index,arr.get(current_index-1)); //moving the element one place to the right
                //decrementing current_index to process and compare with next element
                //that is before current_val and current current_index
                current_index--;
            }
            //once we reach in this position
            //we know for sure the loop terminated because it current_index must be either 0
            //or a value where current_val should go.
            //don't worry because before decrementing current_index we have already moved
            //current_index value one place to the right so right now there is two duplicate
            //element. means currently the value at current_index and current_index+1 has the same value
            //current_index with it's appropriate value and that is current_val
            arr.set(current_index, current_val);
        }
    }

    public static void bucket_sort(int[] arr, int n){
        System.out.println(Arrays.toString(arr));
        //initialize n number of bucket list
        ArrayList<Integer>[] bucket = new ArrayList[n];
        for(int i=0;i<n;i++){
            bucket[i] = new ArrayList<>();
        }
        //put each item to the appropriate bucketlist
        for(int i=0;i<arr.length;i++){
            int bucket_index = arr[i]/10;
            bucket[bucket_index].add(arr[i]);
        }
        //sort each bucket list individually
        for(int i=0;i<n;i++){
            insertion_sort(bucket[i]);
        }
        //scan through each bucket and put all the sorted element to the out array
        int index = 0;
        for(int i=0;i<n;i++){
            for(int j=0,size = bucket[i].size();j<size;j++){
                arr[index++] = bucket[i].get(j);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args){
        bucket_sort(Utils.getRandomIntArray(20,0,99),10);
    }

}
