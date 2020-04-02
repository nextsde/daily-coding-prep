package com.nextswe.prep.skiena.chapter4;

public class SKPriorityQ {
    public int capacity;
    public int size;
    public int q[];
    public SKPriorityQ(int capacity){
        this.capacity = capacity;
        this.q = new int[this.capacity+1];
        this.size = 0;
    }
}
