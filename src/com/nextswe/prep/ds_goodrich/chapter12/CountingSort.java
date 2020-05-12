package com.nextswe.prep.ds_goodrich.chapter12;

import com.nextswe.prep.utils.Utils;

import java.util.Arrays;

//https://www.programiz.com/dsa/counting-sort
//https://www.youtube.com/watch?v=pJ1IQD5rv4o
//https://www.youtube.com/watch?v=1mh2vilbZMg
//O(n+k) ~ exact bound big theta is also same
public class CountingSort {
    public static void counting_sort(int[] arr){
        //this will be our output array
        int[] output = new int[arr.length];
        //print to see the unsorted values
        System.out.println(Arrays.toString(arr));
        //get the max key value from the array which will be used to initialize our count array
        int max = 0;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        //initialize count array with max+1
        //why max+1? say we get max key 3, if we initialize count array with 3
        //then count will have index 0,1,2 but we need 3 as well since 3 is a value
        //inside our original array that is why we need 3+1 so that we can use count
        //arrays 0,1,2,3 as index
        int[] count = new int[max+1];
        //fill the count array with 0
        Arrays.fill(count,0);
        //now it is time for incrementing the count of each key we find in the original array
        //go through the original array get the key
        //we will increment the value we have at key'th position in count array
        //for example: let's say in original array we have a key 10 at position 3
        //now we increment value of count array at position 10
        //key=arr[i];count[key]++; or count[arr[i]]++;
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }

        //now do a cumulative sum/running sum count array.
        //add current position value with previous position value
        //store the resultant value current position
        //we do that from position 1 because for the first position we do not
        //have any previous value
        //why runningSum?
        //this tells us how many elements do we have that are less or equal to i'th position.
        for(int i=1;i<count.length;i++){
            count[i] = count[i-1]+count[i];
        }

        //final placement loop.
        //loop through the original array in reverse order
        //decrement the key'th position in the count because we will use that key
        //in our output array.
        //why decrementing count before using the key?
        //because array works with 0 based index.
        //for example: let's assume at position 0 of count array we have runningSum 1
        //that means 0 is a key in our original array which occurs 1 time.
        //since before 0 we do not have anything, we don't need to worry about how many
        //elements there are before us.
        //index of count array is the key from our original array
        //since 0 is the lowest index for any array where can we put the 0 in output array
        //because 0 occurs only 1 time we need to put 0 in the first position of output array
        //that is 1-1 = 0, so we put one 0 key in output's 0 (first position)
        //this is also true for end of the array.
        //for example: in count array we might have some index where the runningSum is 20
        //assuming our output array is length 20. since array will go from 0 .. 19 this needs
        //to decremented before we can place the sorted key
        //why reverse order?
        //for stability
        for(int i=arr.length-1;i>=0;i--){
            output[--count[arr[i]]] = arr[i];
        }
        System.out.println(Arrays.toString(output));
    }
    public static void main(String[] args){
        //generate a random integer array with keys between 0-100
        counting_sort(Utils.getRandomIntArray(20));
        counting_sort(Utils.getRandomIntArray(20));
    }
}
