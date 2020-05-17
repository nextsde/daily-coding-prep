package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;

public class P5_trylater {
    String subString = "";
    int max = Integer.MIN_VALUE;
    public boolean isPalindrome(String s){
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }

    public int lpsRecursive(String s, int i, int j, int[][] memo) {
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(i==j){
            memo[i][j] = 0;
            return memo[i][j];
        }else{
            String sb = s.substring(i, j+1);
            if(isPalindrome(sb)){
                memo[i][j] = sb.length();
                if(max<memo[i][j]){
                    max = memo[i][j];
                    subString = sb;
                }
                return sb.length();
            }else{
                memo[i][j] = Math.max(lpsRecursive(sb, i+1,j,memo),
                                lpsRecursive(sb, i,j-1,memo));
                return memo[i][j];
            }
        }
    }
    public String lpsRecursive(String s) {
        int[][] memo = new int[s.length()][s.length()];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
        lpsRecursive(s,0,s.length()-1,memo);
//        for(int i=0;i<memo.length;i++){
//            System.out.println(Arrays.toString(memo[i]));
//        }
        return subString;
    }

    public String longestPalindrome(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        int[][] memo = new int[s.length()][s.length()];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
        lpsRecursive(s,0,s.length()-1,memo);
        return subString;
    }

    public static void main(String[] args){
        P5_trylater p5 = new P5_trylater();
        System.out.println(p5.longestPalindrome("babad"));

//        System.out.println(p5.isPalindrome("bab"));
//        System.out.println(p5.isPalindrome("madam"));
//        System.out.println(p5.isPalindrome("racecar"));
//        System.out.println(p5.isPalindrome("raecar"));
    }
}
