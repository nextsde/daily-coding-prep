package com.nextswe.prep.ds_goodrich.chapter6;

import java.util.Arrays;

/* Implementation of the deque ADT using a fixed-length array. */
public class ArrayDeque<E> implements Deque<E>{
    public static final int CAPACITY = 10;

    //instance variables
    private E[] data;
    private int front = 0;
    private int back = 0;
    private int size = 0;

    public ArrayDeque(){ this(CAPACITY); }
    public ArrayDeque(int capacity){ data = (E[])new Object[capacity];}

    //methods
    /*
        Returns the number of elements in the queue
    */
    public int size(){ return size; }

    /*
        Tests whether the queue is empty or not
    */
    public boolean isEmpty(){ return size == 0;}


    /*
        Insert an element at the back by calculating mod of (front+size)%length of array.
        And update the size by incrementing.
    */
    public void addLast(E e) throws IllegalStateException{
        if(size == data.length) throw new IllegalStateException("Deque is full");
        back = back%data.length;
        data[back] = e;
        size++;
    }

    /*
        Insert an element at the front by calculating mod of (front-1+length)%length of array.
        And update the size by incrementing
     */
    public void addFirst(E e) throws IllegalStateException{
        if(size == data.length) throw new IllegalStateException("Deque is full");
        if(isEmpty()){
            data[front] = e;
        }else{
            front = (front - 1 + data.length) % data.length;
            data[front] = e;
        }
        size++;
    }

    /*
        Returns the first element from the front without removing it
    */
    public E first(){ return isEmpty()?null:data[front]; }

    /*
        Returns the last element from the back without removing it
     */
    public E last(){ return isEmpty()?null:data[back]; }

    /*
        Returns and removes the first element from the front of deque
     */
    public E removeFirst(){
        if(isEmpty())return null;
        E answer = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size--;
        return answer;
    }

    /*
        Returns and removes the last element from the back of deque
     */
    public E removeLast(){
        if(isEmpty())return null;
        E answer = data[back];
        data[back] = null;
        back = (back - 1 + data.length) % data.length;
        size--;
        return answer;
    }

    public String toString(){
        return Arrays.toString(data);
    }
}
