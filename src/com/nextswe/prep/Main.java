package com.nextswe.prep;

import com.nextswe.prep.leetcode.april30.P202;

public class Main {
    public static void main(String[] args) {
        int A[] = new int[]{10,7,8,9,1,5};
//        BasicSort.qsort(A);
//        SKHeap.heap_sort_by_extract_min(A);
//        Utils.printArray(A);
        P202 p202 = new P202();
        System.out.println(p202.isHappy(1234));
    }
}
