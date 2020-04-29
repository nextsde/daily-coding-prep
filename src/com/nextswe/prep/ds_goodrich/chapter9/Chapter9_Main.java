package com.nextswe.prep.ds_goodrich.chapter9;

import com.nextswe.prep.ds_goodrich.chapter7.PositionalList;

public class Chapter9_Main {
    public static <E> void pqSort(PositionalList<E> S, PriorityQueue<E,?> P){
        int n = S.size();
        for(int j=0;j<n;j++){
            E element = S.remove(S.first());
            P.insert(element,null);
        }
        for(int j=0;j<n;j++){
            E element = P.removeMin().getKey();
            S.addLast(element);
        }
    }
}
