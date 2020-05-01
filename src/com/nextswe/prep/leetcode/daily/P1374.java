package com.nextswe.prep.leetcode.daily;

//https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
public class P1374 {
    //accepted
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n-1;i++){
            sb.append('a');
        }
        if(n%2==0){
            sb.append('b');
        }else{
            sb.append('a');
        }
        return sb.toString();
    }

    public static void main(String[] args){
        P1374 mP1374 = new P1374();
        System.out.println(mP1374.generateTheString(10));
    }
}
