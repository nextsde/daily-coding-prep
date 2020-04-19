package com.nextswe.prep.ds_goodrich.chapter2;

public class Portfolio<T> {
    T[] data;
    public Portfolio(int capacity){
        //data = new T[capacity]; // illegal; compiler error
        data = (T[])new Object[capacity]; // legal, but compiler warning
    }
}
