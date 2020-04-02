package com.nextswe.prep;

import com.nextswe.prep.skiena.chapter4.SKHeap;
import com.nextswe.prep.sorts.BasicSort;
import com.nextswe.prep.utils.Utils;

public class Main {
    public static void main(String[] args) {
        int A[] = new int[]{10,7,8,9,1,5};
//        BasicSort.qsort(A);
        SKHeap.heap_sort_by_extract_min(A);
        Utils.printArray(A);
    }
}
