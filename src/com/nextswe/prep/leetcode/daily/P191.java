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


        // Detect if two integers have opposite signs
        int x = -20, y = -x;
//        Integer.toBinaryString();
        boolean opposite = (( x ^ y ) < 0 );
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        System.out.println(Integer.toBinaryString(x ^ y));
    }
}
