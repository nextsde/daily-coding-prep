package com.nextswe.prep.leetcode.daily;

import com.nextswe.prep.utils.Utils;

import java.util.*;

public class P1002 {
//    public List<String> commonChars(String[] A) {
//        List<String> lst = new ArrayList<>();
//        if(A.length>0){
//            Map<Integer, Map<Character,Integer>> map = new HashMap<>();
//            Set<Character> set = new HashSet<>();
//
//            int index = 0;
//            for(int i=0;i<A[0].length();i++){
//                set.add(A[0].charAt(i));
//            }
//            for(String str: A){
//                for(int i=0;i<str.length();i++){
//                    char c = str.charAt(i);
//                    if(set.contains(c)){
//                        Map<Character,Integer> mm;
//                        if(map.containsKey(index)){
//                            mm = map.get(index);
//                        }else{
//                            mm = new HashMap<>();
//                            map.put(index,mm);
//                        }
//                        mm.put(c, mm.getOrDefault(c,0)+1);
//                    }
//                }
//                index++;
//            }
//            Iterator<Character> set_itr = set.iterator();
//
//            while(set_itr.hasNext()){
//                char cc = set_itr.next();
//                int id = index-1;
//                int min = Integer.MAX_VALUE;
//                while(id>=0){
//                    Map<Character,Integer> mm = map.get(id);
//                    if(!mm.containsKey(cc)){
//                        min = Integer.MAX_VALUE;
//                        break;
//                    }
//                    if(mm.get(cc)<min){
//                        min = mm.get(cc);
//                    }
//                    id--;
//                }
//                if(min!=Integer.MAX_VALUE){
//                    while(min>0){
//                        lst.add(cc+"");
//                        min--;
//                    }
//                }
//            }
//        }
//        return lst;
//    }

    public List<String> commonChars(String[] A) {
        List<String> lst = new ArrayList<>();
        if(A.length>0){
            int[] res = new int[26];
            Arrays.fill(res,Integer.MAX_VALUE);

            int[] s1 = new int[26];

            for(int i=0;i<A[0].length();i++){
                s1[A[0].charAt(i)-'a']++;
            }
            for(int i=1;i<A.length;i++){
                int[] s2 = new int[26];
                for(int j=0;j<A[i].length();j++){
                    s2[A[i].charAt(j)-'a']++;
                }
                for(int k=0;k<26;k++){
                    if(s2[k]>0){
                        res[k] = Math.min(res[k],Math.min(s1[k],s2[k]));
                    }else{
                        res[k] = 0;
                    }
                }
            }
            for(int k=0;k<26;k++){
                int min = res[k];
                while(min>0){
                    char cc = (char) ('a' + k);
                    lst.add(cc+"");
                    min--;
                }
            }
        }
        return lst;
    }
    public static void main(String[] args){
        P1002 mP1002 = new P1002();
        Utils.printListString(mP1002.commonChars(
                new String[]{"bella","label","roller"}
        ));

//        Utils.printListString(mP1002.commonChars(
//                new String[]{"cool","lock","cook"}
//        ));
    }
}
