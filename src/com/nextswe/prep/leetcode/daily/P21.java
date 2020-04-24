package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.leetcode.helpers.ListNode;

public class P21 {
    //my solution
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tmp = null;
        ListNode temp1 = null;
        ListNode temp2 = null;
        boolean equal = false;
        while(l1!=null && l2 !=null){
            equal = false;
            temp1 = new ListNode();
            if(l1.val>l2.val){
                temp1.val = l2.val;
                l2 = l2.next;
            }else if(l1.val<l2.val){
                temp1.val = l1.val;
                l1 = l1.next;
            }else {
                equal = true;
                temp1.val = l1.val;
                temp2 = new ListNode();
                temp2.val = l2.val;

                l2 = l2.next;
                l1 = l1.next;
            }

            if(tmp!=null){
                if(equal){
                    tmp.next = temp1;
                    tmp = tmp.next;
                    tmp.next = temp2;
                    tmp = tmp.next;
                }else{
                    tmp.next = temp1;
                    tmp = tmp.next;
                }
            }else{
                head = temp1;
                tmp = head;
                if(equal){
                    tmp.next = temp2;
                    tmp = tmp.next;
                }
            }
        }
        return head;
    }

    //solution by others
/*
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2!= null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null? l2:l1;
        return dummy.next;
    }
 */
}
