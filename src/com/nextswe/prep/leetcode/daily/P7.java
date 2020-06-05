package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P7 {
//    public int reverse(int x) {
//        int sign = 1;
//        if(x<0){
//            sign = -1;
//        }
//        x = x * sign;
//
//        Queue<Integer> qq = new LinkedList<>();
//        while(x!=0){
//            qq.offer(x%10);
//            x /= 10;
//        }
//        long result = 0;
//        while(!qq.isEmpty()){
//            int sz = qq.size();
//            result += (qq.poll()*(Math.pow(10,sz-1)));
//        }
//        result = sign*result;
//        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
//            return 0;
//        }
//        return (int)result;
//    }

/*
    public int reverse(int x) {
        int sign = 1;
        if(x<0){
            sign = -1;
        }
        x = x * sign;

        int[] a = new int[10];
        int d = 0;

        while(x!=0){
            a[d++] = x%10;
            x /= 10;
        }
        int i = 0;
        long result = 0;
        while(i!=d){
            result += a[i]*Math.pow(10,d-i-1);
            i++;
        }
        result = sign*result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }
*/

    public int reverse(int x) {
        int sign = 1;
        if(x<0){
            sign = -1;
        }
        x = x * sign;

        int[] a = new int[10];
        int d = 0;

        while(x!=0){
            a[d++] = x%10;
            x /= 10;
        }
        int i = 0;
        long result = 0;
        while(i!=d){
            result += a[i]*Math.pow(10,d-i-1);
            i++;
        }
        result = sign*result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }

    public static void main(String[] args){
        P7 pp = new P7();
        System.out.println(pp.reverse(123));
        System.out.println(pp.reverse(-123));
        System.out.println(pp.reverse(120));
        System.out.println(pp.reverse(-2147483412));
        System.out.println(pp.reverse(1534236469));
    }
}
