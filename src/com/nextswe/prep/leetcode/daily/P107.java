package com.nextswe.prep.leetcode.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> deq = new ArrayList<>();
        if(root==null){
         return deq;
        }
        Queue<TreeNode> qq = new LinkedList<>();
        qq.add(root);
        List<Integer> level = null;
        while(!qq.isEmpty()){
            int qsize = qq.size();
            level = new ArrayList<>();
            while(qsize>0){
                TreeNode node = qq.remove();
                level.add(node.val);
                qsize--;

                if(node.left!=null) {
                    qq.add(node.left);
                }
                if(node.right!=null) {
                    qq.add(node.right);
                }
            }
            deq.add(0,level);
        }

        return deq;
    }
}
