package com.nextswe.prep.ds_goodrich.chapter3;

public class SinglyLinkedList<E> implements Cloneable{
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

    public int hashCode(){
        int h = 0;
        for(Node walk=head; walk!=null; walk = walk.getNext()){
            h ^= walk.getElement().hashCode(); // bitwise exclusive-or with element’s code
            h = (h<<5)|(h>>>27); // 5-bit cyclic shift of composite code
        }
        return h;
    }

    public boolean equals(Object o){
        if(o==null)return false;
        if(getClass()!=o.getClass())return false;
        SinglyLinkedList other = (SinglyLinkedList)o;
        if(size!=other.size)return false;
        Node walkA =  head;
        Node walkB = other.head;
        while(walkA!=null){
            if(!walkA.getElement().equals(walkB.getElement()))return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;
    }

    public SinglyLinkedList<E> clone() throws CloneNotSupportedException{
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
        if(size>0){
            other.head = new Node<E>(head.getElement(),null);
            Node<E> walk = head.getNext();
            Node<E> otherTail = other.head;
            while(walk!=null){
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);
                otherTail = newest;
                walk = walk.getNext();
            }
        }
        return other;
    }
}
