package com.nextswe.prep.leetcode.april30;

import java.util.HashSet;
import java.util.Set;

public class P202 {
    // solution 3 //accepted
    // was stuck had get some idea from discusssion without looking at the solution
    // heard about floyd cycle detection algorithm
    // that means if after some time number start repeating then it has cycle
    // in that case we need to return false;
    // used hashset instead of pointers. since all i had to check whether the number contains in the set or not
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int val = n;
        int new_val = 0;
        int digit = 0;
        while(true){
            digit = val % 10;
            val = val/10;
            new_val += (digit*digit);
            if(val==0){
                if(new_val == 1){
                    return true;
                }
                if(set.contains(new_val)){
                    return false;
                }
                set.add(new_val);
                val = new_val;
                new_val = 0;
            }
        }
    }
    //solution 2
/*
    public boolean isHappy(int n) {
        int val = n;
        int new_val = 0;
        int val_tracker = val;
        int digit = 0;
        while(true){
            digit = val % 10;
            val = val/10;
            new_val += (digit*digit);
            if(val==0){
                if(new_val == 1){
                    return true;
                }
                if(val_tracker == new_val){
                    return false;
                }
                val_tracker = new_val;
                val = new_val;
                new_val = 0;
            }
        }
    }
*/

    // solution 1
/*
    public int getDivider(int val){
        int divider = 10;
        while(val>=divider){
            divider *= 10;
        }
        return divider/10;
    }

    public boolean isHappy(int n) {
        int val = n;
        int new_val = 0;
        int val_tracker = val;
        int divider = getDivider(val);
        int digit = 0;
        while(true){
            if(val>9){
                digit = val / divider;
                val = val - (digit*divider);
            }else{
                digit = val;
                val = val - digit;
            }
            divider = divider/10;
            new_val += (digit*digit);
            if(val==0){
                if(new_val == 1){
                    return true;
                }
                if(val_tracker == new_val){
                    return false;
                }
                val_tracker = new_val;
                divider = getDivider(new_val);
                val = new_val;
                new_val = 0;
            }
        }
    }
*/
}
