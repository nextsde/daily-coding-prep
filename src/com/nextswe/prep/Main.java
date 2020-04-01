package com.nextswe.prep;

import com.nextswe.prep.sorts.BasicSort;

public class Main {
    public static void main(String[] args) {
        int A[] = new int[]{10,7,8,9,1,5};
        BasicSort.mergesort(A);
        BasicSort.printArray(A);
    }
}
