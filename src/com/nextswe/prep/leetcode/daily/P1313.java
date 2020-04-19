package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.utils.Utils;

import java.util.Arrays;

public class P1313 {
/*
    public int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        int tF = 0;
        for(int i=0;i<n;i+=2){
            tF+=nums[i];
        }
        int[] freqs = new int[tF];
        int freqCursor = 0;
        for(int i=1;i<n;i+=2){
            int freq = nums[i-1];
            int val =  nums[i];
            while(freq>0){
                freqs[freqCursor++] = val;
                freq--;
            }
        }
        return freqs;
    }
*/

    //same with builtin Arrays.fill method
    public int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        int tF = 0;
        for(int i=0;i<n;i+=2){
            tF+=nums[i];
        }
        int[] freqs = new int[tF];
        int freqCursor = 0;
        for(int i=1;i<n;i+=2){
            int freq = nums[i-1];
            int val =  nums[i];
            Arrays.fill(freqs,freqCursor,freqCursor+freq,val);
            freqCursor+=freq;
        }
        return freqs;
    }

    public static void main(String[] args){
        P1313 p13 = new P1313();
        Utils.printArray(p13.decompressRLElist(new int[]{1,2,3,4}));
        Utils.printArray(p13.decompressRLElist(new int[]{1,1,2,3}));
    }
}
