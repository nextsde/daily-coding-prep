package com.nextswe.prep.dailyrevision;

public class Revision_May22 {

    //swap using xor
    public static void swapXOR(int a, int b){
        System.out.println("a "+a);
        System.out.println("b "+b);
        a = a ^ b;
        b = a ^ b;
        a = b ^ a;
        System.out.println("a "+a);
        System.out.println("b "+b);
    }



    public static void main(String[] args){
        swapXOR(12,24);
    }
}
