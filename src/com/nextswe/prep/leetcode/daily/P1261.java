package com.nextswe.prep.leetcode.daily;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {
    TreeNode treeRoot;
    Set<Integer> values = new HashSet<>();
    public void dfs(TreeNode treeNode, int x){
        values.add(x);
        if(treeNode.left != null){
            treeNode.left.val = 2 * x + 1;
            dfs(treeNode.left,treeNode.left.val);
        }
        if(treeNode.right != null){
            treeNode.right.val = 2 * x + 2;
            dfs(treeNode.right,treeNode.right.val);
        }
    }

    public FindElements(TreeNode root) {
        this.treeRoot = root;
        this.treeRoot.val = 0;
        dfs(this.treeRoot, this.treeRoot.val);
    }

    public boolean find(int target) {
        return values.contains(target);
    }
}

/*
class FindElements {
    TreeNode treeRoot;
    public void fixBinaryTree(TreeNode treeNode, int x){
        if(treeNode.left != null){
            treeNode.left.val = 2 * x + 1;
            fixBinaryTree(treeNode.left,treeNode.left.val);
        }
        if(treeNode.right != null){
            treeNode.right.val = 2 * x + 2;
            fixBinaryTree(treeNode.right,treeNode.right.val);
        }
    }

    public FindElements(TreeNode root) {
        this.treeRoot = root;
        this.treeRoot.val = 0;
        fixBinaryTree(this.treeRoot, this.treeRoot.val);
    }

    public boolean find(int target) {
        return find(treeRoot,target);
    }
    private boolean find(TreeNode treeNode, int target) {
        if(treeNode==null){
            return false;
        }
        if(treeNode.val == target){
            return true;
        }

        return find(treeNode.left, target) || find(treeNode.right, target);
    }
}
*/

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */

public class P1261 {


}
