package com.nextswe.prep.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

public class P728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        int n,m;
        for(int j=left;j<=right;j++){
            n = m = j;
            while(n>0){
                if( n%10 == 0 || m%(n%10) !=0 ){
                    break;
                }
                n = n/10;
            }
            if(n==0){
                list.add(m);
            }
        }
        return list;
    }
}
