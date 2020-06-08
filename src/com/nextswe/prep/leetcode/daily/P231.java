package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.utils.Utils;

public class P231 {
    //used hint :(
    //need to practice more bit manipulation
    public boolean isPowerOfTwo(int n) {
        System.out.println(Integer.toBinaryString(n));

        //two's complement
        System.out.println(Integer.toBinaryString(-n));
        //same as
        System.out.println();
        System.out.println(Integer.toBinaryString(~n));
        System.out.println(Integer.toBinaryString(~n+1));
        if(n<=0) return false;
        int n1 = n-1;
        return (n & n1)==0;
    }

    public static void main(String[] args){
        P231 p231 = new P231();
//        Utils.println(p231.isPowerOfTwo(-2147483648));
        Utils.println(p231.isPowerOfTwo(111));
        //00000000000000000000000001101111
        //11111111111111111111111110010001
    }
}
