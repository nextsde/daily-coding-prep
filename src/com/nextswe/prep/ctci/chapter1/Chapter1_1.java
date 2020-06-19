package com.nextswe.prep.ctci.chapter1;

import java.util.HashSet;
import java.util.Set;

public class Chapter1_1 {
    /*
    Question: Implement an algorithm to determine if a string has all unique characters.

    DON'T START WRITING CODE:

    Ask:
    Come up with clarifying and insightful questions. Although you are interviewing for the job.
    But you will solve real world problem with your knowledge which will have real impact.

    Think like, you are solving this problem not for interview but for real users.
    One question should be, "Will this be only for ASCII characters or for unicode characters as well?"
    Because the software might be used by non-english speakers as well. In that case you will have to support unicode in your
    algorithm design.
     */
    public static boolean isUnique1(String s){
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }
    public static boolean isUnique2(String s){
        if(s.length()>128){
            return false;//Assuming ASCII characters, we can not have more than 128 character unique character in a string.
        }
        boolean[] char_set = new boolean[128];
        for(int i=0;i<s.length();i++){
            int val = s.charAt(i);
            if(char_set[val]){
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
    //only lowercase a-z
    public static boolean isUnique3(String s){
        int checker = 0;
        for(int i=0;i<s.length();i++){
            int val = s.charAt(i)-'a';
            if( (checker & ( 1 << val)) >0 ){
                return false;
            }
            checker |= ( 1 << val);
        }
        return true;
    }
    public static void main(String[] args){
//        System.out.println(isUnique2("ABC"));
//        System.out.println(isUnique2("ABCC"));

        System.out.println(isUnique3("abc"));
        System.out.println(isUnique3("abcc"));
    }
}
