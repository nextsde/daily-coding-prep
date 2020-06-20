package com.nextswe.prep.codeforces;

import java.util.Scanner;

public class T_primes_230B_trylater {
    public static boolean oneDivisor(int n){
        int low = 2, high = n-1;
        int divCount = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(n%mid==0){
                System.out.print(mid+" ");
                divCount++;
            }
            high = mid-1;
        }
        return divCount==1;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            int val = in.nextInt();
            System.out.print("1 ");
            if(oneDivisor(val)){
                System.out.print(" "+val);
                System.out.println();
                System.out.println("Yes");
            }else{
                System.out.print(" "+val);
                System.out.println();
                System.out.println("No");
            }
        }
    }
}
