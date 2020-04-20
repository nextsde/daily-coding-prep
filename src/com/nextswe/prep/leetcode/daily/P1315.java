package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.leetcode.helpers.TreeNode;

public class P1315 {
    //my solution
/*
    public int sumEvenGrandparent(TreeNode cur, TreeNode pp, TreeNode gp) {
        if(cur==null){
            return 0;
        }
        int left = sumEvenGrandparent(cur.left,cur,pp);
        int right = sumEvenGrandparent(cur.right,cur,pp);
        if(gp!=null && gp.val%2==0){
            return left+right+cur.val;
        }else{
            return left+right;
        }
    }
    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root,null,null);
    }
*/
    //adjusted
    public int sumEvenGrandparent(TreeNode cur, int pp, int gp) {
        if(cur==null){
            return 0;
        }
        int left = sumEvenGrandparent(cur.left,cur.val,pp);
        int right = sumEvenGrandparent(cur.right,cur.val,pp);
        if(gp%2==0){
            return left+right+cur.val;
        }else{
            return left+right;
        }
    }
    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root,1,1);
    }
}
