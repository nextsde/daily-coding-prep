package com.nextswe.prep.leetcode.daily;


class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class P92 {

    public void pPrint(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode rPrint(ListNode head, int m, int n){
        if(head.val>n){
            return head;
        }
        if(head.val>=m && head.val<=n){
            rPrint(head.next,m,n);
            System.out.print(head.val+" ");
        }else{
            System.out.print(head.val+" ");
            rPrint(head.next,m,n);
        }
        return head;
    }

    public static void main(String[] args){
        P92 mP92 = new P92();

        ListNode head = new ListNode(1);

        ListNode temp = head;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);

        mP92.rPrint(head,2,4);
    }
}
