package com.nextswe.prep.ds_goodrich.chapter6;

/* Implementation of the queue ADT using a fixed-length array. */
public class ArrayQueue<E> implements Queue<E>{
    public static final int CAPACITY = 1000;

    //instance variables
    private E[] data;
    private int front;
    private int sz;

    public ArrayQueue(){ this(CAPACITY); }
    public ArrayQueue(int capacity){ data = (E[])new Object[capacity];}

    //methods
    /*
        Returns the number of elements in the queue
    */
    public int size(){ return sz; }

    /*
        Tests whether the queue is empty or not
    */
    public boolean isEmpty(){ return sz == 0;}


    /*
        Insert an element at the back by calculating mod of (front+size)%length of array.
        And update the size by incrementing.
    */
    public void enqueue(E e) throws IllegalStateException{
        if(sz == data.length) throw new IllegalStateException("Queue is full");
        int back = (front+sz)%data.length;
        data[back] = e;
        sz++;
    }

    /*
        Returns the first element from the front without removing it
    */
    public E first(){ return isEmpty()?null:data[front]; }

    public E dequeue(){
        if(isEmpty())return null;
        E answer = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        sz--;
        return answer;
    }
}
