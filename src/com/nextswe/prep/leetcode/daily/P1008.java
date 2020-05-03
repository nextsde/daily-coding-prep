package com.nextswe.prep.leetcode.daily;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}

public class P1008 {
    public TreeNode bstFromPreorder(int[] nums, int start, int end) {
        if(start>end) return null;
        TreeNode root = new TreeNode(nums[start]);
        int left_end = start+1;
        while(nums.length>left_end && nums[left_end]<=root.val) left_end++;
        left_end--;
        root.left = bstFromPreorder(nums, start+1, left_end);
        root.right = bstFromPreorder(nums, left_end+1, end);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,0,preorder.length-1);
    }

    public static void main(String[] args){
        P1008 mP1008 = new P1008();
        mP1008.bstFromPreorder(new int[]{8,5,1,7,10,12});
    }
}
