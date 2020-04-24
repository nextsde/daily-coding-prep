package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.leetcode.helpers.ListNode;

public class P1290 {

    //accepted: could be better
    public int helper(ListNode current, int times) {
        if(current==null){
            return 0;
        }
        int currentVal = current.val << times;
        return currentVal + helper(current.next, times-1);
    }

    public int getDecimalValue(ListNode head) {
        if(head==null){
            return 0;
        }
        ListNode temp = head;
        int times=0;
        while(temp.next!=null){
            times++;
            temp = temp.next;
        }
        return helper(head,times);
    }

    //better solution by others:
/*
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = (ans << 1) | head.val;
            head = head.next;
        }
        return ans;
    }
    or
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = (ans * 2) + head.val;
            head = head.next;
        }
        return ans;
    }
*/
}
