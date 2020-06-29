package com.nextswe.prep.aditya_verma.recursion;

import com.nextswe.prep.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SortByRecursion {
    public static void sort(int[] nums, int n){
        //base condition
        if(n==0){
            return;
        }
        //hypothesis
        sort(nums, n-1);
        //induction iterative approach
        int nth = nums[n];
        for(int i=0;i<=n;i++){
            if(nums[i]>nth){
                int cur = nums[i];
                nums[i] = nth;
                i++;
                while(i<n){
                    int c = nums[i];
                    nums[i] = cur;
                    cur = c;
                    i++;
                }
                nums[n] = cur;
            }
        }
    }

    public static void sort(List<Integer> nums){
        //base condition
        if(nums.size()==1){
            return;
        }
        //hypothesis
        int tmp = nums.get(nums.size()-1);
        nums.remove(nums.size()-1);
        sort(nums);
        //induction recursive approach
        insert(nums,tmp);
    }

    public static void insert(List<Integer> nums, int temp){
        //base condition
        if(nums.size()==0 || nums.get(nums.size()-1)<=temp){
            nums.add(temp);
            return;
        }
        //hypothesis
        int tm = nums.get(nums.size()-1);
        nums.remove(nums.size()-1);
        insert(nums,temp);
        //induction
        nums.add(tm);
    }

    private static void sort_s(Stack<Integer> stk){
        if(stk.size()==1){
            return;
        }
        int top = stk.pop();
        sort_s(stk);
        insert_s(stk,top);
    }

    private static void insert_s(Stack<Integer> sorted_stk, int val){
        if(sorted_stk.size()==0 || sorted_stk.peek()<=val){
            sorted_stk.push(val);
            return;
        }
        int top = sorted_stk.pop();
        insert_s(sorted_stk,val);
        sorted_stk.push(top);
    }


    private static void sort_r (List<Integer> lst){
        if(lst.size()==1){
            return;
        }
        int val = lst.get(lst.size()-1);
        lst.remove(lst.size()-1);
        sort_r(lst);
        insert_r(lst,val);
    }

    private static void insert_r(List<Integer> sorted, int temp){
        if(sorted.size()==0 || sorted.get(sorted.size()-1)<=temp){
            sorted.add(temp);
            return;
        }
        int val = sorted.get(sorted.size()-1);
        sorted.remove(sorted.size()-1);
        insert_r(sorted,temp);
        sorted.add(val);
    }

    private static Stack<Integer> delete(Stack<Integer> stk, int k){
        if(k==1){
            stk.pop();
            return stk;
        }
        int top = stk.pop();
        Stack<Integer> st = delete(stk,k-1);
        st.push(top);
        return st;
    }
    private static Stack<Integer> deleteMid(Stack<Integer> stk){
        //edge case
        if(stk.size()==0){
            return stk;
        }
        int mid = stk.size()/2 + 1;
        return delete(stk,mid);
    }

    private static void reverse_r(Stack<Integer> stk){
        if(stk.size()==1){
            return;
        }
        int top = stk.pop();
        reverse_r(stk);
        ins_r(stk,top);
    }

    private static void ins_r(Stack<Integer> stk, int val){
        if(stk.size()==0){
            stk.push(val);
            return;
        }
        int top = stk.pop();
        ins_r(stk,val);
        stk.push(top);
    }

    private static void reverse(Stack<Integer> stk){
        if(stk.size()==0){
            return;
        }
        reverse_r(stk);
    }


    public static void main(String[] args){
        Stack<Integer> list = new Stack<>();
        list.push(44);
        list.push(2);
        list.push(3);
        list.push(55);
        list.push(5);
        reverse(list);
        while(!list.isEmpty()){
            System.out.println(list.pop());
        }
//        sort_r(list);
//        Utils.printList(list);
    }
}
