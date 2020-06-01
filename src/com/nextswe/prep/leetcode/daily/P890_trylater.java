package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P890_trylater {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        int[] arr = new int[pattern.length()];
        int i = 0;
        int j = 0;
        while (j < pattern.length()) {
            arr[i] = (pattern.charAt(j) - pattern.charAt(0) ) + 1;
            i++;
            j++;
        }
        System.out.println(Arrays.toString(arr));
        int x = 0;
        for(String str: words){
            if(str.length()==pattern.length()){
                int k = 0;
                boolean match = true;
                System.out.print( str+ "\n ");
                while(k<str.length()){
                    x = (str.charAt(k)-str.charAt(0))+1;
                    System.out.print( x+ " ");
                    if(arr[k]!= ((str.charAt(k)-str.charAt(0))+1)){
                        match = false;
                        break;
                    }
                    k++;
                }
                System.out.println();
                if(match){
                    list.add(str);
                }
            }
        }
        return list;
    }

    public static void main(String[] args){
        P890_trylater mP890 = new P890_trylater();
        Utils.printListString(mP890.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
//        String pattern = "abb";
//        int[] arr = new int[pattern.length()];
//        int i = 0;
//        int j = 0;
//        while(j<pattern.length()){
//            arr[i++] = (pattern.charAt(j++)-'a')+1;
//        }
//        System.out.println(Arrays.toString(arr));
    }
}
