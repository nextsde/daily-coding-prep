package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.leetcode.helpers.TreeNode;

import java.util.*;

public class P1302 {
    public int deepestLeavesSum(TreeNode root) {
        int deepSum = 0;
        Queue<TreeNode> qq = new LinkedList<>();
        qq.add(root);
        while(!qq.isEmpty()){
            int nq = qq.size();
            deepSum = 0;
            for(int i=0;i<nq;i++){
                TreeNode tmp = qq.remove();
                if(tmp.left!=null){
                    qq.add(tmp.left);
                }
                if(tmp.right!=null){
                    qq.add(tmp.right);
                }
                if(tmp.left==null && tmp.right == null){
                    deepSum +=tmp.val;
                }
            }
        }
        return deepSum;
    }

/*
    public int deepestLeavesSum(TreeNode root) {
        int deepSum = 0;
        Queue<TreeNode> qq = new LinkedList<>();
        qq.add(root);
        List<TreeNode> level = new ArrayList<>();
        while(!qq.isEmpty()){
            int nq = qq.size();
            for(int i=0;i<nq;i++){
                TreeNode tmp = qq.remove();
                if(tmp.left!=null){
                    level.add(tmp.left);
                }
                if(tmp.right!=null){
                    level.add(tmp.right);
                }
                if(tmp.left==null && tmp.right == null){
                    deepSum +=tmp.val;
                }
            }
            if(level.size()>0){
                qq.addAll(level);
                deepSum = 0;
                level.clear();
            }
        }
        return deepSum;
    }
*/


}
