package com.nextswe.prep.ds_goodrich.chapter13;


import java.util.*;

class TreeNode {
    public char val;
    public int freq;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(char x,int f) { val = x; freq = f;}
    public TreeNode(char x) { val = x; freq = 0;}
    public TreeNode(int f) { freq = f;}
}

public class HuffmanCoding {
    public static TreeNode getHuffmanTree(String text){
        Map<Character, Integer> freqMap = new HashMap<>();
        PriorityQueue<TreeNode> pq = new PriorityQueue<>(new Comparator<TreeNode>(){
            public int compare(TreeNode o1, TreeNode o2){
                return o1.freq - o2.freq;
            }
        });
        for(char cc: text.toCharArray()){
            freqMap.put(cc,freqMap.getOrDefault(cc,0)+1);
        }
        Iterator<Character> itr = freqMap.keySet().iterator();
        while(itr.hasNext()){
            char cc = itr.next();
            TreeNode node = new TreeNode(cc,freqMap.getOrDefault(cc,0));
            pq.add(node);
        }
        while(pq.size()>1){
            TreeNode e1 = pq.remove();
            TreeNode e2 = pq.remove();
            TreeNode newNode = new TreeNode('-',e1.freq+e2.freq);
            newNode.left = e1;
            newNode.right = e2;
            pq.add(newNode);
        }
        return pq.remove();
    }

    public static void printCode(TreeNode root,String bin){
        if(root.left==null && root.right==null && Character.isLetter(root.val)){
            System.out.println(root.val+" : "+bin);
            return;
        }
        printCode(root.left,bin+"0");
        printCode(root.right,bin+"1");
    }
    public static void main(String[] args){
        String message = "BCCABBDDAECCBBAEDDCC";
        TreeNode root = getHuffmanTree(message);
        printCode(root,"");
    }
}
