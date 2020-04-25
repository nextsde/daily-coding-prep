package com.nextswe.prep.ds_goodrich.chapter6;

/*
Deque(deck) ADT interface
Interface for double ended queue ~ deque(deck):
a collection of elements that can be inserted and removed
at both ends;
 */
public interface Deque<E> {
    /*
    Returns the number of elements in the deque
     */
    int size();
    /*
    Check whether the deque is empty or not
     */
    boolean isEmpty();
    /*
    Returns the first element from the front of the deque(deck) without removing it, (null if empty)
     */
    E first();
    /*
    Return the last element from the back of the deque(deck) without removing it, (null if empty)
     */
    E last();
    /*
    Insert an element at the front of the deque(deck)
     */
    void addFirst(E e);
    /*
    Insert an element at the back of the deque(deck)
     */
    void addLast(E e);
    /*
    Returns and removes the first element from the front of the deque(deck)
     */
    E removeFirst();
    /*
    Returns and removes the last element from the back of the deque(deck)
     */
    E removeLast();
}
