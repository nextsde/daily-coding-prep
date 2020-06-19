package com.nextswe.prep.leetcode.daily;

import java.util.*;

public class P752_trylater {
    //first attempt somewhat memory intensive exponential way
//    static void opc(String prefix, List<String> steps, Set<String> set,String target){
////        if(prefix.length()<4){
////            for(int i=0;i<=9;i++){
////                String pref = prefix+i;
////
////                if(!set.contains(pref) && pref.length()==4){
////                    steps.add(pref);
////                }
////                opc(pref,steps,set,target);
//////                if(pref.equals(target)){
//////                    return;
//////                }
//////                if(!set.contains(pref) && pref.length()==4){
//////                    steps.remove(steps.size()-1);
//////                }
////
//////                if(!set.contains(pref)){
//////                    if(pref.length()==4){
//////                        steps.add(pref);
//////                    }
//////                    opc(pref,steps,set,target);
//////                    if(pref.equals(target)){
//////                        return;
//////                    }
//////                    if(pref.length()==4){
//////                        steps.remove(steps.size()-1);
//////                    }
//////                }
////            }
////        }
////    }

    static void opc(int[] arr, int start, int end){
        if(start>end){
            System.out.println(Arrays.toString(arr));
        }else{
            for(int i=0;i<=9;i++){
                arr[start] = (arr[start]+1)%10;
                opc(arr,start+1,end);
            }
        }
    }
    public static int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for(String str:deadends){
            set.add(str);
        }
        List<String> steps = new ArrayList<>();
        int[] arr = new int[]{0,0,0,0};
        opc(arr,0,3);
        System.out.println(steps.toString());
        return 1;
    }
    public static void main(String[] args){
        openLock(new String[]{"0201","0101","0102","1212","2002"},"0202");
    }
}
