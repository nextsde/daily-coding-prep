package com.nextswe.prep.ds_goodrich.chapter3;

public class SinglyLinkedList<E> {
    private static class Node<E>{
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n){ element = e; next = n; }
        public E getElement(){ return element; }
        public Node<E> getNext(){ return next; }
        public void setNext(Node<E> n){ next = n; }
    }

    private Node<E> head, tail;
    private int size = 0;
    public SinglyLinkedList(){ }
    public int size(){ return size; }
    public boolean isEmpty(){ return size==0; }
    public E first(){
        if(isEmpty()) return null;
        return head.getElement();
    }
    public E last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }
    public void add(E e){
        addLast(e);
    }
    public void addFirst(E e){
        head = new Node<>(e, head);
        if(size==0){ tail=head; }
        size++;
    }
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if(isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }
    public void addAt(E e, int p){
        if(p > size || p<0){
            throw new IllegalArgumentException("Invalid position. Give a position between 0 and "+(size-1));
        }
        if(head==null || p==0){
            addFirst(e);
        }else{
            Node<E> temp = head;
            int i = p-1;
            while(i>0){
                temp = temp.getNext();
                i--;
            }
            Node<E> newest = new Node<>(e,null);
            newest.setNext(temp.getNext());
            temp.setNext(newest);
            size++;
        }
    }
    public E removeAt(int p){
        if(p>size || p<0){
            throw new IllegalArgumentException("Invalid position. Give a position between 0 and "+(size-1));
        }
        if(p==0){
            return removeFirst();
        }else{
            Node<E> temp1 = head;
            int i = p-1;
            while(i>0){
                temp1 = temp1.getNext();
                i--;
            }
            Node<E> temp2 = temp1.getNext();
            temp1.setNext(temp2.getNext());
            E answer = temp2.getElement();
            temp2 = null;
            size--;
            if(size==0)
                tail = null;
            return answer;
        }
    }

    public E removeFirst(){
        if(isEmpty())return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size==0)
            tail = null;
        return answer;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> temp = head;
        while(temp!=null){
            sb.append("["+temp.getElement()+"]");
            temp=temp.next;
        }
        return sb.toString();
    }
}
