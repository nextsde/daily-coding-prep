package com.nextswe.prep.ds_goodrich.chapter13;

//https://www.youtube.com/watch?v=GTJr8OvyEVQ
//https://www.youtube.com/watch?v=KG44VoDtsAA
//https://www.youtube.com/watch?v=V5-7GzOfADQ
public class KMPSearch {
    public static int[] patternPrefixSuffixTable(String pattern){
        int[] table = new int[pattern.length()];
        int i=0, j = 0;
        table[i++] = 0;
        while(i<pattern.length()){
            if(pattern.charAt(j)!=pattern.charAt(i)){
                if(j>0) {
                    j = table[j-1];
                }else{
                    table[i++] = 0;
                }
            }else{
                table[i++] = j+1;
                j = j+1;
            }
        }
        return table;
    }

    public static int kmpSearch(String text, String pattern){
        int[] lps = patternPrefixSuffixTable(pattern);
        int i=0, j = 0;
        while(i<text.length()){
            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }else{
                if(j!=0) {
                    j = lps[j - 1];
                }else{
                    i++;
                }
            }
            if(j==pattern.length()){
                return i-pattern.length();
            }
        }
        return -1;
    }


    /*
    Returns the lowest index at which substring pattern begins in text (or else −1)
     */
    public static int findKMP(String text, String pattern){
        int n = text.length();
        int m = pattern.length();
        if(m==0) return 0; // trivial search for empty string
        int[] lps = computeFailKMP(pattern); // computed by private utility
        int j = 0; // index into text
        int k = 0; // index into pattern
        while(j<n){
            if(text.charAt(j)==pattern.charAt(k)){ // pattern[0..k] matched thus far
                if(k==m-1) return j-m+1; // match is complete
                j++; // otherwise, try to extend match
                k++;
            }else if(k>0){
                k = lps[k-1]; // reuse suffix of P[0..k-1]
            }else{
                j++;
            }
        }
        return -1; // reached end without match
    }

    private static int[] computeFailKMP(String pattern){
        int m = pattern.length();
        int[] fail = new int[m];
        int j = 1;
        int k = 0;
        while(j<m){
            if(pattern.charAt(j) == pattern.charAt(k)){
                fail[j] = k+1;
                j++;
                k++;
            }else if(k>0){
                k = fail[k-1];
            }else{
                j++;
            }
        }
        return fail;
    }

    public static void main(String[] args){
        System.out.println(kmpSearch(
                "In applying this technique to design a brute-force pattern-matching algorithm",
                "technique"
        ));

//        System.out.println(Arrays.toString(patternPrefixSuffixTable("abcdabeabf")));
//        System.out.println(Arrays.toString(patternPrefixSuffixTable("aabcadaabe")));
//        System.out.println(Arrays.toString(patternPrefixSuffixTable("abcdabca")));
//        System.out.println(Arrays.toString(patternPrefixSuffixTable("acacabacacabacacac")));
    }
}
