package com.nextswe.prep.leetcode.april30;

public class Apr9_P155 {
    class Node{
        int val;
        int min;
    }
    Node[] stackOfNode;
    int top;

    /** initialize your data structure here. */
    public Apr9_P155() {
        stackOfNode = new Node[1000];
        top = -1;
    }

    public void push(int x) {
        if(top==(1000-1)){
            return;
        }
        Node node = new Node();
        node.val = x;
        if(top>=0){
            Node tmp = stackOfNode[top];
            node.min = Math.min(tmp.min, x);
        }else{
            node.min = x;
        }
        top++;
        stackOfNode[top] = node;
    }

    public void pop() {
        if(top==-1){
            return;
        }
        top--;
    }

    public int top() {
        return stackOfNode[top].val;
    }

    public int getMin() {
        return stackOfNode[top].min;
    }
}
