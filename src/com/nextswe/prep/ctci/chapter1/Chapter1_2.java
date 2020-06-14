package com.nextswe.prep.ctci.chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Chapter1_2 {
    //Question: Given two strings, write a method to decide if one is a permutation of the other
    /*
    Ask:
    DON'T START WRITING CODE:
    Come up with clarifying and insightful questions. Although you are interviewing for the job.
    But you will solve real world problem with your knowledge which will have real impact.

    Think like, you are solving this problem not for interview but for real users.
    Questions should be,
    "Will this be only for ASCII characters or for unicode characters as well?"
    "I am assuming both string will have same length?"
    "Is it going to be case sensitive?"
    "What about whitespace or other special characters? I mean will whitespace be significant or not significant?"
    "For example: is " dog " should be a permutation of "god" ?
     */
    //O(n) with O(n) space
    public static boolean isPermutation1(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        Map<Character, Integer> mp1 = new HashMap<>();

        for(int i=0;i<s1.length();i++){
            mp1.put(s1.charAt(i),mp1.getOrDefault(s1.charAt(i),0)+1);
        }

        for(int i=0;i<s2.length();i++){
            mp1.put(s2.charAt(i),mp1.getOrDefault(s2.charAt(i),0)-1);
        }
        for(Character cc: mp1.keySet()){
            if(mp1.get(cc)!=0){
                return false;
            }
        }
        return true;
    }

    public static String getSortedString(String ss){
        char[] chars = ss.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public static boolean isPermutation2(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        String srt1 = getSortedString(s1);
        String srt2 = getSortedString(s2);
        return srt1.equals(srt2);
    }
    public static void main(String[] args){
//        System.out.println(isUnique2("ABC"));
//        System.out.println(isUnique2("ABCC"));

        System.out.println(isPermutation2("abc","cba"));
        System.out.println(isPermutation2("abc","cbaa"));
        System.out.println(isPermutation2("bca","cba"));
    }
}
