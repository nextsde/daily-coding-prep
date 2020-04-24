package com.nextswe.prep.leetcode.daily;

public class P1379 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public final TreeNode getTargetCopy(final TreeNode cloned, final TreeNode target) {
        if(cloned==null){
            return null;
        }
        if(cloned.val == target.val){
            return cloned;
        }
        TreeNode left = getTargetCopy(cloned.left,target);
        TreeNode right = getTargetCopy(cloned.right,target);
        return left!=null?left:right;
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return getTargetCopy(cloned,target);
    }

    public static void main(){

    }
}
