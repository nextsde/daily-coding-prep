package com.nextswe.prep.leetcode.daily;

public class P1323 {
    public int maximum69Number (int num) {
        int n = num;
        int leftMost6Pos = 0;
        int atPos = 0;
        while(n!=0){
            atPos++;
            if(n%10==6){
                leftMost6Pos = atPos;
            }
            n = n/10;
        }
        int add = 3 * ((int) Math.pow(10, leftMost6Pos - 1));
        num = num+add;
        return num;
    }
    public static void main(String[] args){
        P1323 mP1323 = new P1323();
        System.out.println(mP1323.maximum69Number(969696));
    }
}
