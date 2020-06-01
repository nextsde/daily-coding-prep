package com.nextswe.prep.abdulbari;

//https://www.youtube.com/watch?v=zPtI8q9gvX8
public class JobSequencing {
    public static void main(String[] args){
//        int[] profits = {35,30,25,20,15,12,5};
//        int[] deadlines = {3,4,4,2,3,1,2};
        int[] profits = {20,15,10,5,1};
        int[] deadlines = {2,2,1,3,3};
        int max_deadline = deadlines[0];
        for(int i=1;i<deadlines.length;i++){
            if(max_deadline<deadlines[i]){
                max_deadline = deadlines[i];
            }
        }
        int[] slots = new int[max_deadline];
        int profit = 0;
        int j = 0;
        for(int i=0;i<deadlines.length;i++){
            j = deadlines[i]-1;
            while(j>=0 && slots[j] > 0){
                j--;
            }
            if(j>=0) {
                slots[j] = deadlines[i];
                profit+=profits[i];
            }
        }
        System.out.println(profit);

    }
}
