package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.utils.Utils;

public class P50 {

//    public double power(double x, int n) {
//        if(n==0){
//            return 1;
//        }else{
//            double x1 = power(x,n/2);
//            double result = x1 * x1;
//            if(n%2==1){
//                result = x * result;
//            }
//            return result;
//        }
//    }
//    public double myPow(double x, int n) {
//        if(n<0){
//            x = 1.0/x;
//            n = n * -1;
//        }
//        return power(x,n);
//    }
public double myPow(double x, int n) {
    if(n == 0)
        return 1;
    if(n<0){
        n = -n;
        x = 1/x;
    }
    return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
}

    public static void main(String[] args){
        P50 p50 = new P50();
//        Utils.println(p50.myPow(2.00000, 10));
//        Utils.println(p50.myPow(2.10000, 3));
//        Utils.println(p50.myPow(2.00000, -2));
//        Utils.println(p50.myPow(2.00000, 0));
//        Utils.println(p50.myPow(1.00000, 2147483647));
        Utils.println(p50.myPow(2.00000, -2147483648));
    }



    //accepted
    //was practicing recursion... used recursion to solve this one
    //why bother multiplying the same thing mutiple times :) , just divide and multiply
    //it by itself. uses implicit stack for memory
    //time complexity should be O(logn)
    //got some hints from hnko







//    public double power(double x, int n) {
//        if(n==0){
//            return 1;
//        }else{
//            double x1 = myPow(x,n/2);
//            double result = x1 * x1;
//            if(n%2==1){
//                result = x * result;
//            }
//            return result;
//        }
//    }
//    public double myPow(double x, int n) {
//        if(n==0){
//            return 1;
//        }
//        if(n<0){
//            x = 1.0/x;
//            n = n * -1;
//        }
//        return power(x,n);
//    }
    //time limit exceeded solution
/*
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        int symbol = 1;
        if(n<0){
            symbol = -1;
            n = n*symbol;
        }
        double result = x;
        for(int i=0;i<n-1;i++){
            result = result*x;
        }
        return symbol==1?result:(1/result);
    }
*/
}
