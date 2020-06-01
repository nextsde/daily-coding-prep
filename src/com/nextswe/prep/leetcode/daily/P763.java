package com.nextswe.prep.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

public class P763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> lst = new ArrayList<>();
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;
        int i = 0;
        while(i<S.length()){
            int ip = i;
            int ep = last[S.charAt(i) - 'a'];
            for(int j=ip+1;j<ep;j++){
                if(last[S.charAt(j) - 'a']>ep){
                    ep = last[S.charAt(j) - 'a'];
                }
            }
            lst.add((ep-ip)+1);
            i = ep + 1;
        }
        return lst;
    }
}
