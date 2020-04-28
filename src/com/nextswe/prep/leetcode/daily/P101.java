package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.leetcode.helpers.TreeNode;

import java.util.*;

public class P101 {
    //accepted: my solution
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        Queue<TreeNode> qq = new LinkedList<>();
        qq.add(root);

        while(!qq.isEmpty()){
            int size = qq.size();
            for(int i=0;i<size;i++){
                TreeNode node = qq.remove();
                list.add(node.left);
                list.add(node.right);
                if(node.left!=null) {
                    qq.add(node.left);
                }
                if(node.right!=null) {
                    qq.add(node.right);
                }
            }
            for(int i=0,j=list.size()-1;i<list.size() && j>=0;i++,j--){
                if(list.get(i)!=null && list.get(j) != null && list.get(i).val!=list.get(j).val){
                    return false;
                }else if(list.get(i)!=null && list.get(j) == null){
                    return false;
                }else if(list.get(i)==null && list.get(j) != null){
                    return false;
                }
            }
            list.clear();
        }
        return true;
    }
    //others solution:
   /*
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
    */

    //first attempted with in order traversal
    //wasn't working lots of edge cases
    //easier if levelorder is used
/*
    public void inOrderTraversalList(TreeNode root, List<TreeNode> list){
        if(root==null){
            return;
        }
        inOrderTraversalList(root.left,list);
        if(root.left==null && root.right!=null){
            list.add(null);
        }
        list.add(root);
        if(root.right==null && root.left!=null){
            list.add(null);
        }
        inOrderTraversalList(root.right,list);
    }
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        inOrderTraversalList(root,list);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)!=null?list.get(i).val:" n ");
        }
        int i, j;
        for(i=0,j=list.size()-1;i<list.size() && j>=0;i++,j--){
            if(list.get(i)!=null && list.get(j) != null && list.get(i).val!=list.get(j).val){
                return false;
            }else if(list.get(i)!=null && list.get(j) == null){
                return false;
            }else if(list.get(i)==null && list.get(j) != null){
                return false;
            }
        }
        return true;
    }
    */

/*    public void inOrderTraversalList(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        inOrderTraversalList(root.left,list);
        if(root.left==null && root.right!=null){
            list.add(0);
        }
        list.add(root.val);
        if(root.right==null && root.left!=null){
            list.add(0);
        }
        inOrderTraversalList(root.right,list);
    }
    public boolean isSymmetric(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inOrderTraversalList(root,list);
        System.out.println(Arrays.toString(list.toArray()));
        int i, j;
        for(i=0,j=list.size()-1;i<list.size() && j>=0;i++,j--){
            if(list.get(i) != list.get(j)){
                break;
            }
        }
        return i==j;
    }*/
}
