package com.nextswe.prep.leetcode.daily;

import java.util.List;

public class P1104 {
    static int log(int x, int base)
    {
        return (int) (Math.log(x) / Math.log(base));
    }
    public List<Integer> pathInZigZagTree(int label) {
        int depth = log(label,2);
        int level = depth + 1;
        int nodes = (int)Math.pow(2,depth);
        System.out.println("node:"+label +" is at level:"+level+" where it's depth:"+depth+" where we have "+nodes+" nodes");
        if(level%2==0){
            //right to left
        }else{
            //left to right
        }
        return null;
    }

    public static void main(String[] args){
        P1104 mP1104 = new P1104();
        mP1104.pathInZigZagTree(7);
    }
}
