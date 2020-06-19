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
    Palindrome can be thought of as a mirror. A string, whose left and right part are mirror of one another
    we can say that is a palindrome.
    For example:
    Ab b bA , RAC-E-CAR, ABBA

    In a palindrome string we can have two situation where one's length is odd and the others length is even.

    From above we can see that in a palindrome max 0 or 1 character can have odd frequency and the rest should
    have even frequency.

    Using this insight, all we need is to just count the frequency of each character and check whether at most one character
    has odd frequency or not.

    We can do that easily with a hash table.


     */
    static boolean isPalindromePermutation(String str){
        Map<Character, Integer> mp = new HashMap<>();
        for(int i=0;i<str.length();i++){
            if((str.charAt(i)>='A' && str.charAt(i)<'Z')||(str.charAt(i)>='a' && str.charAt(i)<'z')){
                int v = 0;
                if(mp.getOrDefault(str.charAt(i),0)>0){
                    v = mp.getOrDefault(str.charAt(i),0)-1;
                }else{
                    v = mp.getOrDefault(str.charAt(i),0)+1;
                }
                mp.put(str.charAt(i),v);
            }
        }
        int count = 0;
        for(Character key: mp.keySet()){
            count += mp.get(key);
        }
        return count<=1;
    }

    static boolean isPermutationOfPalindrome(String phrase){
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }
    static boolean checkMaxOneOdd(int[] table){
        boolean foundOdd = false;
        for(int count:table){
            if(count%2==1){
                if(foundOdd){
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }
    static int getCharNumber(Character c){
//        int a = Character.getNumericValue('A');
//        int z = Character.getNumericValue('Z');
//        or
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(a<=val && val<=z){
            return val - a;
        }
        return -1;
    }
    static int[] buildCharFrequencyTable(String phrase){
        int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
        for(char c: phrase.toCharArray()){
            int x = getCharNumber(c);
            if(x!=-1){
                table[x]++;
            }
        }
        return table;
    }
    public static void main(String[] args){
        System.out.println(isPermutationOfPalindrome("Tact coa"));
    }
}
