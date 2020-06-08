package com.nextswe.prep.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

public class P518_trylater {
    private void change(int amount, int rSum, int[] coins, List<Integer> lst){
        if(amount==rSum){
            lst.add(rSum);
            return;
        }
        for(int i=0;i<coins.length;i++){
            if(rSum+coins[i]<=amount){
                change(amount, rSum+coins[i], coins ,lst);
            }
        }
    }
    public int change(int amount, int[] coins) {
        List<Integer> res = new ArrayList<>();
        change(amount,0,coins,res);
        return res.size();
    }
}
