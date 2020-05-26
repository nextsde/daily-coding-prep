package com.nextswe.prep.leetcode.daily;

public class P191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            count ++;
            n &=n-1;
        }
        return count;
    }

    public static void main(String[] args){
        P191 mP191 = new P191();
        System.out.println(mP191.hammingWeight(-3));
    }
}
