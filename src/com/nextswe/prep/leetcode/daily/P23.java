package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.leetcode.helpers.ListNode;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class P23 {
    //having trouble with edge case analysis
    //need more practice and thinking to come up with edge cases
    /*
    Runtime: 180 ms, faster than 12.19% of Java online submissions for Merge k Sorted Lists.
    Memory Usage: 41.1 MB, less than 44.27% of Java online submissions for Merge k Sorted Lists.
     */
    public ListNode sortHelper(ListNode list1, ListNode list2){
        if(list1==null || list2==null){
            return list1==null?list2:list1;
        }
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode head;

        if(temp1.val<=temp2.val){
            head = temp1;
            temp1 = temp1.next;
        }else{
            head = temp2;
            temp2 = temp2.next;
        }
        ListNode current = head;

        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                current.next = temp1;
                temp1 = temp1.next;
            }else{
                current.next = temp2;
                temp2 = temp2.next;
            }
            current = current.next;
        }
        while(temp1!=null){
            current.next = temp1;
            temp1 = temp1.next;
            current = current.next;
        }

        while(temp2!=null){
            current.next = temp2;
            temp2 = temp2.next;
            current = current.next;
        }
        return head;
    }
/*    public ListNode mergeKLists(ListNode[] lists) {
        ListNode sortedList = lists[0];
        int n = lists.length;
        for(int i=1;i<n;i++){
            sortedList = sortHelper(sortedList,lists[i]);
        }
        return sortedList;
    }*/

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode sortedList = lists[0];
        int n = lists.length;
        Deque<ListNode> dq = new LinkedList<>();
        for(int i=0;i<n;i++){

            sortedList = sortHelper(sortedList,lists[i]);
        }
        return sortedList;
    }

/*
    //solution by others
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;

        PriorityQueue<ListNode> minHeap= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                minHeap.add(node);

        while (!minHeap.isEmpty()){
            tail.next=minHeap.poll();
            tail=tail.next;

            if (tail.next!=null)
                minHeap.add(tail.next);
        }
        return dummy.next;
    }
*/

    public static void main(String[] args){

    }
}
