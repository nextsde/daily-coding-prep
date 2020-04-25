package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.leetcode.helpers.TreeNode;
//try later
public class P1038_trylater {
/*    public TreeNode bstToGst(TreeNode root) {
        if(root==null){
            return null;
        }
        int left = 0;
        int right = 0;
        root.right = bstToGst(root.right);
        if(root.right!=null){
            right = root.val + root.right.val;
//            root.val = root.val + root.right.val;
        }
        root.left = bstToGst(root.left);
        if(root.left!=null){
            left = root.val+root.left.val;
            root.left.val = left;
        }
        root.val = Math.max(left,right)+root.val;
        return root;
    }*/

    public int bstToGstHelper(TreeNode current, int parent) {
        if(current==null){
            return parent;
        }
        current.val = current.val + bstToGstHelper(current.right,parent);
        return bstToGstHelper(current.left,current.val);
    }
    public TreeNode bstToGst(TreeNode root) {
        if(root==null){
            return null;
        }
        bstToGstHelper(root,0);
        return root;
    }

//    public TreeNode bstToGst(TreeNode root) {
//        if(root==null){
//            return null;
//        }
//        int left = 0;
//        int right = 0;
//        root.right = bstToGst(root.right);
//        if(root.right!=null){
//            right = root.val + root.right.val;
////            root.val = root.val + root.right.val;
//        }
//        root.left = bstToGst(root.left);
//        if(root.left!=null){
//            left = root.val+root.left.val;
//            root.left.val = left;
//        }
//        root.val = Math.max(left,right)+root.val;
//        return root;
//    }
    //[4,1,6,0,2,5,8,null,null,null,3,null,null,7,10]
    //[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
}
