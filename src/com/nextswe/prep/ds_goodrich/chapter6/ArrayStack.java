package com.nextswe.prep.ds_goodrich.chapter6;

public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int top = -1;
    public ArrayStack(){this(CAPACITY);}
    public ArrayStack(int capacity){
        data = (E[]) new Object[capacity];
    }
    public int size(){return top+1;}
    public boolean isEmpty(){return top==-1;}
    public void push(E e) throws IllegalStateException{
        if(size()==data.length)throw new IllegalStateException("Stack is full");
        data[++top] = e;
    }
    public E top(){return isEmpty()?null:data[top];}
    public E pop(){
        if(isEmpty())return null;
        E answer = data[top];
        data[top] = null;
        top--;
        return answer;
    }
}
