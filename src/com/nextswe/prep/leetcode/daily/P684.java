package com.nextswe.prep.leetcode.daily;

import java.util.HashSet;
import java.util.Set;

public class P684 {
    private Node[] nodes;
    class Node{
        int data;
        Node parent;
        int rank;
    }
    public void makeSet(int data){
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        nodes[data-1] = node;
    }
    public boolean union(int data1, int data2){
        Node node1 = nodes[data1-1];
        Node node2 = nodes[data2-1];

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        if (parent1.data == parent2.data) {
            return false;
        }

        if(parent1.rank>=parent2.rank){
            if(parent1.rank==parent2.rank){
                parent1.rank = parent1.rank+1;
            }
            parent2.parent = parent1;
        }else{
            parent1.parent = parent2;
        }
        return true;
    }

    public Node findSet(Node node){
        if(node==node.parent){
            return node;
        }
        return node.parent = findSet(node.parent);
    }
    public int[] findRedundantConnection(int[][] edges) {
        nodes = new Node[edges.length];
        for(int i=0;i<edges.length;i++){
            makeSet(i+1);
        }
        for(int[] edge: edges){
            if(!union(edge[0],edge[1])){
                return edge;
            }
        }
        return new int[]{};
    }
}
