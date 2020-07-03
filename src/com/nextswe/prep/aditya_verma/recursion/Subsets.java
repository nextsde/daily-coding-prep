package com.nextswe.prep.aditya_verma.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
    private static void solve(String ip, String op){
        if(ip.length()==0){
            System.out.println(op);
            return;
        }
        String op1 = op;
        String op2 = op;
        op2 = op2 + ip.substring(0,1);
        ip = ip.substring(1);
        solve(ip,op2);
        solve(ip,op1);
    }

    private static void decisionTaker(String input, String output, int start, int end){
        if(start==end){
            System.out.println(output);
        }else{
            //we need take decision as to whether to choose the character from the input or not
            decisionTaker(input, output, start+1,end);
            decisionTaker(input, output+input.substring(start,start+1), start+1,end);
        }
    }


    private static void subsetsWithDup(List<List<Integer>> res, List<Integer> op, int start, int[] nums) {
        if(start==nums.length){
            res.add(op);
            return;
        }
        List<Integer> op1 = new ArrayList<>(op);
        List<Integer> op2 = new ArrayList<>(op);
        op2.add(nums[start]);
        subsetsWithDup(res, op1, start+1,nums);
        subsetsWithDup(res, op2, start+1,nums);
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res1 = new ArrayList<>();
        subsetsWithDup(res1, new ArrayList<>(),0,nums);
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> res2 = new ArrayList<>();
        for(List<Integer> lst:res1){
            int bitChecker = 0;
            for(int a:lst){
                bitChecker |=(1<<a);
            }
            System.out.println(bitChecker);
            if(!set.contains(bitChecker)){
                res2.add(lst);
            }
            set.add(bitChecker);
        }
        return res2;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = stringToIntegerArray("[4,4,4,1,4]");

        List<List<Integer>> ret = subsetsWithDup(nums);

        String out = int2dListToString(ret);

        System.out.print(out);
    }

//    public static void main(String[] args){
//
//
//        solve("abc","");
//        Set<Integer[]> set = new HashSet<>();
//        set.add(new Integer[]{1,2});
//        if(set.contains(new Integer[]{1,2})){
//            System.out.println("ASAS");
//        }else{
//            System.out.println("NNNNASAS");
//        }
//        decisionTaker("abc", "",0,3);
//    }
}
