package com.nextswe.prep.leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class P451 {
    public String frequencySort(String s) {
        Map<Character, Integer> fmap = new HashMap<>();
        for(int i=0;i<s.length();i++){//O(n)
            fmap.put(s.charAt(i),fmap.getOrDefault(s.charAt(i),0)+1);
        }
        int[][] farr = new int[fmap.size()][2];
        Iterator<Map.Entry<Character,Integer>> itr = fmap.entrySet().iterator();
        int k = 0;
        while(itr.hasNext()){//O(k)
            Map.Entry<Character,Integer> entry = itr.next();
            farr[k][0] = entry.getKey();
            farr[k][1] = entry.getValue();
            k++;
        }
        Arrays.sort(farr, (a,b)->b[1]-a[1]);//klogk
        StringBuilder str = new StringBuilder();
        for(int[] p: farr){//O(k)
            int a = p[1];
            while(a>0){
                str.append((char)p[0]);
                a--;
            }
        }
        //O(n+klogk)
        return str.toString();
    }

    public static void main(String[] args){
        P451 mP451 = new P451();
        System.out.println(mP451.frequencySort("tree"));
    }
}
