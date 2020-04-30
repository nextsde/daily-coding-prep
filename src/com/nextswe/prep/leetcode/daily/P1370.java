package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;
//https://leetcode.com/problems/increasing-decreasing-string/
public class P1370 {
    public String sortString(String s) {
        StringBuilder sb = new StringBuilder();
        if(s==null || s.length()==0){
            return sb.toString();
        }

        char[] chars = s.toCharArray();
        int n = chars.length-1;
        Arrays.sort(chars);

        char no_char = '0';
        int i,j;
        char smallest, largest;
        int count = 0;
        while(count<=n){
            i = 0;
            j = n;
            smallest=96;
            largest=123;
            while(i<=n && chars[i]==no_char){
                i++;
            }
            while(i<=n){
                if(chars[i]!=no_char && smallest<chars[i]){
                    smallest = chars[i];
                    sb.append(smallest);
                    chars[i] = no_char;
                    count++;
                }
                i++;
            }
            while(j>=0 && chars[j]==no_char){
                j--;
            }
            while(j>=0){
                if(chars[j]!=no_char && chars[j]<largest){
                    largest = chars[j];
                    sb.append(largest);
                    chars[j] = no_char;
                    count++;
                }
                j--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        P1370 mP1370 = new P1370();
        System.out.println(mP1370.sortString("aaaabbbbcccc"));
        System.out.println(mP1370.sortString("rat"));
        System.out.println(mP1370.sortString("leetcode"));
        System.out.println(mP1370.sortString("ggggggg"));
        System.out.println(mP1370.sortString("spo"));
        System.out.println(mP1370.sortString(null));
    }

    //better solution by others
/*
    public String sortString(String s) {
        int len = s.length();
        int[] freq = new int[26];
        for (int index = 0; index < len; index++) {
            freq[s.charAt(index) - 'a']++;
        }
        StringBuilder sb = new StringBuilder(len);
        int count = 0;
        while (count < len) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i] = freq[i] - 1;
                    count++;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i] = freq[i] - 1;
                    count++;
                }
            }
        }
        return sb.toString();
    }*/
}
