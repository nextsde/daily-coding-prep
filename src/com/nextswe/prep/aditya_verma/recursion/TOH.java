package com.nextswe.prep.aditya_verma.recursion;

public class TOH {
    private static void solve(int n, char s, char h, char d){
        if(n==1){
            System.out.println("Move dis "+n+" from "+s+" to "+d);
            return;
        }
        solve(n-1,s,d,h);//move n-1 disks from source to helper as destination using destination as helper
        System.out.println("Move dis "+n+" from "+s+" to "+d);
        solve(n-1,h,s,d);
    }
    public static void main(String[] args){
        solve(5,'S','H','D');
    }
}
