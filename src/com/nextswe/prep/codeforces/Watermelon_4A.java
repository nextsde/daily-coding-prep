package com.nextswe.prep.codeforces;

import java.util.Scanner;

public class Watermelon_4A {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n>2 && n%2==0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        in.close();
    }
}
