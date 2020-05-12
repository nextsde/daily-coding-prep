package com.nextswe.prep.leetcode.daily;

import java.util.*;

public class P1305 {

    public void inOrder(TreeNode root,List<Integer> list1) {
        if(root==null){
            return;
        }
        inOrder(root.left, list1);
        list1.add(root.val);
        inOrder(root.right, list1);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1  = new ArrayList<>();
        List<Integer> list2  = new ArrayList<>();
        inOrder(root1,list1);
        inOrder(root1,list2);
        List<Integer> finalList = new ArrayList<>();
        int i = 0,j=0;
        int l1 = list1.size();
        int l2 = list2.size();
        while(i+j<l1+l2){
            if(j==l2 || (i<l1 && list1.get(i)<list2.get(j))){
                finalList.add(list1.get(i));
                i++;
            }else{
                finalList.add(list2.get(j));
                j++;
            }
        }
        return finalList;
    }

/*
    public void inOrder(TreeNode root, PriorityQueue<Integer> pq) {
        if(root==null){
            return;
        }
        inOrder(root.left, pq);
        pq.add(root.val);
        inOrder(root.right, pq);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer x, Integer y) {
                return (x < y) ? -1 : ((x == y) ? 0 : 1);
            }
        });


        inOrder(root1,minHeap);
        inOrder(root2,minHeap);

        List<Integer> finalList = new ArrayList<>();
        while(minHeap.size()>0) {
            finalList.add(minHeap.poll());
        }
        return finalList;
    }
*/

    public static void main(String[] args){

    }
}
