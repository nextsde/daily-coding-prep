package com.nextswe.prep.ds_goodrich.chapter3;

public class InsertionSort {
    public static void insertionSort(char[] data){
        int n = data.length;
        for(int k=1;k<n;k++){ //begin with second character since the first one is already sorted
            /*
            record current value that we need to insert between 0 .. k
            */
            char cur = data[k];
            /*
            we will iterate through 0..k to check whether
            all the previous value of cur is greater or not
            to find appropriate j for our cur
            */
            int j = k;
            while(j>0 && data[j-1]>cur){
                //shift right if the value is greater than cur
                //to make room for cur
                data[j] = data[j-1];
                j--;
            }
            //insert
            data[j] = cur;
        }
    }
}
