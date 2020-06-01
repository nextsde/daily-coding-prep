package com.nextswe.prep.abdulbari;

import java.util.Arrays;

//https://www.youtube.com/watch?v=HHIc5JZyenI
public class OptimalMergePattern {
    public static void main(String[] args){
        int[] sizes = {20,30,10,5,30};
        Arrays.sort(sizes);
        System.out.println(Arrays.toString(sizes));
        int res = 0;
        for(int i=0;i<sizes.length-1;i++){
            int n = (sizes[i]+sizes[i+1]);
            sizes[i] = 0;
            sizes[i+1] = n;
            res+=n;
            Arrays.sort(sizes);
            System.out.println(Arrays.toString(sizes));
        }
        System.out.println(res);
    }
}
