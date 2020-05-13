package com.nextswe.prep.ds_goodrich.chapter13;

public class Chapter13_Main {
    public static int findBrute1(char[] text, char[] pattern){
        int n = text.length;
        int m = pattern.length;
        for(int i = 0; i<=n-m; i++){
            int k = 0;
            while(k<m && text[i+k] == pattern[k++]);
            if(k==m)return i;
        }
        return -1;
    }


    public static void main(String[] args){
        System.out.println(findBrute1(
            "In applying this technique to design a brute-force pattern-matching algorithm".toCharArray(),
            "technique".toCharArray()
        ));
    }
}
