package com.nextswe.prep.leetcode.daily;

public class P1281 {
    public int subtractProductAndSum(int n) {
        if(n<=0){
            return 0;
        }
        int m=1;
        int s=0;
        int d = 0;
        while(n>0){
            d=n%10;
            m*=d;
            s+=d;
            n/=10;
        }
        return m-s;
    }

    public static void main(String[] args){
        P1281  p1281 = new P1281();
        System.out.println(p1281.subtractProductAndSum(234));
        System.out.println(p1281.subtractProductAndSum(4421));
    }
}
