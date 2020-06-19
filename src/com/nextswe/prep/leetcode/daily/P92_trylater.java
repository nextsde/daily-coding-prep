package com.nextswe.prep.leetcode.daily;


class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class P92 {
//    public void pPrint(ListNode head){
//        ListNode temp = head;
//        while(temp!=null){
//            System.out.print(temp.val+" ");
//            temp = temp.next;
//        }
//        System.out.println();
//    }
//
//    public ListNode rPrint(ListNode head, int m, int n){
//        if(head.val>n){
//            return head;
//        }
//        if(head.val>=m && head.val<=n){
//            rPrint(head.next,m,n);
//            System.out.print(head.val+" ");
//        }else{
//            System.out.print(head.val+" ");
//            rPrint(head.next,m,n);
//        }
//        return head;
//    }
//
//    public ListNode reverseList(ListNode current){
//        if(current.next==null){
//            head = current;
//        }else{
//            ListNode node = reverseList(current.next);
//            node.next = current;
//        }
//        return current;
//    }

    private ListNode mHead;
    public ListNode reverseList(ListNode current){
        if(current.next==null){
            mHead = current;
        }else{
            ListNode node = reverseList(current.next);
            node.next = current;
        }
        return current;
    }

    public void pPrint(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    /*
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode subHead = null, current = head;
        int i;
        for(i=1;i<m;i++){
            subHead = current;
            current = current.next;
        }
        ListNode firstCurrent = current, next = null, prev = null;
        while(i<=n){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
        firstCurrent.next = next;
        if(subHead!=null){
            subHead.next = prev;
        }else{
            head = prev;
        }
        return head;
    }
    */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode subHead = null, current = head;
        int i;
        for(i=1;i<m;i++){
            subHead = current;
            current = current.next;
        }
        ListNode firstCurrent = current, next = null, prev = null;
        while(i<=n){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
        firstCurrent.next = next;
        if(subHead!=null){
            subHead.next = prev;
        }else{
            head = prev;
        }
        return head;
    }

    public ListNode reverseIterative(ListNode head){
        ListNode current = head, next, prev = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }



    public static void main(String[] args){
        P92 mP92 = new P92();
        {
            ListNode head = new ListNode(1);
            ListNode temp = head;
            temp.next = new ListNode(2);
            temp = temp.next;
            temp.next = new ListNode(3);
            temp = temp.next;
            temp.next = new ListNode(4);
            temp = temp.next;
            temp.next = new ListNode(5);
            ListNode node = mP92.reverseBetween(head,1,2);
            mP92.pPrint(node);
        }

        {
            ListNode head = new ListNode(1);
            ListNode temp = head;
            temp.next = new ListNode(2);
            temp = temp.next;
            temp.next = new ListNode(3);
            temp = temp.next;
            temp.next = new ListNode(4);
            temp = temp.next;
            temp.next = new ListNode(5);
            ListNode node = mP92.reverseBetween(head,2,3);
            mP92.pPrint(node);
        }

        {
            ListNode head = new ListNode(1);
            ListNode temp = head;
            temp.next = new ListNode(2);
            temp = temp.next;
            temp.next = new ListNode(3);
            temp = temp.next;
            temp.next = new ListNode(4);
            temp = temp.next;
            temp.next = new ListNode(5);
            ListNode node = mP92.reverseBetween(head,2,4);
            mP92.pPrint(node);
        }

        {
            ListNode head = new ListNode(1);
            ListNode temp = head;
            temp.next = new ListNode(2);
            temp = temp.next;
            temp.next = new ListNode(3);
            temp = temp.next;
            temp.next = new ListNode(4);
            temp = temp.next;
            temp.next = new ListNode(5);
            ListNode node = mP92.reverseBetween(head,3,4);
            mP92.pPrint(node);
        }

        {
            ListNode head = new ListNode(1);
            ListNode temp = head;
            temp.next = new ListNode(2);
            temp = temp.next;
            temp.next = new ListNode(3);
            temp = temp.next;
            temp.next = new ListNode(4);
            temp = temp.next;
            temp.next = new ListNode(5);
            ListNode node = mP92.reverseBetween(head,3,3);
            mP92.pPrint(node);
        }

        {
            ListNode head = new ListNode(1);
            ListNode temp = head;
            temp.next = new ListNode(2);
            temp = temp.next;
            temp.next = new ListNode(3);
            temp = temp.next;
            temp.next = new ListNode(4);
            temp = temp.next;
            temp.next = new ListNode(5);
            ListNode node = mP92.reverseBetween(head,1,5);
            mP92.pPrint(node);
        }
    }
}
