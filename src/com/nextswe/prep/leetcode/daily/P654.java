package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.leetcode.helpers.TreeNode;

public class P654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null || nums.length==0){
            return null;
        }
        int n = nums.length;
        int mid = 0;
        int maxVal = nums[mid];
        for(int i=0;i<nums.length;i++){
            if(maxVal<nums[i]){
                maxVal = nums[i];
                mid = i;
            }
        }

        int leftSize = mid;
        int rightSize = n-(mid+1);

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        for(int i=0;i<left.length;i++){
            left[i] = nums[i];
        }
        for(int j=mid+1;j<n;j++){
            right[j-(mid+1)] = nums[j];
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);
        return root;
    }

    public static void main(String[] args){

    }
}
