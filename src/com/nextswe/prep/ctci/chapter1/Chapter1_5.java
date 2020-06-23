package com.nextswe.prep.ctci.chapter1;

import java.util.HashMap;
import java.util.Map;

public class Chapter1_5 {
    /*
    Question: There are three types of edits that can be performed on strings: insert a character,
    remove a character, or replace a character. Given two strings, write a function to check if they are
    one edit (or zero edits) away.

    DON'T START WRITING CODE:

    Understand the question well.
    Example:
    pale, ple -> true
    pales, pale -> true
    pale, bale -> true
    pale, bake -> false

    Ask or Clarify:
    Is it going to be case sensitive?
    What about special or whitespace characters? Should they be ignored?


    My thought:
     */
    static boolean oneReplaceAway(String str1, String str2){
        int diff = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                diff++;
            }
        }
        return diff==1;
    }

    static boolean oneInsertDeleteAway(String small, String big){
        int i = 0;
        int j = 0;
        while(i<small.length()){
            if(small.charAt(i)==big.charAt(j)){
                i++;
            }
            j++;
        }
        return (big.length()-j)==1 || j-i==1;
    }
//    static boolean oneEditAway(String str1, String str2){
//        if(str1.length()==str2.length()){
//            return oneReplaceAway(str1, str2);
//        }else if(str1.length()+1==str2.length()){
//            return oneInsertDeleteAway(str1, str2);
//        }else if(str2.length()+1==str1.length()){
//            return oneInsertDeleteAway(str2, str1);
//        }
//        return false;
//    }


    static boolean oneEditAway(String str1, String str2){
        if(Math.abs(str1.length()-str2.length())>1){
            return false;
        }
        String smaller = str1.length()<str2.length()?str1:str2; //smaller string
        String bigger = str1.length()<str2.length()?str2:str1; //bigger string
        int smaller_index = 0;
        int bigger_index = 0;
        boolean foundDiff = false;
        while(bigger_index<bigger.length() && smaller_index<smaller.length()){
            if(smaller.charAt(smaller_index)!=bigger.charAt(bigger_index)){
                if(foundDiff) return false;
                foundDiff = true;
                if(smaller.length()==bigger.length()){
                    smaller_index++;
                }
            }else{
                smaller_index++;
            }
            bigger_index++;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(oneEditAway("ale","bale"));
        System.out.println(oneEditAway("pale","ple"));
        System.out.println(oneEditAway("pales","pale"));
        System.out.println(oneEditAway("pale","bale"));
        System.out.println(oneEditAway("pale","pale"));
        System.out.println(oneEditAway("pale","bake"));
    }
}
