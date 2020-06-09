package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;

public class P567 {
/*
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        int j = 0;
        for (int i = 0; i < s1.length(); i++)
            s1map[s1.charAt(i) - 'a']++;

        int i = 0;
        for (j = 0; j < s1.length()-1; j++) {
            s2map[s2.charAt(j) - 'a']++;
        }
        for (i = s1.length()-1; i < s2.length(); i++) {
            s2map[s2.charAt(i) - 'a']++;
            if (matches(s1map, s2map)){
                return true;
            }else{
                s2map[s2.charAt(i-s1.length()+1) - 'a']--;
            }
        }
        return false;
    }
    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
    */


    //Optimal Solution from:
    //https://leetcode.com/articles/short-permutation-in-a-long-string/?page=3
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i])
                count++;
        System.out.println(Arrays.toString(s1map));
        System.out.println(Arrays.toString(s2map));
        System.out.println(count);
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r])
                count++;
            else if (s2map[r] == s1map[r] + 1)
                count--;
            s2map[l]--;
            if (s2map[l] == s1map[l])
                count++;
            else if (s2map[l] == s1map[l] - 1)
                count--;
        }
        System.out.println(Arrays.toString(s1map));
        System.out.println(Arrays.toString(s2map));
        return count == 26;
    }
    public static void main(String[] args){
        P567 mP567 = new P567();
//        System.out.println(mP567.checkInclusion("ab","eidbaooo"));
//        System.out.println(mP567.checkInclusion("dinitrophenylhydrazine","acetylphenylhydrazine"));
        System.out.println(mP567.checkInclusion("adc","dcda"));
    }
}
