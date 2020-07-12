package com.nextswe.prep.leetcode.days;

public class July_12 {
    public String addBinary(String a, String b) {
        String bigger = a.length()>b.length()?a:b;
        String smaller = a.length()<b.length()?a:b;

        StringBuilder sb = new StringBuilder();
        char c = '0';
        char r = '0';
        int j = bigger.length()-1;
        int i = 0;
        for(i=smaller.length()-1;i>=0;i--){
            if(smaller.charAt(i)=='1' && bigger.charAt(i)=='1'){
                if(c=='1'){
                    r = '1';
                }else{
                    r = '0';
                }
                c = '1';
            }else if(smaller.charAt(i)=='1' || bigger.charAt(i)=='1'){
                if(c=='1'){
                    r = '0';
                    c = '1';
                }else{
                    r = '1';
                    c = '0';
                }
            }else{
                if(c=='1'){
                    r = '1';
                }else{
                    r = '0';
                }
                c = '0';
            }
            sb.insert(0, r);
            j--;
        }
        while(j>=0){
            if(bigger.charAt(j)=='1'){
                if(c=='1'){
                    r = '0';
                    c = '1';
                }else{
                    r = '1';
                    c = '0';
                }
            }else{
                if(c=='1'){
                    r = '1';
                }else{
                    r = '0';
                }
                c = '0';
            }
            sb.insert(0, r);
            j--;
        }
        if(c=='1'){
            sb.insert(0, c);
        }
        return sb.toString().toString();
    }

    public static void main(String[] args){
        July_12 mJuly_12 = new July_12();
        System.out.println(mJuly_12.addBinary("1010","1011"));
    }
}
