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
