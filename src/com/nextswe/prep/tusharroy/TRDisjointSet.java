package com.nextswe.prep.tusharroy;

import java.util.HashMap;
import java.util.Map;

/**
 * Video link by tusroy - https://youtu.be/ID00PMy0-vE
 */
//main source code can be found:
//https://github.com/mission-peace/interview/tree/master/src/com/interview/graph
//https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/DisjointSet.java
public class TRDisjointSet<T extends Comparable<T>> {
    private Map<T, Node<T>> map = new HashMap<>();

    class Node<T>{
        T data;
        Node<T> parent;
        int rank;
    }

    public void makeSet(T data){
        Node<T> node = new Node<>();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }

    public boolean union(T data1, T data2){
        Node<T> node1 = map.get(data1);
        Node<T> node2 = map.get(data2);

        Node<T> parent1 = findSet(node1);
        Node<T> parent2 = findSet(node2);
        //equals will only work for primitive type
        //for objects we need to objects that are comparable and will call equals
        if(parent1.equals(parent2.data)){
            return false;
        }

        if(parent1.rank>=parent2.rank){
            parent1.rank = (parent1.rank==parent2.rank)?parent1.rank+1:parent1.rank;
            parent2.parent = parent1;
        }else{
            parent1.parent = parent2;
        }
        return true;
    }

    public T findSet(T data){
        return findSet(map.get(data)).data;
    }

    private Node<T> findSet(Node<T> node){
        if(node == node.parent){
            return node.parent;
        }
        //path compression
        return node.parent = findSet(node.parent);
    }

    public static void main(String[] args){
        TRDisjointSet<Integer> trDisjointSet = new TRDisjointSet<>();

        trDisjointSet.makeSet(1);
        trDisjointSet.makeSet(2);
        trDisjointSet.makeSet(3);
        trDisjointSet.makeSet(4);
        trDisjointSet.makeSet(5);
        trDisjointSet.makeSet(6);
        trDisjointSet.makeSet(7);

        trDisjointSet.union(1, 2);
        trDisjointSet.union(2, 3);
        trDisjointSet.union(4, 5);


        System.out.println("1 in set: "+trDisjointSet.findSet(1)+" ");
        System.out.println("2 in set: "+trDisjointSet.findSet(2)+" ");
        System.out.println("3 in set: "+trDisjointSet.findSet(3)+" ");
        System.out.println("4 in set: "+trDisjointSet.findSet(4)+" ");
        System.out.println("5 in set: "+trDisjointSet.findSet(5)+" ");
        System.out.println("6 in set: "+trDisjointSet.findSet(6)+" ");
        System.out.println("7 in set: "+trDisjointSet.findSet(7)+" ");
        System.out.println();

        trDisjointSet.union(6, 7);
        trDisjointSet.union(5, 6);
        trDisjointSet.union(3, 7);

        System.out.println("1 in set: "+trDisjointSet.findSet(1)+" ");
        System.out.println("2 in set: "+trDisjointSet.findSet(2)+" ");
        System.out.println("3 in set: "+trDisjointSet.findSet(3)+" ");
        System.out.println("4 in set: "+trDisjointSet.findSet(4)+" ");
        System.out.println("5 in set: "+trDisjointSet.findSet(5)+" ");
        System.out.println("6 in set: "+trDisjointSet.findSet(6)+" ");
        System.out.println("7 in set: "+trDisjointSet.findSet(7)+" ");
        System.out.println();
    }
}
