package com.nextswe.prep.leetcode.daily;

public class P938 {
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //solution 4
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null){
            return 0;
        }
        return (root.val>=L?rangeSumBST(root.left,L,R):0)+(root.val>=L && root.val<=R?root.val:0)+(root.val<=R?rangeSumBST(root.right,L,R):0);
    }

    //solution 3
/*
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null){
            return 0;
        }
        return rangeSumBST(root.left,L,R)+(root.val>=L && root.val<=R?root.val:0)+rangeSumBST(root.right,L,R);
    }
*/

    //solution 2
/*
    public void InOrderDFS(TreeNode root, int L, int R){
        if(root == null){
            return;
        }
        if(root.val>=L){
            InOrderDFS(root.left,L,R);
        }
        if(L<=root.val && root.val<=R){
            totalSum += root.val;
        }
        if(root.val<=R){
            InOrderDFS(root.right,L,R);
        }
    }

    public int totalSum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        totalSum = 0;
        InOrderDFS(root,L,R);
        return totalSum;
    }
*/

    //solution 1
/*
    public void InOrderDFS(TreeNode root, int L, int R){
        if(root == null){
            return;
        }
        InOrderDFS(root.left,L,R);
        if(L<=root.val && root.val<=R){
            totalSum += root.val;
        }
        InOrderDFS(root.right,L,R);
    }

    public int totalSum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        totalSum = 0;
        InOrderDFS(root,L,R);
        return totalSum;
    }
*/
}
