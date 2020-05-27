package com.nextswe.prep.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1414 {

    public int findMinFibonacciNumbers(int k) {
        List<Integer> fibList = new ArrayList<>();
        int f0 = 1;
        int f1 = 1;
        fibList.add(f0);
        fibList.add(f1);
        int f2 = f0+f1;
        while(f2<=k){
            fibList.add(f2);
            f0 = f1;
            f1 = f2;
            f2 = f0+f1;
        }

        int fid = fibList.size()-1;
        int res = 0;
        while(k>0){
            k = k - fibList.get(fid);
            while(k > 0){
                --fid;
                if(fibList.get(fid)<=k){
                    break;
                }
            }
            res++;
        }
        return res;
    }


    /*static double phi = 0.5*(Math.sqrt(5)+1);

    public int findMinFibonacciNumbers(int k) {
        int res = 0;
        while(k>0){
            int kk = fib_range(k);
            k = k - fib_range(k);
            System.out.println(kk);
            res++;
        }
        return res;
    }

    public int fib(int n)
    {
        return (int) ((Math.pow(phi, n) - Math.pow(1 - phi, n)) / Math.sqrt(5));
    }
    public int fib_lowerbound(double N, int min, int max)
    {
        int newpivot = (min+max)/2;
        if (min==newpivot)
            return newpivot;
        if (fib(newpivot) <= N) {
            return fib_lowerbound(N, newpivot, max);
        }else{
            return fib_lowerbound(N, min, newpivot);
        }
    }

    public int fib_range(int n)
    {
        if(n==0 ||n==1 ||n==2 ||n==3 ||n==5||n==8 ||n==13){
            return n;
        }else if(fib(n)!=n){
            int lbound = fib_lowerbound(n,0,n);
            return fib(lbound);
        }else{
            return n;
        }
    }*/

    public static void main(String[] args){
        P1414 mP1414 = new P1414();
//        System.out.println(mP1414.fib(7));
//        System.out.println(mP1414.fib_range(5));
        System.out.println(mP1414.findMinFibonacciNumbers(113));
    }
}
