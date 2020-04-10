package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.utils.Utils;

public class P231 {
    //used hint :(
    //need to practice more bit manipulation
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        int n1 = n-1;
        return (n & n1)==0;
    }

    public static void main(String[] args){
        P231 p231 = new P231();
        Utils.println(p231.isPowerOfTwo(-2147483648));
    }
}
