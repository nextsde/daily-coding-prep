package com.nextswe.prep.ctci.chapter1;

import java.util.HashMap;
import java.util.Map;

public class Chapter1_4 {
    /*
    Question: Given a string, write a function to check if it is a permutation of a palindrome.
    A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a
    rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

    DON'T START WRITING CODE:

    Understand the question well.
    Input:  Tact Coa
    Output: True(Permutations: "taco cat", "atco cta", etc)

    Ask or Clarify:
    Is it going to be case sensitive?
    What about special characters? Should they be ignored?

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
    //my approach
    static boolean isPalindromePermutation(String str){
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<str.length();i++){
            int x = getCharNumber(str.charAt(i));
            if(x!=-1){
                int v = 0;
                if(mp.getOrDefault(x,0)>0){
                    v = mp.getOrDefault(x,0)-1;
                }else{
                    v = mp.getOrDefault(x,0)+1;
                }
                mp.put(x,v);
            }
        }
        int count = 0;
        for(Integer key: mp.keySet()){
            count += mp.get(key);
        }
        return count<=1;
    }
    //solution 1
    static boolean isPermutationOfPalindrome1(String phrase){
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

    //solution 2
    static boolean isPermutationOfPalindrome2(String phrase){
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
        for(char c: phrase.toCharArray()){
            int x = getCharNumber(c);
            if(x!=-1){
                table[x]++;
                if(table[x]%2==1){
                    countOdd++;
                }else{
                    countOdd--;
                }
            }
        }
        return countOdd<=1;
    }

    //solution 3
    static boolean isPermutationOfPalindrome3(String phrase){
        int bitVector = createBitVector(phrase);
        return bitVector==0||checkExactlyOneBitSet(bitVector);
    }

    static int createBitVector(String phrase){
        int bitVector = 0;
        for(char c:phrase.toCharArray()){
            int x = getCharNumber(c);
            bitVector = toggle(bitVector,x);
        }
        return bitVector;
    }

    static int toggle (int bitVector, int index){
        if(index<0) return bitVector;
        int mask = 1<<index;
        if((bitVector & mask)==0){
            bitVector |= mask;
        }else{
            bitVector &= ~mask;
        }
        return bitVector;
    }

    static boolean checkExactlyOneBitSet(int bitVector){
        return (bitVector & (bitVector-1))==0;
    }


    public static void main(String[] args){
        System.out.println(isPalindromePermutation("Tact coa"));
    }
}
