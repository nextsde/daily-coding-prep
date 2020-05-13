package com.nextswe.prep.ds_goodrich.chapter13;

//https://www.youtube.com/watch?v=4Xyhb72LCX4
//https://www.youtube.com/watch?v=Wj606N0IAsw
//https://www.youtube.com/watch?v=CT1lQN73UMs

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {
    //https://www.youtube.com/watch?v=3Ft3HMizsCk
    //https://www.youtube.com/watch?v=Tbj8iH9UkSA
    public static int subStringMatch(String text, String pattern){
        //build a bad match table
        Map<Character,Integer> badCharacterTable = new HashMap<Character,Integer>();
        for(int i=0;i<pattern.length();i++){
            char cc = pattern.charAt(i);
            int shift = Math.max(1, pattern.length()-i-1);
            badCharacterTable.put(cc,shift);
        }
        int skip = 0;
        for(int i=0;i<=text.length()-pattern.length();i+=skip){
            skip = 0;
            for(int j=pattern.length()-1;j>=0;j--){
                if(pattern.charAt(j)!=text.charAt(i+j)){
                    if(badCharacterTable.containsKey(text.charAt(i+j))){
                        skip = badCharacterTable.get(text.charAt(i+j));
                        break;
                    }else{
                        skip = pattern.length();
                        break;
                    }
                }
            }
            if(skip==0) return i;
        }
        return -1;
    }

    public static int findBoyerMoore(char[] text, char[] pattern){
        int n = text.length;
        int m = pattern.length;
        if(m==0) return 0;
        Map<Character,Integer> last = new HashMap<>();
        for(int i=0;i<n;i++){
            last.put(text[i],-1); // set −1 as default for all text characters
        }
        for(int k=0;k<m;k++){
            last.put(pattern[k],k); // rightmost occurrence in pattern is last
        }
        int i = m-1;
        int k = m-1;
        while(i<n){
            if(text[i]==pattern[k]){ // a matching character
                if(k==0) return i; // entire pattern has been found
                i--; // otherwise, examine previous
                k--; // characters of text/pattern
            }else{
                i += m - Math.min(k, 1+last.get(text[i])); // case analysis for jump step
                k = m-1;  // restart at end of pattern
            }
        }
        return -1; // pattern was never found
    }

    public static void main(String[] args){
        System.out.println(subStringMatch(
                "In applying this technique to design a brute-force pattern-matching algorithm",
                "technique"
        ));

        System.out.println(findBoyerMoore(
                "In applying this technique to design a brute-force pattern-matching algorithm".toCharArray(),
                "technique".toCharArray()
        ));
    }
}
