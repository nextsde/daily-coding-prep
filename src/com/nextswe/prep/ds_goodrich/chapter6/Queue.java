package com.nextswe.prep.ds_goodrich.chapter6;

/*
    Queue ADT interface. FIFO data structure used for collection of objects.
*/
public interface Queue<E> {
    /*
     Returns the number of elements in the queue.
     @return number of elements in the queue
     */
    int size();
    /*
     Tests whether the queue is empty.
     @return true of the queue is empty, false otherwise
     */
    boolean isEmpty();
    /*
     Insert an element at the rear of the queue.
     @param e the element to be inserted
     */
    void enqueue(E e);
    /*
     Returns but does not remove, the first element of the queue (null if empty).
     @return the elements at the front of the queue without removing it
     */
    E first();
    /*
     Removes and returns the first element of the queue (null if empty).
     @return and remove the elements at the front of the queue
    */
    E dequeue();
}
