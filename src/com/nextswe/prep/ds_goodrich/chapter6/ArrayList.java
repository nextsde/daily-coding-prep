package com.nextswe.prep.ds_goodrich.chapter6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
    //instance variables
    public static final int CAPACITY = 16; //default array capacity

    private E[] data; //generic array used for storage

    private int size = 0; //current number of elements

    //constructors
    public ArrayList(){this(CAPACITY);} //constructs list with default capacity

    public ArrayList(int capacity){ //constructs list with given capacity
        data = (E[]) new Object[capacity]; //safe cast; compiler may give warning
    }

    //public methods
    /*
        Returns the number of elements in the list.
     */
    public int size(){return size;}
    /*
        Returns whether the list is empty or not
     */
    public boolean isEmpty(){return size==0;}
    /*
        Returns (but does not remove) the element at index i
     */
    public E get(int i) throws IndexOutOfBoundsException{
        checkIndex(i,size);
        return data[i];
    }
    /*
        Replaces the element at index i with e, and returns the replaced element
     */
    public E set(int i, E e) throws IndexOutOfBoundsException{
        checkIndex(i,size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }
    /*
        Inserts element e to be at index i, shifting all subsequent elements later
     */
    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException{
        checkIndex(i,size+1);
        if(size==data.length){ //not enough capacity
            // throw new IllegalStateException("Array is full");
            // dynamic array
            resize(2*data.length);
        }
        for(int k = size-1;k>=i;k--){ //shift all the element to the right including i = k'th element
            data[k+1] = data[k];
        }
        data[i] = e;
        size++;
    }
    /*
        Removes/returns the element at index i, shifting subsequent elements earlier
     */
    public E remove(int i) throws IndexOutOfBoundsException{
        checkIndex(i,size);
        E temp = data[i];
        for(int k=i;k<size-1;k++){
            data[k] = data[k-1];
        }
        data[size-1] = null;
        size--;
        return temp;
    }

    //utility method
    /*
        Checks whether the given index is in the range [0, n-1]
     */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
        if(i<0 || i>=n)
            throw new IndexOutOfBoundsException("Illegal index: "+i);
    }

    /*
        Resizes internal array to have given capacity >= size
     */
    protected void resize(int capacity){
        E[] temp = (E[]) new Object[capacity];
        for(int k=0;k<size;k++){
            temp[k] = data[k];
        }
        data = temp;
    }

    //nested ArrayIterator class
    /*
    A (nonstatic) inner class. Note well the each instance contains an implicit reference to the
    containing list, allowing it to access the list's members.
     */
    private class ArrayIterator implements Iterator<E> {
        private int j = 0; //index of the next element
        private boolean removable = false; //can remove be called at this time

        /*
        Tests whether the iterator has a next object.
        @return true if there are further objects, false otherwise.
         */
        public boolean hasNext(){
            return j<size;
        }
        /*
        Returns the next object in the iterator.

        @return next object
        @throws NoSuchElementException if there are no further elements
         */
        public E next() throws NoSuchElementException {
            if(j==size) throw new NoSuchElementException("No next element");
            removable = true; //this item can subsequently be removed
            return data[j++];
        }

        /*
        Removes the element returned by the most recent call to next.
        @throws IllegalStateException if next has not yet been called
        @throws IllegalStateException if remove was already called since the recent next
         */
        public void remove() throws IllegalStateException{
            if(!removable) throw new IllegalStateException("nothing to remove");
            ArrayList.this.remove(j-1);
            j--;
            removable = false;
        }
    }

    public Iterator<E> iterator(){
        return new ArrayIterator();
    }
}
