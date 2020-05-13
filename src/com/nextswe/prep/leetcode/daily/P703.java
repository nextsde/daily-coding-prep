package com.nextswe.prep.leetcode.daily;

import java.util.PriorityQueue;

public class P703 {
    public static void main(String[] args){
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }
}

class KthLargest {
    PriorityQueue<Integer> minHeap;
    int kk = 0;

    public KthLargest(int k, int[] nums) {
        kk = k;
        minHeap = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            minHeap.add(nums[i]);
        }
    }

    public int add(int val) {
        minHeap.add(val);
        while(minHeap.size()>kk){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
/*
class KthLargest {
    List<Integer> list;
    int kk = 0;
    public void insertion_sort(int item){
        int i=0;
        for(i=0; i<list.size(); i++){
            if(list.get(i)>item){
                break;
            }
        }
        list.add(i,item);
    }

    public KthLargest(int k, int[] nums) {
        kk = k;
        list = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            insertion_sort(nums[i]);
        }
    }

    public int add(int val) {
        insertion_sort(val);
        return list.get(list.size()-kk);
    }
}
*/

