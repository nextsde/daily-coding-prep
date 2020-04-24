package com.nextswe.prep.leetcode.daily;

public class P1221 {
    //accepted
    public int balancedStringSplit(String s) {
        int bc = 0;
        int mb = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='R'){
                bc+=1;
            }else{
                bc-=1;
            }
            if(bc==0){
                mb+=1;
            }
        }
        return mb;
    }

    public static void main(String[] args){
        P1221 mP1221 = new P1221();
        System.out.println(mP1221.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(mP1221.balancedStringSplit("RLLLLRRRLR"));
        System.out.println(mP1221.balancedStringSplit("LLLLRRRR"));
        System.out.println(mP1221.balancedStringSplit("RLRRRLLRLL"));

        int a = 1<<2;
        System.out.println(a);
    }
}
